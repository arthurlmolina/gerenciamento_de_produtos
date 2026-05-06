package com.example.gerenciamento_de_produtos.services;

import com.example.gerenciamento_de_produtos.models.ProdutoModel;
import com.example.gerenciamento_de_produtos.repositories.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository produtoRepository;

    public ProdutoModel criarProduto(ProdutoModel produtoModel){
        return produtoRepository.save(produtoModel);
    }

    public List<ProdutoModel> findAll(){
        return produtoRepository.findAll();
    }

    public Optional<ProdutoModel> buscarId(Long id){
        return produtoRepository.findById(id);
    }

    public ProdutoModel atualizar(ProdutoModel produtoModel, Long id){
        ProdutoModel novoModel = produtoRepository.findById(id).get();
        novoModel.setNome(produtoModel.getNome());
        return produtoRepository.save(novoModel);
    }

    public void deletar(Long id){
        produtoRepository.deleteById(id);
    }



}
