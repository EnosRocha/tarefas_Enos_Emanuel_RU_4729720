package com.example.terefas_Enos_Emanuel_RU_4729720.service;

import com.example.terefas_Enos_Emanuel_RU_4729720.dtos.AtualizarTarefaDto;
import com.example.terefas_Enos_Emanuel_RU_4729720.dtos.CriarTarefaDto;
import com.example.terefas_Enos_Emanuel_RU_4729720.model.Tarefa;
import com.example.terefas_Enos_Emanuel_RU_4729720.repository.TarefaRespository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Stream;

@Service
public class TarefasService {

    private final TarefaRespository tarefaRespository;

    public TarefasService(TarefaRespository tarefaRespository) {
        this.tarefaRespository = tarefaRespository;
    }

    @Transactional
    public void criarNovaTarerfaService(CriarTarefaDto criarTarefaDto) {
        Tarefa tarefa = new Tarefa();
        tarefa.setNomeDaTarefa(criarTarefaDto.nome());
        tarefa.setDataDeEntrega(criarTarefaDto.dataDeEntrega());
        tarefa.setResponsavel(criarTarefaDto.responsavel());
        tarefaRespository.save(tarefa);
    }

    @Transactional
    public List<Tarefa> pegarTodasAsTarefasService() {
        List<Tarefa> tarefasResponse = tarefaRespository.findAll();
        return tarefasResponse;
    }

    @Transactional
    public Tarefa pegarTarefaPorIdService(Long id) {
        Tarefa tarefa = tarefaRespository.findById(id).orElseThrow(() -> new RuntimeException("tarefa nao encontrada"));
        return tarefa;

    }

    @Transactional
    public Tarefa atualizarTarefaService(Long id, AtualizarTarefaDto atualizarTarefaDto) {
        Tarefa tarefa = tarefaRespository.findById(id).orElseThrow(() -> new RuntimeException("tarefa nao encontrada"));
        if (atualizarTarefaDto.nome() != null) {
            tarefa.setNomeDaTarefa(atualizarTarefaDto.nome());
        }
        if (atualizarTarefaDto.responsavel() != null) {
            tarefa.setResponsavel(atualizarTarefaDto.responsavel());
        }
        if (atualizarTarefaDto.dataDeEntrega() != null) {
            tarefa.setDataDeEntrega(atualizarTarefaDto.dataDeEntrega());
        }

        return tarefaRespository.save(tarefa);
    }

    @Transactional
    public void deleteTarefaService(Long id){
        tarefaRespository.deleteById(id);
    }
}
