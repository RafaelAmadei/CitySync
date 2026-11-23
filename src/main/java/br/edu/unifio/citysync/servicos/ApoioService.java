package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Apoio;
import br.edu.unifio.citysync.repositorios.ApoioRepositorio;
import br.edu.unifio.citysync.excecoes.RecursoNaoEncontradoException;

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
                .orElseThrow(() -> new RecursoNaoEncontradoException(
        "Apoio não encontrado"
));
    }

    public Apoio salvar(Apoio apoio) {

        if (apoio.getUsuario() == null || apoio.getUsuario().getId() == null) {
            throw new IllegalArgumentException("É necessário informar o usuário.");
        }

        if (apoio.getOcorrencia() == null || apoio.getOcorrencia().getId() == null) {
            throw new IllegalArgumentException("É necessário informar a ocorrência.");
        }

        Integer usuarioId = apoio.getUsuario().getId();
        Integer ocorrenciaId = apoio.getOcorrencia().getId();

        boolean jaExiste;

        if (apoio.getId() == null) {
            jaExiste = apoioRepositorio
                    .existsByUsuario_IdAndOcorrencia_Id(usuarioId, ocorrenciaId);
        } else {
            jaExiste = apoioRepositorio
                    .existsByUsuario_IdAndOcorrencia_IdAndIdNot(
                            usuarioId, ocorrenciaId, apoio.getId());
        }

        if (jaExiste) {
            throw new IllegalArgumentException(
                    "Este usuário já apoiou esta ocorrência."
            );
        }

        return apoioRepositorio.save(apoio);
    }

    public void excluir(Integer id) {
        Apoio apoio = buscarPorId(id);
        apoioRepositorio.delete(apoio);
    }
}
