package br.com.gma.fileupload.webapi.service;

import br.com.gma.fileupload.webapi.viewmodel.LoginViewModel;

public interface ILoginWebApiService {
	
	ApiServiceRetorno executar(LoginViewModel loginViewModel);

}
