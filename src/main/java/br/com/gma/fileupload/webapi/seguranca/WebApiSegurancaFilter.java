package br.com.gma.fileupload.webapi.seguranca;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



//TODO nao esta funcionando - em desenvolvimento
@WebFilter("/api/*")
public class WebApiSegurancaFilter {

	
	//X-CustomToken = GMA-1967
    public final String HEADER_SECURITY_TOKEN = "X-CustomToken"; 
	
	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException 
	{ 
		 
		  String token =((HttpServletRequest) req).getHeader(HEADER_SECURITY_TOKEN);
		  System.out.println("------>"+token);
		  if(!VerificaToken.isValido(token))
		  {
			  ((HttpServletResponse) res).sendError( HttpServletResponse.SC_UNAUTHORIZED, "Unauthorized" );
		  }
		  else
		  {
			  chain.doFilter(req, res);  	  
		  }
	 
	}

	public void destroy() 
	{
		// TODO Auto-generated method stub
		
	}

	public void init(FilterConfig arg0) throws ServletException 
	{
		// TODO Auto-generated method stub
	}
	
	
}
