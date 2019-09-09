package com.json.rpc.jsonrpc.server;

import java.util.LinkedList;
import java.util.List;

import com.thetransactioncompany.jsonrpc2.JSONRPC2Request;
import com.thetransactioncompany.jsonrpc2.JSONRPC2Response;
import com.thetransactioncompany.jsonrpc2.server.Dispatcher;

public class JSONRPCServer {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		// Create a new JSON-RPC 2.0 request dispatcher
		Dispatcher dispatcher = new Dispatcher();
		
		// Register the "echo", "getDate" and "getTime" handlers with it
		dispatcher.register(new EchoHandler());
		dispatcher.register(new DateTimeHandler());
		
		// Simulate an "echo" JSON-RPC 2.0 request
		List<Object> echoParamaters = new LinkedList<Object>();
		echoParamaters.add("Hello World");
		
		//Initiate the RPC Request call to the "echo" method.
		JSONRPC2Request request = new JSONRPC2Request("echo", echoParamaters, "id-1");
		
		//Execute the Request and Produce Response
		JSONRPC2Response response = dispatcher.dispatch(request, null);
		
		System.out.println(response);
		
		// Simulate a "getDate" JSON-RPC 2.0 request
		request = new JSONRPC2Request("getDate", "req-id-02");
		System.out.println("Request: \n" + request);
		
		response = dispatcher.process(request, null);
		System.out.println("Response: \n" + response);
		
		// Simulate a "getTime" JSON-RPC 2.0 request
		request = new JSONRPC2Request("getTime", "req-id-03");
		System.out.println("Request: \n" + request);
		
		response = dispatcher.process(request, null);
		System.out.println("Response: \n" + response);
	}

}
