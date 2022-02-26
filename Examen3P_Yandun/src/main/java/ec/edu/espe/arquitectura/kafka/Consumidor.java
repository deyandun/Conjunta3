/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kafka;

import ec.edu.espe.arquitectura.kafka.controller.TransaccionController;
import ec.edu.espe.arquitectura.kafka.model.Transaccion;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Slf4j
@Component
public class Consumidor {

    private final TransaccionController mensajeController;
    private RestTemplate restTemplate = new RestTemplate();

    public Consumidor(TransaccionController mensajeController) {
        this.mensajeController = mensajeController;
    }

    @KafkaListener(
            topics = "transaccion",
            groupId = "groupId"
    )
    public void Listener(Transaccion t) {
        this.restTemplate.postForObject("http://localhost:8080/api/transaccion", t, Transaccion.class);
    }
}
