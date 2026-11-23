
package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Usuario;
import br.edu.unifio.citysync.repositorios.UsuarioRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;

    public UsuarioService(UsuarioRepositorio usuarioRepositorio) {
        this.usuarioRepositorio = usuarioRepositorio;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepositorio.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
    }

    public Usuario salvar(Usuario usuario) {
        return usuarioRepositorio.save(usuario);
    }

    public void excluir(Integer id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepositorio.delete(usuario);
    }
}
