package com.codesignal.challenges;

public class BankRequests {

	public static void main(String[] args) {
		
		int[] answer = bankRequests(new int[]{10, 100, 20, 50, 30}, new String[]{"withdraw 2 10", 
				 "transfer 5 1 20", 
				 "deposit 5 20", 
				 "transfer 3 4 15"});
		
		for (int i:answer) {
			System.out.println(i);
		}
		System.out.println("------------");
		
		answer = bankRequests(new int[] {20, 1000, 500, 40, 90}, new String[] {"deposit 3 400", 
				 "transfer 1 2 30", 
				 "withdraw 4 50"});
		
		for (int i:answer) {
			System.out.println(i);
		}
	}	

	
	private static int[] bankRequests(int[] accounts, String[] requests) {
		int error = 0;
		for (int reqIndex=0; reqIndex < requests.length && error >=0; reqIndex++) {
			String[] trans = requests[reqIndex].split(" ");
			int account1;
			int account2;
			int amount;
			if (trans[0].equals("transfer")) {
				account1 = Integer.valueOf(trans[1])-1;
				account2 = Integer.valueOf(trans[2])-1;
				amount = Integer.valueOf(trans[3]);
				if (!validateAccount(account1, accounts) || !validateAccount(account2, accounts) || !validateAmount(amount, account1, accounts)) {
					error = 0-reqIndex-1;
				} else {
					accounts[account1] -= amount;
					accounts[account2] += amount;
				}						
			} else if (trans[0].equals("deposit")) {
				account1 = Integer.valueOf(trans[1])-1;
				amount = Integer.valueOf(trans[2]);
				if (!validateAccount(account1, accounts)) {
					error = 0-reqIndex-1;
				} else {
					accounts[account1] += amount;
				}
				
			} else if (trans[0].equals("withdraw")) {
				account1 = Integer.valueOf(trans[1])-1;
				amount = Integer.valueOf(trans[2]);
				if (!validateAccount(account1, accounts) || !validateAmount(amount, account1, accounts)) {
					error = 0-reqIndex-1;
				} else {
					accounts[account1] -= amount;
				}			
			}
		}
		
		return error < 0 ? new int[] {error} : accounts;
	}
	
	private static boolean validateAccount(int accountIndex, int[] accounts) {
		return accountIndex >= 0 && accountIndex < accounts.length;
	}
	
	private static boolean validateAmount(int amount, int accountIndex, int[] accounts) {
		return accounts[accountIndex] >= amount;
	}

}
