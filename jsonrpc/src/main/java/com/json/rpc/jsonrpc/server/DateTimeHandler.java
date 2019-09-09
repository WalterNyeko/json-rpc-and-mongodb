package com.json.rpc.jsonrpc.server;

import java.text.DateFormat;
import java.util.Date;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.server.MessageContext;
import com.thetransactioncompany.jsonrpc2.server.RequestHandler;

public class DateTimeHandler implements RequestHandler{

	public String[] handledRequests() {
		
		return new String[]{"getDate","getTime"};
		
	}

	public JSONRPC2Response process(JSONRPC2Request request, MessageContext requestCtx) {
		
		if (request.getMethod().equals("getDate")) {
			
			DateFormat dateFormat = DateFormat.getDateInstance();
			String date = dateFormat.format(new Date());
			
			return new JSONRPC2Response(date, request.getID());
			
		}else if (request.getMethod().equals("getTime")) {
			
			DateFormat dateFormat = DateFormat.getTimeInstance();
			String time = dateFormat.format(new Date());
			
			return new JSONRPC2Response(time, request.getID());
			
		}else {
			
			return new JSONRPC2Response(JSONRPC2Error.METHOD_NOT_FOUND, request.getID());
		
		}
		
	}

}
