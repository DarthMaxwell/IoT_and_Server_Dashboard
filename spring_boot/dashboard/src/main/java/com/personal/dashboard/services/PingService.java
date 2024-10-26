package com.personal.dashboard.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

@Service
public class PingService {
	
	public boolean[] pingIpandPort(byte[] ip, int port) throws UnknownHostException {
		InetAddress inet = InetAddress.getByAddress(ip);
		Socket socket = new Socket();
		boolean[] res = new boolean[] {false, false};
		
		try {
			socket.connect(new java.net.InetSocketAddress(inet, port), 2000);
			socket.close();
		
			res[0] = inet.isReachable(1000);
			res[1] = socket.isConnected();
		} catch (IOException e) {}
		
		return res;
	}
}
