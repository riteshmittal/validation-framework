package com.aem.community.core.models;

import java.util.List;
import java.util.stream.Collectors;

import com.google.common.collect.Lists;

public class Validation {

	private List<ErrorMessage> errors = Lists.newArrayList();

	public Validation reporError(boolean condition, String errorMessage) {
		if (condition) {
			errors.add(ErrorMessage.builder().error().message(errorMessage).build());

		}
		return this;
	}

	public Validation reportWarning(boolean condition, String errorMessage) {
		if (condition) {
			errors.add(ErrorMessage.builder().warning().message(errorMessage).build());
		}
		return this;
	}

	public Validation reportInfo(boolean condition, String errorMessage) {
		if (condition) {
			errors.add(ErrorMessage.builder().info().message(errorMessage).build());

		}
		return this;
	}

	public List<ErrorMessage> getErrors() {
		return errors.stream().collect(Collectors.toList());
	}
}
