
package br.edu.unifio.citysync.controladores;

import br.edu.unifio.citysync.entidades.Atualizacao;
import br.edu.unifio.citysync.servicos.AtualizacaoService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/atualizacoes")
public class AtualizacaoController {

    private final AtualizacaoService atualizacaoService;

    public AtualizacaoController(AtualizacaoService atualizacaoService) {
        this.atualizacaoService = atualizacaoService;
    }

    @GetMapping
    public List<Atualizacao> listarTodas() {
        return atualizacaoService.listarTodas();
    }

    @GetMapping("/{id}")
    public Atualizacao buscarPorId(@PathVariable Integer id) {
        return atualizacaoService.buscarPorId(id);
    }

    @PostMapping
    public Atualizacao cadastrar(@RequestBody Atualizacao atualizacao) {
        return atualizacaoService.salvar(atualizacao);
    }

    @PutMapping("/{id}")
    public Atualizacao atualizar(
            @PathVariable Integer id,
            @RequestBody Atualizacao dados) {

        Atualizacao atualizacao = atualizacaoService.buscarPorId(id);

        atualizacao.setStatus(dados.getStatus());
        atualizacao.setDescricao(dados.getDescricao());
        atualizacao.setOcorrencia(dados.getOcorrencia());

        return atualizacaoService.salvar(atualizacao);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Integer id) {
        atualizacaoService.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
