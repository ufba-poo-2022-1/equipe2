package com.projeto.rolezin.usuários.model;

import javax.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="usuarios")
public class UsuariosModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @NotNull(message = "Digite seu nome")
    @NotEmpty(message = "Digite seu nome")
    @Length(max = 150,message = "Quantidade de caracteres excedida")
    private String nome;

    @NotNull(message = "Digite seu nome")
    @NotEmpty(message = "Digite seu nome")
    @Email(message = "email inválido")
    private String email;

    @NotNull(message = "Digite seu nome")
    @NotEmpty(message = "Digite seu nome")
    private String login;

    @NotNull(message = "Digite seu nome")
    @NotEmpty(message = "Digite seu nome")
    private String senha;

    @NotEmpty(message = "Não é possível prosseguir com a criação da conta")
    private Boolean verificada;

    @NotNull(message = "Digite seu nome")
    @NotEmpty(message = "Digite seu nome")
    private String estado;

    @NotNull(message = "Digite seu nome")
    @NotEmpty(message = "Digite seu nome")
    private String cidade;

    @NotNull(message = "Digite seu nome")
    @NotEmpty(message = "Digite seu nome")
    private String bairro;
}

