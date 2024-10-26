package com.personal.dashboard.services;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.stereotype.Service;

@Service
public class PingService {
	// Change these
	private final byte[] PiHole = new byte[] { (byte) 192, (byte) 168, 86, (byte) 163};
	private final byte[] FileSharing = new byte[] {(byte) 192, (byte) 168, 86, (byte) 164}; 

	public boolean[] ping() throws UnknownHostException, IOException {
		InetAddress inet1 = InetAddress.getByAddress(PiHole);
		InetAddress inet2 = InetAddress.getByAddress(FileSharing);
		
		return new boolean[] {inet1.isReachable(1000), inet2.isReachable(1000)};
	}
	
	public boolean[] pingIpandPort(byte[] ip, int[] port) throws IOException {
		InetAddress inet1 = InetAddress.getByAddress(ip);
		//Socket socket = new Socket();
		
		return new boolean[] {inet1.isReachable(1000), false};
	}
}
