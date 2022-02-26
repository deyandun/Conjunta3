/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kafka.service;

import ec.edu.espe.arquitectura.kafka.model.Transaccion;
import org.springframework.stereotype.Service;
import ec.edu.espe.arquitectura.kafka.dao.TransaccionRepository;


@Service
public class TransaccionService {

    private final TransaccionRepository transaccionRepository;

    public TransaccionService(TransaccionRepository transaccionRepository) {
        this.transaccionRepository = transaccionRepository;
    }

    public void guardarTransaccion(Transaccion t) {
        this.transaccionRepository.save(t);
    }
}
