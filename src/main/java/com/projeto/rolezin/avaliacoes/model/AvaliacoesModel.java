package com.projeto.rolezin.avaliacoes.model;

import com.projeto.rolezin.avaliacoes.EnumNotas;
import com.projeto.rolezin.eventos.model.EventosModel;
import com.projeto.rolezin.usuários.model.UsuariosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Avaliacoes")
public class AvaliacoesModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAvaliacoes;

    @Column(columnDefinition = "text", name = "avaliacao")
    private String avaliacao;

    @Column(name = "nota")
    private EnumNotas nota;

    @ManyToOne(optional = false)
    private UsuariosModel usuario;

    @ManyToOne(optional = false)
    private EventosModel evento;


}
