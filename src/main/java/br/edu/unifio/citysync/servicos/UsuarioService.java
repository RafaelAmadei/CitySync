package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Usuario;
import br.edu.unifio.citysync.repositorios.UsuarioRepositorio;
import br.edu.unifio.citysync.excecoes.RecursoNaoEncontradoException;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    private final UsuarioRepositorio usuarioRepositorio;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(
            UsuarioRepositorio usuarioRepositorio,
            PasswordEncoder passwordEncoder) {
        this.usuarioRepositorio = usuarioRepositorio;
        this.passwordEncoder = passwordEncoder;
    }

    public List<Usuario> listarTodos() {
        return usuarioRepositorio.findAll();
    }

    public Usuario buscarPorId(Integer id) {
        return usuarioRepositorio.findById(id)
                .orElseThrow(() -> new RecursoNaoEncontradoException(
        "Usuário não encontrado"
));
    }

    public Usuario salvar(Usuario usuario) {

        boolean emailExiste = usuarioRepositorio.findByEmail(usuario.getEmail())
                .filter(u -> !u.getId().equals(usuario.getId()))
                .isPresent();

        if (emailExiste) {
            throw new IllegalArgumentException("Este e-mail já está cadastrado.");
        }

        if (usuario.getId() == null) {
            usuario.setPerfil("USER");
            usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
        } else {
            Usuario existente = buscarPorId(usuario.getId());

            if (usuario.getSenha() != null
                    && !usuario.getSenha().isBlank()) {
                usuario.setSenha(passwordEncoder.encode(usuario.getSenha()));
            } else {
                usuario.setSenha(existente.getSenha());
            }

            usuario.setPerfil(existente.getPerfil());
        }

        return usuarioRepositorio.save(usuario);
    }

    public void excluir(Integer id) {
        Usuario usuario = buscarPorId(id);
        usuarioRepositorio.delete(usuario);
    }
}
