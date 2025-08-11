package com.example.terefas_Enos_Emanuel_RU_4729720.dtos;

import java.time.LocalDate;

public record AtualizarTarefaDto(String nome, LocalDate dataDeEntrega, String responsavel) {
}
