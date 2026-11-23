
package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Atualizacao;
import br.edu.unifio.citysync.repositorios.AtualizacaoRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AtualizacaoService {

    private final AtualizacaoRepositorio atualizacaoRepositorio;

    public AtualizacaoService(AtualizacaoRepositorio atualizacaoRepositorio) {
        this.atualizacaoRepositorio = atualizacaoRepositorio;
    }

    public List<Atualizacao> listarTodas() {
        return atualizacaoRepositorio.findAll();
    }

    public Atualizacao buscarPorId(Integer id) {
        return atualizacaoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Atualização não encontrada"));
    }

    public Atualizacao salvar(Atualizacao atualizacao) {
        return atualizacaoRepositorio.save(atualizacao);
    }

    public void excluir(Integer id) {
        Atualizacao atualizacao = buscarPorId(id);
        atualizacaoRepositorio.delete(atualizacao);
    }
}
