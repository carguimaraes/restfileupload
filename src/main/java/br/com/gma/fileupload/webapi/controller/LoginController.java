package br.com.gma.fileupload.webapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.gma.fileupload.webapi.service.ApiServiceRetorno;
import br.com.gma.fileupload.webapi.service.ILoginWebApiService;
import br.com.gma.fileupload.webapi.service.IObraWebApiService;
import br.com.gma.fileupload.webapi.viewmodel.LoginViewModel;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
public class LoginController {

	@Autowired
	private  ILoginWebApiService _loginWebApiService;
	
	
	@RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> Autenticar() 
    {
	  	
		String usuLogin = null;
        String pswLogin = null;
        String strLogin=null;
        
               
      //pegr contexto spring
        //  var strLogin = HttpContext.Current.Request.Headers[C_XLOGIN];
        
        if(strLogin!=null)
        {
        	//TODO em desenvolvimento
        	  // meu codigo em C# converter para java
        	  //var datLogin = strLogin.split(';');

             // if (datLogin.Length == 2)
             // {
             //    usuLogin = datLogin[0];
             //    pswLogin = datLogin[1];
             // }
        }
        
         // LoginDto value = new LoginDto { Email=usuLogin, Psw=pswLogin };

        LoginViewModel loginViewModel= new LoginViewModel(usuLogin,pswLogin);
		
		ApiServiceRetorno s=  _loginWebApiService.executar(loginViewModel);
		
		
		return new ResponseEntity<Object>(s.ObterRetorno(), s.ObterHttpStatusCode());
	
		
	
	 }
}
