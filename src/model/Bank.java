package model;

import java.time.LocalDate;
import java.util.ArrayList;

import interfaces.InterfaceHashTable;
import structures.HashTable;

public class Bank {

	private final int ARRAY_SIZE = 100;
	
	private InterfaceHashTable<String, User> dataBase;
	private ArrayList<User> presentUsersList;
	private InterfaceHashTable<String, Desertor> deserters;
	//cola turns AllWithPriority 0
	//cola de prioridad AllWithPriority>0
	
	
	public Bank() {
		dataBase = new HashTable<String, User>(ARRAY_SIZE);
		deserters = new HashTable<String, Desertor>(ARRAY_SIZE/2);
	}

	public void addNewUser(User user) {
		dataBase.add(user.getId(), user);
	}
	
	public void addNewTurn(Turn turn) {
		if(turn.getPriorityValue()>0) {
			//addTurn
		}else {
			//addTurn	
		}
		presentUsersList.add(dataBase.getValue(turn.getId()));
	}
	
	public void cancelAccount(User user, String cancelationReason, LocalDate cancelationDate) {
		deserters.add(user.getId(), new Desertor(user, cancelationReason, cancelationDate));
		dataBase.remove(user.getId());
	}
}
