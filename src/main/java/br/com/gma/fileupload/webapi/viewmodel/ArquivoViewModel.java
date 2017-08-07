package br.com.gma.fileupload.webapi.viewmodel;

import org.springframework.web.multipart.MultipartFile;

public class ArquivoViewModel {

    
   private MultipartFile[] arquivos;

public MultipartFile[] getArquivos() {
	return arquivos;
}

public void setArquivos(MultipartFile[] arquivos) {
	this.arquivos = arquivos;
}

   
    
	
}
