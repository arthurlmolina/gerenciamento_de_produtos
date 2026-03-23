package com.example.gerenciamento_de_produtos.controllers;

import com.example.gerenciamento_de_produtos.models.ProdutoModel;
import com.example.gerenciamento_de_produtos.services.ProdutoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/produtos")
public class produtoController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public ResponseEntity<List<ProdutoModel>> findAll(){
        List<ProdutoModel> request = produtoService.findAll();
        return ResponseEntity.ok().body(request);
    }

    @GetMapping("/{id}")
    public Optional<ProdutoModel> buscarId(@PathVariable Long id){
        return produtoService.buscarId(id);
    }

    @PostMapping
    public ResponseEntity<ProdutoModel> criar(@RequestBody ProdutoModel produtoModel){
        ProdutoModel request = produtoService.criarProduto(produtoModel);
        URI uri = ServletUriComponentsBuilder.
        fromCurrentRequestUri().path("/{id}").buildAndExpand(produtoModel.getId()).toUri();
        return ResponseEntity.created(uri).body(request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        produtoService.deletar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ProdutoModel atualizar(@RequestBody ProdutoModel produtoModel, @PathVariable Long id){
        return produtoService.atualizar(produtoModel, id);
    }



}
