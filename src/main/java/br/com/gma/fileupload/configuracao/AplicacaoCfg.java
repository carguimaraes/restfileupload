package br.com.gma.fileupload.configuracao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Porta atual 8081 - tomcat
//Para mudar a porta do servidor veja - arquivo: resources/ application.properties

@SpringBootApplication
@ComponentScan(basePackages = { "br.com.gma.fileupload.webapi"})
public class AplicacaoCfg {
	
	public static void main(String[] args)
	{
		 SpringApplication.run(AplicacaoCfg.class, args);
	}
	

}
