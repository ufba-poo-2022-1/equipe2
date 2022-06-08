package com.projeto.rolezin.atracoes.model;

import com.projeto.rolezin.eventos.model.EventosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Atracoes")
public class AtracoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAtracoes;

    @Column(name = "nome")
    private String nome;

    @Column(name = "horario")
    private Date horario;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(optional = false)
    private EventosModel eventos;



}
