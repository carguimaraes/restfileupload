package br.com.gma.fileupload.webapi.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import br.com.gma.fileupload.webapi.viewmodel.LoginViewModel;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Service
public class LoginWebApiService implements ILoginWebApiService{

	@Override
	public ApiServiceRetorno executar(LoginViewModel loginViewModel) {
		
		
		try 
		{
			if(loginViewModel==null) {
				
				  return	ApiServiceRetorno.FalhaLoginNaoAutorizado(new String[] {"Falha autenticação - informação login null"});
			}
			
			
			if(!isAutenticacaoOk(loginViewModel.getEmail(),loginViewModel.getPsw()))
			{
				  return	ApiServiceRetorno.FalhaLoginNaoAutorizado(new String[] {"Falha autenticação"});
			}
			
		     LoginViewModel loginViewModelRet= new LoginViewModel(geraToken(loginViewModel));
			
			return ApiServiceRetorno.Sucesso(loginViewModelRet);
			
		}
		catch(Exception e) 
		{
		
			  return	ApiServiceRetorno.FalhaServidor(new String[] {"Falha autenticação",e.getMessage()});
		}
			
		
	}

	
	private boolean isAutenticacaoOk(String email, String psw)
	{
		if(email==null || psw==null)
		{
			return false;
		}
		
			
		return (email.equals("gma@gmail.com") && (psw.equals("gma1967")));
	}
	
	private String geraToken(LoginViewModel loginViewModel)
	{
		//TODO gerar JWT
	  // Token = _Token.GerarToken(result.ObjRetorno.Email, result.ObjRetorno.Id, DateTime.Now.Ticks)
		//TODO ALTERAR KEY GMA-1967
		//TODO retirar geracao token e colocar util seguranca
		/*
		String compactJws = Jwts.builder()
				  .setSubject("Joe")
				  .signWith(SignatureAlgorithm.HS512, "GMA-1967")
				  .compact();
		
		 JwtBuilder builder = Jwts.builder().setId(id)
                 .setIssuedAt(now)
                 .setSubject(subject)
                 .setIssuer(issuer)
                 .signWith(signatureAlgorithm, signingKey);
		
		*/
		
		
		return "";
	}
}
