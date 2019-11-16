package si.inspirited.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import si.inspirited.dto.QuotationDto;
import si.inspirited.persistence.dao.QuotationRepository;
import si.inspirited.persistence.model.Quotation;
import si.inspirited.service.IQuotationService;
import si.inspirited.util.IQuotationDaoToDtoConverter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuotationService implements IQuotationService {

    @Autowired
    QuotationRepository quotationRepository;

    @Autowired
    IQuotationDaoToDtoConverter daoToDtoConverter;

    @Override
    public QuotationDto addQuotation(Quotation quotation) {
        return daoToDtoConverter.getDto(quotationRepository.save(quotation));
    }

    @Override
    public Page<QuotationDto> getTop5QuotationsOrderedByLatestPrice4LastOfThemByCompanyName() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Quotation> quotationDao = quotationRepository.findTopOrderedByLatestPrice(pageRequest);
        List<QuotationDto> resultList = new ArrayList<>();
        quotationDao.stream().forEach((dao) -> resultList.add(daoToDtoConverter.getDto(dao)));
        List<QuotationDto> toSortByCompanyName = new ArrayList<>(5);

        for (int i = 1; i < resultList.size(); i++) {
            toSortByCompanyName.add(resultList.get(i));
        }
        List<QuotationDto> sortedByCompanyName = toSortByCompanyName.stream().
                                                    sorted(Comparator.comparing(QuotationDto::getCompanyName)).
                                                    collect(Collectors.toList());
    //sort(Comparator.comparing((QuotationDto::getCompanyName)));
        for (int i = 1; i < resultList.size(); i++) {
            resultList.remove(i);
            resultList.add(i, sortedByCompanyName.get(i - 1));
        }
        return new PageImpl<>(resultList);
    }

    @Override
    public Page<QuotationDto> getLast5QuotationsOrderedDescByChangePercent() {
        PageRequest pageRequest = PageRequest.of(0, 5);
        Page<Quotation> quotationDao = quotationRepository.findLastOrderedDescByChangePercent(pageRequest);
        List<QuotationDto> resultList = new ArrayList<>();
        quotationDao.stream().forEach((dao) -> resultList.add(daoToDtoConverter.getDto(dao)));
        return new PageImpl<>(resultList);
    }

    @Override
    public void refreshQuotationStorage() {
        quotationRepository.deleteAll();
    }
}
