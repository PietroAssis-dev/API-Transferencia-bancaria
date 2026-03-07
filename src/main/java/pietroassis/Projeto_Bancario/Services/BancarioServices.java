package pietroassis.Projeto_Bancario.Services;

import org.springframework.stereotype.Service;
import pietroassis.Projeto_Bancario.Model.BancarioModel;
import pietroassis.Projeto_Bancario.Model.TransferenciaModel;
import pietroassis.Projeto_Bancario.Repository.BancarioRepository;
import pietroassis.Projeto_Bancario.Repository.TransferenciaRepository;

import java.time.OffsetDateTime;
import java.util.List;


@Service
public class BancarioServices {
    private final BancarioRepository bancarioRepository;
    private final TransferenciaRepository transferenciaRepository;

    public BancarioServices (BancarioRepository bancarioRepository, TransferenciaRepository transferenciaRepository){
        this.bancarioRepository = bancarioRepository;
        this.transferenciaRepository = transferenciaRepository;
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


        TransferenciaModel transferencia = new TransferenciaModel();
        transferencia.setIdContaOrigem(idOrigem);
        transferencia.setIdContaDestino(idDestino);
        transferencia.setValorTransferido(valor);
        transferencia.setOffsetDateTime(OffsetDateTime.now());
        transferenciaRepository.save(transferencia);



    }

    public List <TransferenciaModel> historicoTransferencia(Long idConta){
        return transferenciaRepository.findByIdContaOrigemOrIdContaDestino(idConta, idConta);



    }

}
