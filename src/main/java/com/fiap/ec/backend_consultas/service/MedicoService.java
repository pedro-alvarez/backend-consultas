package com.fiap.ec.backend_consultas.service;

import com.fiap.ec.backend_consultas.model.Medico;
import com.fiap.ec.backend_consultas.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico salvar(Medico medico) {
        return repository.save(medico);
    }

    public List<Medico> listar() {
        return repository.findAll();
    }

    public Medico buscarPorId(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Médico não encontrado"));
    }

    public Medico atualizar(Long id, Medico medico) {
        Medico existente = buscarPorId(id);

        existente.setNome(medico.getNome());
        existente.setCrm(medico.getCrm());
        existente.setEspecialidade(medico.getEspecialidade());
        existente.setAtivo(medico.getAtivo());

        return repository.save(existente);
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}