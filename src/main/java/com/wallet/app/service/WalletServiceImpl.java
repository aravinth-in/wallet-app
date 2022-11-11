package com.wallet.app.service;

import com.wallet.app.dao.WalletDao;
import com.wallet.app.dao.WalletDaoImpl;
import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public class WalletServiceImpl implements WalletService{

	private WalletDao walletRepository = new WalletDaoImpl();

	@Override
	public Wallet registerWallet(Wallet newWallet)throws WalletException {
		
		return this.walletRepository.addWallet(newWallet);
		//return null;
	}

	@Override
	public Boolean login(Integer walletId, String password)throws WalletException
	{
		
		boolean isLogged = false;
		Wallet wallet = this.walletRepository.getWalletById(walletId);
		
				if(wallet.getPassword().equals(password))
				{
					
					 isLogged = true;
				}
				
				return isLogged;
	}

	@Override
	public Double addFundsToWallet(Integer walletId, Double amount)throws WalletException 
	{
		Wallet we = this.walletRepository.getWalletById(walletId);
		
		Double balance = we.getBalance();
		/* 
		 * balance = balance+amount;
		 */
		
		we.setBalance(we.getBalance()+amount);
		
		balance= this.walletRepository.updateWallet(we).getBalance();
		return balance;
		/*
		 * System.out.println(we);
		 * 
		 * return we.getBalance();
		 */
		
		
	}

	@Override
	public Double showWalletBalance(Integer walletId)throws WalletException {
		Wallet we=this.walletRepository.getWalletById(walletId);
		return we.getBalance();
	}

	@Override
	public Boolean fundTransfer(Integer fromId, Integer toId, Double amount) throws WalletException
	{
		boolean transfer=false;
		try {
		Wallet we1 = this.walletRepository.getWalletById(fromId);
		Wallet we2 = this.walletRepository.getWalletById(toId);
		if(we1.getBalance()>amount)
		{
			we1.setBalance(we1.getBalance()-amount);
			we2.setBalance(we2.getBalance()+amount);
			this.walletRepository.updateWallet(we1);
			this.walletRepository.updateWallet(we2);
			transfer=true;
			System.out.println("Transfer Successfull");
		}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
		return transfer;
	}

	@Override
	public Wallet unRegisterWallet(Integer walletId, String password)throws WalletException 
	{
		boolean del = false;
		
		Wallet we = this.walletRepository.deleteWalletById(walletId);
			
			
		return this.walletRepository.deleteWalletById(walletId);
	}
	
}