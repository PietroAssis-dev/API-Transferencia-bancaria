package pietroassis.Projeto_Bancario.Repository;
import org.springframework.data.jpa.repository.JpaRepository;


import pietroassis.Projeto_Bancario.Model.TransferenciaModel;

import java.util.List;

public interface TransferenciaRepository extends JpaRepository<TransferenciaModel, Long>{
    List<TransferenciaModel> findByIdContaOrigemOrIdContaDestino(Long idOrigem, Long idDestino);
}
