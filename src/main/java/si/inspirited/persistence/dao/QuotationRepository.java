package si.inspirited.persistence.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.inspirited.persistence.model.Quotation;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {

    @Query("select q from Quotation q order by latestPrice desc")
    List<Quotation> findTopOrderedByLatestPrice();

    @Query("select q from Quotation q order by changePercent asc")
    List<Quotation> findLastOrderedDescByChangePercent();
}
