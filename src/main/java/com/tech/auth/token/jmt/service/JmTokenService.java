package com.tech.auth.token.jmt.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.tech.auth.token.exception.UserNotMatchException;
import com.tech.auth.token.jmt.dto.JmToken;
import com.tech.auth.token.jmt.dto.TokenRequest;
import com.tech.auth.token.jmt.dto.TokenResponse;
import com.tech.auth.token.jmt.dto.ValidateJmToken;
import com.tech.auth.token.jmt.util.JmtHashUtil;
import com.tech.auth.token.jmt.util.JmtUtil;

@Service("jmTokenService")
public class JmTokenService {
	
	private static final Logger _logger = LoggerFactory.getLogger(JmTokenService.class);
	
	private JmtHashUtil hashUtil = null;
	private JmtUtil jmtUtil = null;
	
	public TokenResponse generateToken(TokenRequest request) {
		if(jmtUtil == null) {
			jmtUtil = new JmtUtil();
		}
		TokenResponse response = new TokenResponse();
		try {
			JmToken tokenObj = new JmToken(request.getUserId());
			String tokenStr = jmtUtil.createJsonTokenObj(tokenObj);
			response.setToken(tokenStr);
			response.setUserId(tokenObj.getUserid());
		} catch (Exception e) {
			_logger.error(e.getMessage(),e);
		}
		return response;
	}
	
	public TokenResponse validateToken(ValidateJmToken jmToken) {
		if(jmtUtil == null) {
			jmtUtil = new JmtUtil();
		}
		TokenResponse response = new TokenResponse();
		try {
			JmToken tokenObj = jmtUtil.readJsonStr(jmToken.getToken());
			boolean isValid = jmtUtil.isActiveToken(tokenObj.getEnd());
			if(tokenObj.getUserid().equals(jmToken.getUserId())) {
				response.setValid(isValid);
			} else {
				throw new UserNotMatchException("User Id not matched");
			}
			
		} catch (Exception e) {
			_logger.error(e.getMessage(),e);
		}
		return response;
	}

}
