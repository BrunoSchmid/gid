package br.com.gid.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.gid.entities.Senha;

public interface SenhaRepository extends CrudRepository<Senha, Integer> {
}
