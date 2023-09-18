package com.tech.auth.token.jmt.util;

import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tech.auth.token.constants.Constants;
import com.tech.auth.token.jmt.dto.JmToken;

public class JmtUtil {
	
	private static final Logger _logger = LoggerFactory.getLogger(JmtUtil.class);
	
	public String createJsonTokenObj(JmToken token) throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		//JmToken token = new JmToken();
		//token.setUserid("jupiter");
		String tokenString = null;
		if(token != null) {
			Calendar currentDate = Calendar.getInstance();
			token.setStart(Constants.dateFormater.format(currentDate.getTime()));
			currentDate.add(Calendar.MINUTE, Constants.TOKEN_VALID_PERIOD);
			token.setEnd(Constants.dateFormater.format(currentDate.getTime()));
			_logger.info("Before Write Json:"+token.toString());
			String jsonString = mapper.writeValueAsString(token);
			_logger.info("jsonString:"+jsonString);
			tokenString = JmtHashUtil.encrypt(jsonString);
			_logger.info("Encrypted Token:"+tokenString);
		}
		
		return tokenString;
	}
	
	public JmToken readJsonStr(String jsonToken) throws JsonMappingException, JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		String jsonStr = JmtHashUtil.decrypt(jsonToken);
		JmToken token = mapper.readValue(jsonStr, JmToken.class);
		_logger.info("Converted Json:"+token.toString());
		return token;
	}
	
	public boolean isActiveToken(String endString) {

		try {
			Date endTime = Constants.dateFormater.parse(endString);
			Date currentTime = Constants.dateFormater.parse(Constants.dateFormater.format(new Date()));
			long timeDiff = currentTime.getTime()-endTime.getTime();
			_logger.info("Time Diff:"+timeDiff);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			_logger.info(e.getMessage(),e);
		}
		return false;
	}
	
	public static void main(String[] args) {
		//createJsonToken();
		//String json1="";
		//String decryptStr = "";
		//PasswordHashUtil hashUtil = new PasswordHashUtil(aespassword, aesSalt);
		//try {
			//json1 = createJsonTokenObj();
		//	String hashToken = JmtHashUtil.encrypt(json1);
			//System.out.println("Hash Token:"+hashToken);
		//	decryptStr = JmtHashUtil.decrypt(hashToken);
		//} catch (JsonProcessingException e1) {
			// TODO Auto-generated catch block
		//	e1.printStackTrace();
		//}//"{\"start\":Thu Jul 13 18:16:29 IST 2023,\"end\":Thu Jul 13 18:16:29 IST 2023,\"userid\":\"jupiter\"}";
		/*
		 * try {
		 * 
		 * readJsonStr(decryptStr); } catch (JsonProcessingException e) {
		 * 
		 * e.printStackTrace(); }
		 */
		
	}

}
