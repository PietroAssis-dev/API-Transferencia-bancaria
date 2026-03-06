package pietroassis.Projeto_Bancario.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pietroassis.Projeto_Bancario.Model.BancarioModel;


@Repository
public interface BancarioRepository extends JpaRepository<BancarioModel, Long> {
}
