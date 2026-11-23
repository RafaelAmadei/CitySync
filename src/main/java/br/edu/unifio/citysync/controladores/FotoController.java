
package br.edu.unifio.citysync.controladores;

import br.edu.unifio.citysync.entidades.Foto;
import br.edu.unifio.citysync.servicos.FotoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fotos")
public class FotoController {

    private final FotoService fotoService;

    public FotoController(FotoService fotoService) {
        this.fotoService = fotoService;
    }

    @GetMapping
    public List<Foto> listarTodas() {
        return fotoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Foto buscarPorId(@PathVariable Integer id) {
        return fotoService.buscarPorId(id);
    }

    @PostMapping
    public Foto cadastrar(@RequestBody Foto foto) {
        return fotoService.salvar(foto);
    }

    @PutMapping("/{id}")
    public Foto atualizar(
            @PathVariable Integer id,
            @RequestBody Foto dados) {

        Foto foto = fotoService.buscarPorId(id);

        foto.setCaminhoImagem(dados.getCaminhoImagem());
        foto.setOcorrencia(dados.getOcorrencia());

        return fotoService.salvar(foto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        fotoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
