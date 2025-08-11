package com.example.terefas_Enos_Emanuel_RU_4729720.dtos;

import java.time.LocalDateTime;

public record CriarTarefaDto(String nome, LocalDateTime dataDeEntrega, String responsavel) {
}
