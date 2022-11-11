package com.wallet.app.dao;

import java.util.HashMap;
import java.util.Map;

import com.wallet.app.dto.Wallet;
import com.wallet.app.exception.WalletException;

public class WalletDaoImpl implements WalletDao {

	
	Map<Integer, Wallet> wallets = new HashMap<>();
@Override
	public Wallet addWallet(Wallet newWallet) {
		
		this.wallets.put(newWallet.getId(), newWallet);
		
		return this.wallets.get(newWallet.getId());
		
	}

	@Override
	public Wallet getWalletById(Integer walletId) {
		
		System.out.println();
		return this.wallets.get(walletId);
		
	}

	@Override
	public Wallet updateWallet(Wallet updateWallet)
	{
		//System.out.println(this.wallets.get(updateWallet);
		//System.out.println(this.wallets.get(updateWallet));
		return this.wallets.put(updateWallet.getId(), updateWallet);
	}

	@Override
	public Wallet deleteWalletById(Integer walletID) {
		return this.wallets.remove(walletID);
		//return null;
	}

	
	
}