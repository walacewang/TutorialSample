package com.zac.config.message;

import java.util.Locale;

import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.http.HttpStatus;

import com.zac.com.dto.ErrorResponse;

public class BundleMessageSource extends ReloadableResourceBundleMessageSource {

	public ErrorResponse getBizErrorResponse(String errcd) {
		ErrorResponse dto = new ErrorResponse();

		String errKeyStatus = "error." + errcd + ".status";
		String errStatus = this.getMessage(errKeyStatus, null, Locale.getDefault());

		String errKeyMsg = "error." + errcd + ".msg";
		String errMsg = this.getMessage(errKeyMsg, null, Locale.getDefault());

		String errKeyDesc = "error." + errcd + ".desc";
		String errDesc = this.getMessage(errKeyDesc, null, Locale.getDefault());

		int status = Integer.parseInt(errStatus);
		dto.setStatus(HttpStatus.valueOf(status));
		dto.setError(errMsg);
		dto.setError_description(errDesc);

		return dto;
	}


}
