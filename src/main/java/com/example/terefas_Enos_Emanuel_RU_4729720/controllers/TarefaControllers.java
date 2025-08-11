package com.example.terefas_Enos_Emanuel_RU_4729720.controllers;

import com.example.terefas_Enos_Emanuel_RU_4729720.dtos.AtualizarTarefaDto;
import com.example.terefas_Enos_Emanuel_RU_4729720.dtos.CriarTarefaDto;
import com.example.terefas_Enos_Emanuel_RU_4729720.model.Tarefa;
import com.example.terefas_Enos_Emanuel_RU_4729720.service.TarefasService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("tarefas")
public class TarefaControllers {

    private final TarefasService tarefasService;

    public TarefaControllers(TarefasService tarefasService) {
        this.tarefasService = tarefasService;
    }

    @PostMapping("/cadastrar")
    public ResponseEntity criarTarefaController(@RequestBody CriarTarefaDto criarTarefaDto) {
        tarefasService.criarNovaTarerfaService(criarTarefaDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/todastarefas")
    public ResponseEntity<List<Tarefa>> pegarTodasAsTarefasController() {
        List<Tarefa> response = tarefasService.pegarTodasAsTarefasService();
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/pegarporid/{id}")
    public ResponseEntity<Tarefa> pegarTarefaController(@PathVariable(value = "id") Long id) {
        Tarefa tarefa = tarefasService.pegarTarefaPorIdService(id);
        return ResponseEntity.status(HttpStatus.FOUND).body(tarefa);
    }

    @PutMapping("/atualizar/{id}")
    public ResponseEntity<Tarefa> atualizarTarefaController(@PathVariable(value = "id")Long id, AtualizarTarefaDto atualizarTarefaDto){
        Tarefa tarefa = tarefasService.atualizarTarefaService(id, atualizarTarefaDto);
        return ResponseEntity.status(HttpStatus.ACCEPTED).body(tarefa);

    }
    @DeleteMapping("/deletar/{id}")
    public ResponseEntity deletarTarefaPorId(@PathVariable(value = "id")Long id){
        tarefasService.deleteTarefaService(id);
        return ResponseEntity.ok().build();
    }
}
