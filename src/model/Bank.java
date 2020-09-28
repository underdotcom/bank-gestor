package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import interfaces.*;
import structures.*;

public class Bank {

	private final int ARRAY_SIZE = 100;
	private InterfaceHashTable<String, User> dataBase;
	private InterfaceHashTable<String, Desertor> deserters;
	private InterfaceQueue<Turn> commonTurns;
	
	private RandomGenerator randomData;
	private ArrayList<User> presentUsersList;
	private ArrayList<User> commonUser;
	private ArrayList<User> prioritaryUsers;
	private int index;
	//heap queue AllWithPriority>0
	
	public Bank() throws IOException {
		dataBase = new HashTable<String, User>(ARRAY_SIZE);
		deserters = new HashTable<String, Desertor>(ARRAY_SIZE/2);
		presentUsersList= new ArrayList <User>();
		commonUser= new ArrayList <User>();
		prioritaryUsers=new ArrayList<User>();
		commonTurns = new Queue<Turn>();
		randomData= new RandomGenerator(100);
		index=0;
		initializeTestCases();
	}
	
	public void initializeTestCases() {
		for (int i = 0; i <=99; i++) {
			User user=randomData.generateUser(i);
			dataBase.add(user.getId(),user);
		}
	}
	
	public void addNewUser(User user) {
		dataBase.add(user.getId(), user);
	}

	public void addNewTurn() {
		index++;
		String id=""+randomData.getId(index);
		User user= searchUser(id);
		Turn turn = new Turn( user.getName(), user.getId(), user.getPriority());
		
		if(turn.getPriorityValue()>0) {
			prioritaryUsers.add(dataBase.getValue(turn.getId()));
		}else {
			commonUser.add(dataBase.getValue(turn.getId()));
			commonTurns.enqueue(turn);
		}
		presentUsersList.add(dataBase.getValue(turn.getId()));
	}
	
	public ArrayList<User> commonList(){
		return commonUser;
	}
	
	public ArrayList<User> priorityList(){
		return prioritaryUsers;
	}
	
	public ArrayList<User> presentUserList(){
		return presentUsersList;
	}
	
	public String idClient() {
		return commonTurns.front().getData().getId();
	}
	
	public User searchUser(String key) {
		return dataBase.getValue(key);
	}
	
	public String attend(int queue) {
		if(queue==1) {
			String idDelete = commonTurns.dequeue().getData().getId();
			return idDelete;
		}else {
			
		}
		return "";
	}
	
	public void attendCommon(int option, String id, double amount, String cancelationReason, LocalDate cancelationDate,boolean cash) {
		if(option==1) {
			withdrawals(id, amount);
		}else if(option==2) {
			consign(id, amount);
		}else if(option==3) {
			cancelAccount(id, cancelationReason, cancelationDate);
		}else {
			payCreditCard(id, cash);
		}

		boolean delete = false;
		commonUser.remove(0);
		for (int i = 0; i < presentUsersList.size() && !delete; i++) {
			if(presentUsersList.get(i).getId().equals(id)) {
				presentUsersList.remove(i);
				delete = true;
			}
		}
	}
	
	public void attendSpecial(int option) {
		//Erase from the Heap	
	}
	
	//////////////////////Any client//////////////////////////////////
	
	private void cancelAccount(String key, String cancelationReason, LocalDate cancelationDate) {
		User user=dataBase.getValue(key);
		deserters.add(user.getId(), new Desertor(user, cancelationReason, cancelationDate));
		dataBase.remove(user.getId());
	}
	
	///////////////////////Just Current Account //////////////////////
	private boolean withdrawals(String id, double ammount) {
		User aux = dataBase.getValue(id);
		double actualBalance = aux.getCurrentAccount().getBalanceAvailable();
		if(actualBalance >= ammount) {
			aux.getCurrentAccount().setBalanceAvailable(actualBalance - ammount);
			return true;
		}
		return false;
	}
	
	private void consign(String id, double ammount) {
		User aux = dataBase.getValue(id);
		double actualBalance = aux.getCurrentAccount().getBalanceAvailable();
		aux.getCurrentAccount().setBalanceAvailable(actualBalance + ammount);
	}
	///////////////////////////////////////////////////////////////////////
	
	////////////////////////Just CreditCad Method//////////////////////
	private boolean payCreditCard(String id, boolean cash) {
		User aux = dataBase.getValue(id);
		LocalDate now = LocalDate.now();
		if(((CreditCard)aux.getCreditCard()).getPayDate().equals(now) || 
				((CreditCard)aux.getCreditCard()).getPayDate().isBefore(now)) {
			
			if(!cash) {
				double balanceAvailable = aux.getCurrentAccount().getBalanceAvailable();
				double balanceOwing = ((CreditCard)aux.getCreditCard()).getBalanceOwing();
				if(balanceAvailable > balanceOwing) {
					aux.getCurrentAccount().setBalanceAvailable(balanceAvailable - balanceOwing);
				}else
					return false;
			}
				
			((CreditCard)aux.getCreditCard()).pay();
			return true;
		}
		return false;
	}
	
	
	//sort merge
	//heapSort
	//Collectios
}
