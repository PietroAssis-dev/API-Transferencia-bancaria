package pietroassis.Projeto_Bancario.Model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@Entity
public class TransferenciaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long idTransferencia;
    private Long idContaOrigem;
    private Long idContaDestino;
    private Double valorTransferido;
    private OffsetDateTime offsetDateTime;

    public TransferenciaModel(){

    }


}
