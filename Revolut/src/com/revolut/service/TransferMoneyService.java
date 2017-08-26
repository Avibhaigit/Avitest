package com.revolut.service;

import com.revolut.http.RevolutHttpClient;

/**
 * @author Devavratt Bagayat
 *
 */
public class TransferMoneyService {
	public static final String END_POINT_URL = "http://www.bankdomain.com/accounts";	
	public static void main (String args[]){
		RevolutHttpClient httpClient = new RevolutHttpClient();
		String response = httpClient.doGet(END_POINT_URL);
		System.out.println("The Response is:"+response);
	 }

}
