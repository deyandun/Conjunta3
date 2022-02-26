package ec.edu.espe.arquitectura.kafka;

import com.github.javafaker.Faker;
import ec.edu.espe.arquitectura.kafka.model.Transaccion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaProducerException;
import org.springframework.kafka.core.KafkaSendCallback;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.util.concurrent.ListenableFuture;

@SpringBootApplication
@Slf4j
public class Productor {
    
    public static void main(String[] args) {
        SpringApplication.run(Productor.class, args);
    }
    
    @Bean
    CommandLineRunner commandLineRunner(KafkaTemplate<String, Object> kafkaTemplate) {
        return args -> {
            Faker faker = new Faker();
            Transaccion transaccion = new Transaccion();
            for (int i = 0; i < 10000; i++) {
                transaccion.setFecha_pago(faker.date());
                transaccion.setHora_pago(faker.date());

                ListenableFuture<SendResult<String, Object>> send = kafkaTemplate.send("transaccion", transaccion);
                send.addCallback(new KafkaSendCallback<String, Object>() {
                    @Override
                    public void onSuccess(SendResult<String, Object> result) {
                        log.info("{}",result.getRecordMetadata());
                    }
                    
                    @Override
                    public void onFailure(Throwable ex) {
                        log.error("Error {}",ex);
                    }
                    
                    @Override
                    public void onFailure(KafkaProducerException ex) {
                         log.error("Error {}",ex); 
                    }
                    
                });
            }
        };
    }
}
