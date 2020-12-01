package com.aem.community.core.models;

public class ErrorMessageBuilder {

	private ErrorMessage error = new ErrorMessage();

	public ErrorMessageBuilder message(String message) {
		error.setMessage(message);
		return this;
	}

	public ErrorMessageBuilder warning() {
		error.setWarning(true);
		error.setCssClass("alert alert-warning");
		return this;
	}

	public ErrorMessageBuilder error() {
		error.setError(true);
		error.setCssClass("alert alert-danger");
		return this;
	}
	
	public ErrorMessageBuilder info() {
		error.setInfo(true);
		error.setCssClass("alert alert-info");
		return this;
	}
	
	
	public ErrorMessage build() {
		return error;
	}

}
