package com.json.rpc.jsonrpc.server;

import java.util.List;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Error;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.server.MessageContext;
import com.thetransactioncompany.jsonrpc2.server.RequestHandler;

public class EchoHandler implements RequestHandler{

	public String[] handledRequests() {
		
		return new String[] {"echo"};
		
	}

	public JSONRPC2Response process(JSONRPC2Request request, MessageContext requestCtx) {
		
		if (request.getMethod().equals("echo")) {
			
			//Get first parameter and echo it
			
			List parameters = (List) request.getParams();
			Object theFirstParameter = parameters.get(0);
			
			return new JSONRPC2Response(theFirstParameter, request.getID());
			
		}else {
			
			return new JSONRPC2Response(JSONRPC2Error.METHOD_NOT_FOUND, request.getID());
		
		}
	}

}
