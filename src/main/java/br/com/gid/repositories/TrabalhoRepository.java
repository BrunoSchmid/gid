package br.com.gid.repositories;

import java.util.Date;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import br.com.gid.entities.Trabalho;

@EnableJpaRepositories
public interface TrabalhoRepository extends PagingAndSortingRepository<Trabalho, Integer>, CrudRepository<Trabalho, Integer> {
	
	Page<Trabalho> findAllByArquivo(Pageable pageable, String arquivo);
	
	Page<Trabalho> findAllByArquivoAndDtRec(Pageable pageable, String arquivo, Date dtRec);

	Page<Trabalho> findAllByDtRec(Pageable pageable, Date dtRec);

	Page<Trabalho> findAllByDtRecBetween(Pageable pageable, Date dtRecStart, Date dtRecEnd);

	Page<Trabalho> findAllByArquivoAndDtRecBetween(Pageable pageable, String arquivo, Date dtRecStart, Date dtRecEnd);
}