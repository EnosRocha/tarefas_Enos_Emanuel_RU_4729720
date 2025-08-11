package com.example.terefas_Enos_Emanuel_RU_4729720.repository;

import com.example.terefas_Enos_Emanuel_RU_4729720.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRespository extends JpaRepository<Tarefa, Long> {
}
