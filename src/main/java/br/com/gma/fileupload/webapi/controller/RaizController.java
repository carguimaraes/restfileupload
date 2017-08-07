package br.com.gma.fileupload.webapi.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.gma.fileupload.webapi.viewmodel.MsgViewModel;

@RestController
public class RaizController {

    @RequestMapping("/")
    public ResponseEntity<Object> pontoEntradaRaiz(){
    	
    	MsgViewModel vwm=new MsgViewModel("Aplicação ok. Ponto entrada raiz");
    	
    	ResponseEntity<Object> responseEntity = new ResponseEntity<>(vwm, HttpStatus.OK);
    	
        return   responseEntity;
    }
}