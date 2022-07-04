package com.yzy.test;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class AddrTest {

    public static void main(String[] args) throws SocketException {
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()){
            NetworkInterface networkInterface = networkInterfaces.nextElement();
            Enumeration<InetAddress> inetAddresses = networkInterface.getInetAddresses();
            while (inetAddresses.hasMoreElements()){
                InetAddress inetAddress = inetAddresses.nextElement();
                System.out.println(inetAddress.getHostAddress());
            }
//            System.out.println(networkInterface.getDisplayName());
//            System.out.println(.nextElement().getHostAddress());
//            System.out.println(networkInterface.getInetAddresses());
        }
        System.out.println();
    }
}
