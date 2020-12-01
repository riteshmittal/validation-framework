package com.aem.community.core.models;

public class ErrorMessage {

	private String message;

	private boolean warning;

	private boolean error;

	private boolean info;

	private String cssClass;

	public String getCssClass() {
		return cssClass;

	}

	public static ErrorMessageBuilder builder() {
		return new ErrorMessageBuilder();
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isWarning() {
		return warning;
	}

	public void setWarning(boolean warning) {
		this.warning = warning;
	}

	public void setError(boolean error) {
		this.error = error;
	}

	public void setInfo(boolean info) {
		this.info = info;
	}

	public boolean isError() {
		return error;
	}

	public boolean isInfo() {
		return info;
	}

	public void setCssClass(String cssClass) {
		this.cssClass = cssClass;
	}

}
