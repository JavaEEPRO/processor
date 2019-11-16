package si.inspirited.persistence.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import si.inspirited.persistence.model.Quotation;

import java.util.List;

public interface QuotationRepository extends JpaRepository<Quotation, Long> {

    @Query("select q from Quotation q order by latestPrice desc")
    Page<Quotation> findTopOrderedByLatestPrice(Pageable pageable);

    @Query("select q from Quotation q order by changePercent desc")
    Page<Quotation> findTopOrderedByChangePercent(Pageable pageable);
}
