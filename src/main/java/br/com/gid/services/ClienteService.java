package br.com.gid.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.gid.entities.Cliente;
import br.com.gid.repositories.ClienteRepository;

@Service
public class ClienteService {

    private final ClienteRepository clienteRepository;

    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    public Page<Cliente> getAll(int offset, int limit) {
    	Pageable pageable = PageRequest.of(offset, limit);
        return clienteRepository.findAll(pageable);
    }
}
