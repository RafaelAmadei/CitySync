package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Atualizacao;
import br.edu.unifio.citysync.entidades.Ocorrencia;
import br.edu.unifio.citysync.repositorios.AtualizacaoRepositorio;
import br.edu.unifio.citysync.repositorios.OcorrenciaRepositorio;
import br.edu.unifio.citysync.excecoes.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;

@Service
public class AtualizacaoService {

    private final AtualizacaoRepositorio atualizacaoRepositorio;
    private final OcorrenciaRepositorio ocorrenciaRepositorio;

    public AtualizacaoService(
            AtualizacaoRepositorio atualizacaoRepositorio,
            OcorrenciaRepositorio ocorrenciaRepositorio) {
        this.atualizacaoRepositorio = atualizacaoRepositorio;
        this.ocorrenciaRepositorio = ocorrenciaRepositorio;
    }

    public List<Atualizacao> listarTodas() {
        return atualizacaoRepositorio.findAll();
    }

    public Atualizacao buscarPorId(Integer id) {
        return atualizacaoRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
        "Atualização não encontrada"
));
    }

    public Atualizacao salvar(Atualizacao atualizacao) {

        if (atualizacao.getOcorrencia() == null
                || atualizacao.getOcorrencia().getId() == null) {
            throw new IllegalArgumentException(
                    "É necessário informar uma ocorrência."
            );
        }

        Integer ocorrenciaId = atualizacao.getOcorrencia().getId();

        Ocorrencia ocorrencia = ocorrenciaRepositorio.findById(ocorrenciaId)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
        "Ocorrência não encontrada"
));

        String statusAtual = ocorrencia.getStatus()
                .toUpperCase(Locale.ROOT);

        if (statusAtual.equals("RESOLVIDA")
                || statusAtual.equals("ENCERRADA")) {
            throw new IllegalArgumentException(
                    "Não é possível atualizar uma ocorrência resolvida ou encerrada."
            );
        }

        atualizacao.setOcorrencia(ocorrencia);

        ocorrencia.setStatus(atualizacao.getStatus().toUpperCase(Locale.ROOT));

        ocorrenciaRepositorio.save(ocorrencia);

        return atualizacaoRepositorio.save(atualizacao);
    }

    public void excluir(Integer id) {
        Atualizacao atualizacao = buscarPorId(id);
        atualizacaoRepositorio.delete(atualizacao);
    }
}
