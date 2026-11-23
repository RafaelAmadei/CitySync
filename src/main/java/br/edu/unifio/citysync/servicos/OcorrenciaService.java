package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Ocorrencia;
import br.edu.unifio.citysync.repositorios.OcorrenciaRepositorio;
import br.edu.unifio.citysync.excecoes.RecursoNaoEncontradoException;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OcorrenciaService {

    private final OcorrenciaRepositorio ocorrenciaRepositorio;

    public OcorrenciaService(OcorrenciaRepositorio ocorrenciaRepositorio) {
        this.ocorrenciaRepositorio = ocorrenciaRepositorio;
    }

    public List<Ocorrencia> listarTodas() {
        return ocorrenciaRepositorio.findAll();
    }

    public Ocorrencia buscarPorId(Integer id) {
        return ocorrenciaRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException("Ocorrência não encontrada"));
    }

    public Ocorrencia salvar(Ocorrencia ocorrencia) {
        return ocorrenciaRepositorio.save(ocorrencia);
    }

    public Ocorrencia atualizar(Integer id, Ocorrencia dados) {
        Ocorrencia ocorrencia = buscarPorId(id);

        ocorrencia.setTitulo(dados.getTitulo());
        ocorrencia.setDescricao(dados.getDescricao());
        ocorrencia.setLocalizacao(dados.getLocalizacao());
        ocorrencia.setStatus(dados.getStatus());

        return ocorrenciaRepositorio.save(ocorrencia);
    }

    public void excluir(Integer id) {
        Ocorrencia ocorrencia = buscarPorId(id);
        ocorrenciaRepositorio.delete(ocorrencia);
    }

public List<Ocorrencia> buscarPorStatus(String status) {
    return ocorrenciaRepositorio.findByStatus(status);
}

public List<Ocorrencia> buscarPorUsuario(Integer usuarioId) {
    return ocorrenciaRepositorio.findByUsuario_Id(usuarioId);
}

}
