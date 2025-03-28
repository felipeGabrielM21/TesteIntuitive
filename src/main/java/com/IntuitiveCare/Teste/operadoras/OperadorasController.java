package com.IntuitiveCare.Teste.operadoras;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/operadoras")
public class OperadorasController {

    private final OperadorasRepository operadorasRepository;

    public OperadorasController(OperadorasRepository operadorasRepository) {
        this.operadorasRepository = operadorasRepository;
    }


    @GetMapping("/{id}")
    public ResponseEntity<ListarOperadora> listar(@PathVariable Long id) {
        var operadora = operadorasRepository.findById(id);

        if (operadora.isPresent()) {
            ListarOperadora listarOperadora = new ListarOperadora(operadora.get());
            return ResponseEntity.ok(listarOperadora);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @GetMapping
    public ResponseEntity<List<ListarOperadora>> listarTodas() {
        var operadoras = operadorasRepository.findAll();
        var listaOperadoras = operadoras.stream().map(ListarOperadora::new).toList();
        return ResponseEntity.ok(listaOperadoras);
    }


}
