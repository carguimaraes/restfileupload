package br.com.gma.fileupload.webapi.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import br.com.gma.fileupload.webapi.service.ApiServiceRetorno;
import br.com.gma.fileupload.webapi.service.IObraWebApiService;
import br.com.gma.fileupload.webapi.viewmodel.ArquivoViewModel;
import br.com.gma.fileupload.webapi.viewmodel.ObraViewModel;

//api/v1/obras/1

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class ObraController {
	
	@Autowired
	private  IObraWebApiService _obraWebApiService;
	
	
	@RequestMapping(value = "/obras/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obterObra(@PathVariable("id") long id) 
    {
	  	
		ObraViewModel vwm=new  ObraViewModel(1,"101","Obra 01");
		
		ResponseEntity<?> responseEntity = new ResponseEntity<>(vwm, HttpStatus.OK);
		
		 return responseEntity;
	 }
	

	@RequestMapping(value = "/obras", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> obterListaObra() 
    {
	  	
		ApiServiceRetorno s=  _obraWebApiService.getListaObra();
		
		
		return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	
		
	
	 }

	/*
	 *  para textar postman
	 *  1.selecione Post
	 *  2.form-data
	 *  3.Seleciona file
	 *  4. key= arquivos - selecione o arquivo para upload
	 * 
	 */
	@PostMapping("/obras/arquivo")
	public ResponseEntity<?> uploadArquivoObra(@ModelAttribute ArquivoViewModel arquivoViewModel){
		
	 	
		ApiServiceRetorno s=  _obraWebApiService.salvarListaArquivo(arquivoViewModel);
     
		
		return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	}
	
	
	 
	
 
	

}
