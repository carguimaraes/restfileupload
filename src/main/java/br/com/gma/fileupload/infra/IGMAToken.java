package br.com.gma.fileupload.infra;

public interface IGMAToken {
  
	 String GerarToken(String username, long id, long ticks);

     TokenValidation IsTokenValido(String token);
}
