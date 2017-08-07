package br.com.gma.fileupload.infra;

import java.util.ArrayList;
import java.util.List;

//TODO codigo em desenvolvimento

public class TokenValidation {

	private  List<TokenValidationStatus> listError;
	private String[] tokenPart;
	
	public TokenValidation()
	{
		listError = new ArrayList<TokenValidationStatus>();
	} 
	

	 public Boolean  IsValido() {
		 return listError.size() == 0;  
		 }
	        

     public String[] getTokenPart() {
    	 return tokenPart; 
   	 }
     
}

enum TokenValidationStatus
{
   Expired,
   Exception ,
   TokenInvalido,
   LenTokenInvalido
}
