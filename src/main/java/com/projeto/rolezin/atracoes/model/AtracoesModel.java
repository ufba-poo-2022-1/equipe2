package com.projeto.rolezin.atracoes.model;

import com.projeto.rolezin.eventos.model.EventosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    @Column(columnDefinition = "TIME NOT NULL" ,name = "horario")
    private String horario;

    @Column(name = "tipo")
    private String tipo;

    @ManyToOne(optional = false)
    private EventosModel eventos;



}
