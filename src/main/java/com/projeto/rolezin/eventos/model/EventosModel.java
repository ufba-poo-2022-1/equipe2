package com.projeto.rolezin.eventos.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data // cria getters e setters automáticos
@AllArgsConstructor // cria todos os métodos e construtores possíveis
@NoArgsConstructor // cria um construtor vazio
@Entity // mapeia a classe pra ser uma entidade no banco de dados
@Table(name="Eventos") // dá o nome ao banco de dados
public class EventosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // vai ter um identificador pra cada elemento do banco e o identificador gera automaticamente
    private Long idEventos;

    @Column(name="nome")
    @NotNull(message = "Você ultrapassou a quantidade máxima de caracteres")
    @NotEmpty(message = "Você ultrapassou a quantidade máxima de caracteres")
    @Length(max = 200, message = "Você ultrapassou a quantidade máxima de caracteres")
    private String nome;

    @Column(name="endereco")
    @NotNull(message = "Você ultrapassou a quantidade máxima de caracteres")
    @NotEmpty(message = "Você ultrapassou a quantidade máxima de caracteres")
    @Length(max = 500, message = "Você ultrapassou a quantidade máxima de caracteres")
    private String endereco;

    @Column(name="categoria")
    @NotNull(message = "Você ultrapassou a quantidade máxima de caracteres")
    @NotEmpty(message = "Você ultrapassou a quantidade máxima de caracteres")
    @Length(max = 100, message = "Você ultrapassou a quantidade máxima de caracteres")
    private String categoria;

    @Column(name="horario")
    @NotEmpty(message = "Você ultrapassou a quantidade máxima de caracteres")
    private Date horario;

    @Column(name="preco")
    @NotEmpty(message = "Você ultrapassou a quantidade máxima de caracteres")
    private Double preco;

    @Column(name="userId")
    @NotEmpty(message = "Você ultrapassou a quantidade máxima de caracteres")
    private Long UserId;

    @Column(name="atracoesId")
    @NotEmpty(message = "Você ultrapassou a quantidade máxima de caracteres")
    private Long atracoesId;

}
