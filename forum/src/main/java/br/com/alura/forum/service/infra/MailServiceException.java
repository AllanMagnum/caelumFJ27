package br.com.alura.forum.service.infra;

public class MailServiceException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2722201241804129200L;

	public MailServiceException(String message, Throwable cause){
		super(message, cause);
	}
}
