package com.wallet.app.controller;

import java.util.*;
import java.lang.*;

import com.employee.Employee;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;
import com.wallet.app.service.WalletService;
import com.wallet.app.service.WalletServiceImpl;

public class Controller 
{
	public static void main(String[] args)
	{
	
		int id;
		String pswd=null;
		Scanner sc =new Scanner(System.in);
		
		WalletService walletService = new WalletServiceImpl();
		
		Wallet wallet;
		try {
			wallet = walletService.registerWallet(new Wallet(1, "Microsoft", 1000.0, "Mc@1234"));
			wallet = walletService.registerWallet(new Wallet(2, "Meta", 2000.0, "Mt@1234"));
		} catch (WalletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
					
		//System.out.println(wallet);
		
		int n;
		do {
			System.out.println("-----------------------------------------");
			menu();
			n = sc.nextInt();
	
			switch(n)
			{
			
			case 1:
				System.out.println("Enter the Wallet ID");
				Wallet we = new Wallet();
				we.setId(sc.nextInt());
				System.out.println("Enter the name");
				we.setName(sc.next());
				System.out.println("Enter the balance");
				we.setBalance(sc.nextDouble());
				System.out.println("Enter the password");
				we.setPassword(sc.next());
				
				try {
					System.out.println(walletService.registerWallet(we));
				} catch (WalletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				 
				// System.out.println(wallet);
				 break;
				 
			case 2:
				System.out.println("Enter your Wallet ID");
				id=sc.nextInt();
				System.out.println("Enter your password");
				pswd = sc.next();
				
				try {
					System.out.println(walletService.login(id, pswd));
				} 
				catch (WalletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
				break;
				
			case 3:
				System.out.println("Login Page");
				System.out.println("Enter your Wallet ID");
				int wId = sc.nextInt();
				System.out.println("Enter your password");
				String passsword = sc.next();
				try {
					
					if(walletService.login(wId , passsword)) {
							System.out.println("Enter the amount: ");
							double amt = sc.nextDouble();
							System.out.println(walletService.addFundsToWallet(wId , amt));
					} 
					else {
						System.out.println("Login Failed");
					}
//					System.out.println("Enter the amount: ");
//					double amt = sc.nextDouble();
					
//					System.out.println(walletService.addFundsToWallet(wId , amt));
				} 
				catch (WalletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				break;
				
				
			case 4:
				System.out.println("Login Page");
				System.out.println("Enter your Wallet ID");
				int wID = sc.nextInt();
				System.out.println("Enter your password");
				pswd = sc.next();
				try {
					if(walletService.login(wID , pswd)) {
						System.out.println(walletService.showWalletBalance(wID));
					} 
					else {
						System.out.println("Login Failed");
					}
					
				} catch (WalletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 5:
				System.out.println("Enter your sender Wallet ID");
				int fromId = sc.nextInt();
				System.out.println("Enter the receiver Wallet ID");
				int toId=sc.nextInt();
				System.out.println("Enter the amount you want to transfer");
				Double amt=sc.nextDouble();
				try {
					System.out.println(walletService.fundTransfer(fromId, toId, amt));
				} catch (WalletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				break;
				
			case 6:
				System.out.println("Enter your Wallet ID");
				int walletId=sc.nextInt();
				System.out.println("Enter your password");
				String password = sc.next();
				try {
					System.out.println(walletService.unRegisterWallet(walletId, password));
				} catch (WalletException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				
			case 9:
				System.out.println("\nThank you for using our service\n");
				System.exit(0);
				break;
				
			default:
				System.out.println("\nInvalid input\n");
				break;
			}
			
		}while (n!= 9);
		
		}


	public static void menu() {

		System.out.println("List of Service:");
		
		System.out.println("1 - Register Account  "+  '\n'
							+ "2 - Login  "+'\n'
							+ "3 - Add Funds"+'\n'
							+ "4 - Show Balance"+'\n'
							+ "5 - Transfer Amount"+'\n'
							+ "6 - Delete Account"+  '\n'
							+ "9 - Exit"+'\n');
		
		System.out.println("Enter the service no. : ");
	}
	
}
