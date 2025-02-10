package com.araujo.Gerenciamento_Alimentos.controller;

import com.araujo.Gerenciamento_Alimentos.model.Alimento;
import com.araujo.Gerenciamento_Alimentos.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/alimentos")
public class AlimentoController {

    @Autowired
    private AlimentoService alimentoService;

    @GetMapping
    public List<Alimento> listarTodos() {
        return alimentoService.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Alimento> buscarPorId(@PathVariable Long id) {
        Optional<Alimento> alimento = alimentoService.buscarPorID(id);
        return alimento.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
    @PostMapping
    public ResponseEntity<Alimento> adicionar(@RequestBody Alimento alimento) {
       return ResponseEntity.ok(alimentoService.salvar(alimento));
    }
    @PutMapping("/{id}")
    public  ResponseEntity<Alimento> atualizar(@PathVariable Long id, @RequestBody Alimento alimento) {
        if (!alimentoService.buscarPorID(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alimento.setId(id);
        return ResponseEntity.ok(alimentoService.salvar(alimento));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Alimento> excluir(@PathVariable Long id) {
        if (!alimentoService.buscarPorID(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        alimentoService.excluir(id);
        return ResponseEntity.ok().build();
    }
}