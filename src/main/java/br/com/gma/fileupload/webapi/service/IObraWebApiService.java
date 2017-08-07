package br.com.gma.fileupload.webapi.service;

import br.com.gma.fileupload.webapi.viewmodel.ArquivoViewModel;

public interface IObraWebApiService {

	ApiServiceRetorno getListaObra();
	
	 ApiServiceRetorno salvarListaArquivo(ArquivoViewModel arquivoViewModel);
	
	
}
