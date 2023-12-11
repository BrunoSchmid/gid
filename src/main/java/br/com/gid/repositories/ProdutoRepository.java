package br.com.gid.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.gid.entities.Produto;
import br.com.gid.entities.ProdutoPK;

public interface ProdutoRepository extends PagingAndSortingRepository<Produto, ProdutoPK> {

	Page<Produto> findAll(Pageable pageable);

}