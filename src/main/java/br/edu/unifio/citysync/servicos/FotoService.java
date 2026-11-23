
package br.edu.unifio.citysync.servicos;

import br.edu.unifio.citysync.entidades.Foto;
import br.edu.unifio.citysync.repositorios.FotoRepositorio;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FotoService {

    private final FotoRepositorio fotoRepositorio;

    public FotoService(FotoRepositorio fotoRepositorio) {
        this.fotoRepositorio = fotoRepositorio;
    }

    public List<Foto> listarTodas() {
        return fotoRepositorio.findAll();
    }

    public Foto buscarPorId(Integer id) {
        return fotoRepositorio.findById(id)
                .orElseThrow(() -> new RuntimeException("Foto não encontrada"));
    }

    public Foto salvar(Foto foto) {
        return fotoRepositorio.save(foto);
    }

    public void excluir(Integer id) {
        Foto foto = buscarPorId(id);
        fotoRepositorio.delete(foto);
    }
}
