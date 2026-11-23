
package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Apoio;
import br.edu.unifio.citysync.repositorios.ApoioRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApoioService {

    private final ApoioRepositorio apoioRepositorio;

    public ApoioService(ApoioRepositorio apoioRepositorio) {
        this.apoioRepositorio = apoioRepositorio;
    }

    public List<Apoio> listarTodos() {
        return apoioRepositorio.findAll();
    }

    public Apoio buscarPorId(Integer id) {
        return apoioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Apoio não encontrado"));
    }

    public Apoio salvar(Apoio apoio) {
        return apoioRepositorio.save(apoio);
    }

    public void excluir(Integer id) {
        Apoio apoio = buscarPorId(id);
        apoioRepositorio.delete(apoio);
    }
}
