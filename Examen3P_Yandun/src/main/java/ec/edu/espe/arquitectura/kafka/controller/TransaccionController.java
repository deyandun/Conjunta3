/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kafka.controller;

import ec.edu.espe.arquitectura.kafka.model.Transaccion;
import ec.edu.espe.arquitectura.kafka.service.TransaccionService;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("api/")
public class TransaccionController {

    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final TransaccionService transaccionService;

    public TransaccionController(KafkaTemplate<String, Object> kafkaTemplate, TransaccionService transaccionService) {
        this.kafkaTemplate = kafkaTemplate;
        this.transaccionService = transaccionService;
    }


    @PostMapping("transaccion")
    public void enviarMensaje(@RequestBody Transaccion t) {
        this.transaccionService.guardarTransaccion(t);
    }
}
