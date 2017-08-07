package br.com.gma.fileupload.webapi.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import br.com.gma.fileupload.webapi.viewmodel.ArquivoViewModel;
import br.com.gma.fileupload.webapi.viewmodel.ObraViewModel;

@Service
public class ObraWebApiService implements IObraWebApiService{
	
	public ObraWebApiService() {}
	
	public ApiServiceRetorno getListaObra()
	{
		
		
		//TODO colocar repositorio
		List<ObraViewModel> listaObra= _obterListaObra();
		
		if(listaObra.isEmpty())
		{
		   return	ApiServiceRetorno.FalhaRetornoVazioOuNaoEncontrado(new String[] {"Informação não encontrada"});
		}
		else
		{
		  return	ApiServiceRetorno.Sucesso(listaObra);
		 	
		}
	}
	
	
	public ApiServiceRetorno salvarListaArquivo(ArquivoViewModel arquivoViewModel) {

		//TODO tratar pasta salvar
		//TODO tratar tamanha arquivo
		
		
		String nomePasta="E:\\___GMA\\";
	
		nomePasta=null;
		
		if(nomePasta==null)
		{
			  return	ApiServiceRetorno.FalhaServidor(new String[] {"TODO definir nome da pasta!!!","br.com.gma.fileupload.webapi.service.ObraWebApiService.salvar()"});
		}
		
		List<MultipartFile> files=Arrays.asList(arquivoViewModel.getArquivos());
		
        for (MultipartFile file : files) {

            if (file.isEmpty()) {
                continue;  
            }

            byte[] bytes;
            
			try {
				
				bytes = file.getBytes();
			    Path path = Paths.get(nomePasta + file.getOriginalFilename());	
				Files.write(path, bytes);	
				
			} catch (IOException e) {
				
				   return	ApiServiceRetorno.FalhaServidor(new String[] {"Faalha leitura e gravacao arquivo",e.getMessage()});
			}
			
           
        }
        //retornar lista arquivos
		 return	ApiServiceRetorno.Sucesso("");

    }
	
	
	private List<ObraViewModel> _obterListaObra()
	{
		
		List<ObraViewModel> listObra= new ArrayList<>();
		
		listObra.add(new ObraViewModel(10,"101","Obra 01"));
		listObra.add(new ObraViewModel(11,"102","Obra 02"));
		listObra.add(new ObraViewModel(12,"103","Obra 03"));
		listObra.add(new ObraViewModel(13,"104","Obra 04"));
		listObra.add(new ObraViewModel(14,"104","Obra 05"));
		listObra.add(new ObraViewModel(14,"104","Obra 06"));
		
		
		return listObra;
	}

}
