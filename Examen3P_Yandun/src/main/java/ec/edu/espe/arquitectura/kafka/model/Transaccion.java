/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.edu.espe.arquitectura.kafka.model;

import com.github.javafaker.DateAndTime;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Transaccion")
public class Transaccion implements Serializable {

    private static final long serialVersionUID = 123456L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cod_transaccion", nullable = false)
    private Integer codigoPersona;

    @Column(name = "valor_pago", nullable = false, length = 50)
    private Number valor_pago;

    @Column(name = "fecha_pago", nullable = false, length = 50)
    private DateAndTime fecha_pago;

    @Column(name = "hora_pago", nullable = false, length = 10)
    private DateAndTime hora_pago;

    @Column(name = "nro_cuota", nullable = false, length = 150)
    private Integer nro_cuota;



    

}
