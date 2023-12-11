package br.com.gid.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import br.com.gid.entities.Trabalho;
import br.com.gid.entities.TrabalhoDET;
import br.com.gid.entities.TrabalhoHIST;
import br.com.gid.repositories.TrabalhoDetRepository;
import br.com.gid.repositories.TrabalhoRepository;

@Service
public class TrabalhoService {

    @Autowired
    private TrabalhoRepository trabalhoRepository;
    
    @Autowired
    private TrabalhoDetRepository trabalhoDetRepository;

    private static String DATE_FORMAT = "yyyy-MM-dd";
    public Page<Trabalho> findAll(int offset, int limit, String arquivo, String dtRec) throws ParseException {
    	Pageable pageable = PageRequest.of(offset, limit, Sort.by("id").descending().and(Sort.by("arquivo")));

    	if(StringUtils.hasLength(arquivo) && StringUtils.hasLength(dtRec)) {
    		Date dataRec = new SimpleDateFormat(DATE_FORMAT).parse(dtRec);
    		return trabalhoRepository.findAllByArquivoAndDtRec(pageable, arquivo, dataRec);
    	} else
    	if(StringUtils.hasLength(arquivo)) {
    		return trabalhoRepository.findAllByArquivo(pageable, arquivo);
    	} else
    	if(StringUtils.hasLength(dtRec)) {
    		Date dataRec = new SimpleDateFormat(DATE_FORMAT).parse(dtRec);
    		return trabalhoRepository.findAllByDtRec(pageable, dataRec);
    	}
        return trabalhoRepository.findAll(pageable);
    }

	public Page<TrabalhoDET> getAllDet(int trabalhoId, int offset, int limit) {
    	Pageable pageable = PageRequest.of(offset, limit);
        return trabalhoDetRepository.findByTrabalhoDETPKTrabalhoId(pageable, trabalhoId);
	}

	public Page<TrabalhoHIST> getAllHist(int offset, int limit) {
//    	Pageable pageable = PageRequest.of(offset, limit);
        return null;//trabalhoRepository.findHistByDet(pageable);
	}

	public Trabalho findById(int trabalhoId) {
		return trabalhoRepository.findById(trabalhoId).orElse(null);
	}
}
