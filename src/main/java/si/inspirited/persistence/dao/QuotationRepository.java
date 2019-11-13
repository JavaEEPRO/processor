package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import si.inspirited.persistence.model.Quotation;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {

    List<Quotation> findTop5OrderByLatestPrice();

    List<Quotation> findFirst5OrderByChangePercentDesc();
}
