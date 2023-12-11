package br.com.gid.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.gid.entities.TrabalhoDET;
import br.com.gid.entities.TrabalhoDETPK;

@EnableJpaRepositories
public interface TrabalhoDetRepository extends PagingAndSortingRepository<TrabalhoDET, TrabalhoDETPK> {
	
	Page<TrabalhoDET> findByTrabalhoDETPKTrabalhoId(Pageable pageable, int trabalhoId);
}