package br.com.gid.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.gid.entities.Cliente;

public interface ClienteRepository extends PagingAndSortingRepository<Cliente, Integer> {

	Page<Cliente> findAll(Pageable pageable);

}
