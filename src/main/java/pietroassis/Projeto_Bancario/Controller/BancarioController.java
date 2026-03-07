package pietroassis.Projeto_Bancario.Controller;



import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pietroassis.Projeto_Bancario.Model.BancarioModel;
import pietroassis.Projeto_Bancario.Model.TransferenciaModel;
import pietroassis.Projeto_Bancario.Services.BancarioServices;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/bancario")
public class BancarioController {

    private final BancarioServices bancarioServices;

    public BancarioController(BancarioServices bancarioServices){
        this.bancarioServices = bancarioServices;
    }

    @PostMapping("/conta")
    public BancarioModel criarConta(@RequestBody BancarioModel bancarioModel) {
        return bancarioServices.adicionarConta(bancarioModel);
    }

    @GetMapping("/contas")
    public List<BancarioModel> verConta(){
        return bancarioServices.verConta();
    }

    @GetMapping
    public String novo(Model model){
        BancarioModel bancarioModel = new BancarioModel();
        model.addAttribute("bancarioModel", bancarioModel);
        return "bancarioForm";
    }

    @PostMapping("/transferir")
    public String transferir(@RequestBody Map<String, Object> body) {
        Long idOrigem = Long.valueOf(body.get("idOrigem").toString());
        Long idDestino = Long.valueOf(body.get("idDestino").toString());
        Double valor = Double.valueOf(body.get("valor").toString());

        bancarioServices.transferir(idOrigem, idDestino, valor);
        return "Transferência realizada com sucesso";
    }

    @GetMapping("/historico/{idConta}")
    public List<TransferenciaModel> historico(@PathVariable Long idConta){
        return bancarioServices.historicoTransferencia(idConta);
    }



}

