package br.com.gid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gid.entities.Produto;
import br.com.gid.repositories.ProdutoRepository;

@Service
public class ProdutoService {

    private final ProdutoRepository produtoRepository;

    @Autowired
    public ProdutoService(ProdutoRepository produtoRepository) {
        this.produtoRepository = produtoRepository;
    }

    public Page<Produto> getAll(int offset, int limit) {
    	Pageable pageable = PageRequest.of(offset, limit);
        return produtoRepository.findAll(pageable);
    }
}
