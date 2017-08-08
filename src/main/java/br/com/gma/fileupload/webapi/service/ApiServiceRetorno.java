package br.com.gma.fileupload.webapi.service;

import org.springframework.http.HttpStatus;

public class ApiServiceRetorno {

	private HttpStatus _httpStatusCode;
	private Object _retorno;

	public Object ObterRetorno() {

		return _retorno;
	}

	public HttpStatus ObterHttpStatusCode() {

		return _httpStatusCode;
	}

	public static <T> ApiServiceRetorno getApiServiceRetorno(HttpStatus pr_httpStatusCode, T pr_retorno) {
		ApiServiceRetorno o = new ApiServiceRetorno();

		o._httpStatusCode = pr_httpStatusCode;
		o._retorno = pr_retorno;

		return o;
	}

	// 200
	public static <T> ApiServiceRetorno Sucesso(T obj) {

		return getApiServiceRetorno(HttpStatus.OK, obj);
	}

	// 404
	public static <T> ApiServiceRetorno FalhaRetornoVazioOuNaoEncontrado(String[] mensagens) {
		return getApiServiceRetorno(HttpStatus.NOT_FOUND, mensagens);
	}

	// 400
	public static ApiServiceRetorno FalhaValidacaoSolicitacao(String[] mensagens) {

		return getApiServiceRetorno(HttpStatus.BAD_REQUEST, mensagens);
	}

	// 401
	public static ApiServiceRetorno FalhaLoginNaoAutorizado(String[] mensagens) {
	
		return getApiServiceRetorno(HttpStatus.UNAUTHORIZED, mensagens);
	}

	
	
	// 500
	public static ApiServiceRetorno FalhaServidor(String[] mensagens) {

		return getApiServiceRetorno(HttpStatus.INTERNAL_SERVER_ERROR, mensagens);

	}

}
