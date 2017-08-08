package br.com.gma.fileupload.webapi.viewmodel;

public class LoginViewModel {
	
	private String email;
	private String psw;
	private String token;
	
	
	public LoginViewModel(){}
	
	public LoginViewModel(String email, String pws){}
	{
		this.email=email;
		this.psw=psw;
		this.token=null;
	}

	public LoginViewModel(String token){}
	{
		this.email=null;
		this.psw=null;
		this.token=token;
		
	}
	

	public String getEmail() {
		return email;
	}


	public String getPsw() {
		return psw;
	}


	public String getToken() {
		return token;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPsw(String psw) {
		this.psw = psw;
	}


	public void setToken(String token) {
		this.token = token;
	}
	
	
	

}
