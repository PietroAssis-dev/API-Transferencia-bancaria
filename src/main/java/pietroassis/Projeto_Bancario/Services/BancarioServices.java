package pietroassis.Projeto_Bancario.Services;

import org.springframework.stereotype.Service;
import pietroassis.Projeto_Bancario.Model.BancarioModel;
import pietroassis.Projeto_Bancario.Repository.BancarioRepository;

import java.util.List;


@Service
public class BancarioServices {
    private final BancarioRepository bancarioRepository;


    public BancarioServices (BancarioRepository bancarioRepository){
        this.bancarioRepository = bancarioRepository;
    }


    public BancarioModel adicionarConta(BancarioModel bancarioModel){
        return bancarioRepository.save(bancarioModel);
    }
    public List<BancarioModel> verConta(){
        return bancarioRepository.findAll();
    }

    public BancarioModel criarConta(BancarioModel bancarioModel){
        if(bancarioModel.getValorBancario() == null){
            bancarioModel.setValorBancario(0.0);
        }
        return bancarioRepository.save(bancarioModel);
    }

    // função para transferencia de dinheiro para uma outra conta criada //
    public void transferir(Long idOrigem, Long idDestino, Double valor){
        BancarioModel contaOrigem = bancarioRepository.findById(idOrigem)
                .orElseThrow(() -> new RuntimeException("Conta origem não encontrada"));
        BancarioModel contaDestino = bancarioRepository.findById(idDestino)
                .orElseThrow(() -> new RuntimeException("conta destino não encontrada"));

        if(contaOrigem.getValorBancario() < valor ){
            throw new RuntimeException("Saldo insuficiente");

        }
        contaOrigem.setValorBancario(contaOrigem.getValorBancario() - valor );
        contaDestino.setValorBancario(contaDestino.getValorBancario() + valor);

        bancarioRepository.save(contaOrigem);
        bancarioRepository.save(contaDestino);
    }

}
