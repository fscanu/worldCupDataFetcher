package it.fescacom.service.excel;

import it.fescacom.domain.Match;

import java.util.List;

public interface ServiceCRUDExcelInterface {
    void createExcel(List<Match> matches);

    byte[] readExcel();

    void updateExcel();

    void deleteExcel();
}
