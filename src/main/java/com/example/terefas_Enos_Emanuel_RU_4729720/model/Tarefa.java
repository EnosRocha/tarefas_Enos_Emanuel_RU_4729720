package com.example.terefas_Enos_Emanuel_RU_4729720.model;


import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tarefas_tb")
public class Tarefa implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long tarefasId;

    private String nomeDaTarefa;

    private LocalDate dataDeEntrega;

    private String  responsavel;

    public Long getTarefasId() {
        return tarefasId;
    }

    public LocalDate getDataDeEntrega() {
        return dataDeEntrega;
    }

    public void setDataDeEntrega(LocalDate dataDeEntrega) {
        this.dataDeEntrega = dataDeEntrega;
    }

    public String getNomeDaTarefa() {
        return nomeDaTarefa;
    }

    public void setNomeDaTarefa(String nomeDaTarefa) {
        this.nomeDaTarefa = nomeDaTarefa;
    }

    public String getResponsavel() {
        return responsavel;
    }

    public void setResponsavel(String responsavel) {
        this.responsavel = responsavel;
    }
}
