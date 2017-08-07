package br.com.gma.fileupload.webapi.seguranca;

public class VerificaToken {
	
	 private static String _token="BRRJ2017GMA1967";
	  
	  public static boolean isValido(String token)
	  {
		  if(token==null) return false;
		  return  token.equals(_token);
			  
	  }

}
