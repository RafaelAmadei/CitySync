
package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Comentario;
import br.edu.unifio.citysync.repositorios.ComentarioRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComentarioService {

    private final ComentarioRepositorio comentarioRepositorio;

    public ComentarioService(ComentarioRepositorio comentarioRepositorio) {
        this.comentarioRepositorio = comentarioRepositorio;
    }

    public List<Comentario> listarTodos() {
        return comentarioRepositorio.findAll();
    }

    public Comentario buscarPorId(Integer id) {
        return comentarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Comentário não encontrado"));
    }

    public Comentario salvar(Comentario comentario) {
        return comentarioRepositorio.save(comentario);
    }

    public void excluir(Integer id) {
        Comentario comentario = buscarPorId(id);
        comentarioRepositorio.delete(comentario);
    }
}
