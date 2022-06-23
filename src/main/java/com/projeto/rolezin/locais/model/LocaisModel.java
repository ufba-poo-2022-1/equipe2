package com.projeto.rolezin.locais.model;

import com.projeto.rolezin.usuários.model.UsuariosModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "Locais")
public class LocaisModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idLocais;

    @Column(name = "nome")
    private String nome;

    @Column(name = "categoria")
    private String categoria;

    @Column(name = "endereco")
    private String endereco;

    @ManyToOne(optional = false)
    private UsuariosModel usuario;

}
