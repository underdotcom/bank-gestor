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
		
		initializeTestCases();
	}

	private void initializeTestCases() {
		
	}
	
	public void addNewUser(User user) {
		dataBase.add(user.getId(), user);
	}
	
	public void addNewTurn(Turn turn) {
		if(turn.getPriorityValue()>0) {
			//addTurnPriority
		}else {
			//addTurnCommon
		}
		
		presentUsersList.add(dataBase.getValue(turn.getId()));
	}
	
	public void attendCommon(int option) {
		
		
		
		//Elimina de la cola prioritaria
	}
	
	public void attendSpecial(int option) {
		
		
		
		//Elimina de la cola 
	}
	
	//Cualquier cliente
	private void cancelAccount(User user, String cancelationReason, LocalDate cancelationDate) {
		deserters.add(user.getId(), new Desertor(user, cancelationReason, cancelationDate));
		dataBase.remove(user.getId());
	}
	
	//Cuenta de ahorro
	//retirar
	//consignar
	
	
	//Credit
	//Pagar tarjeta
	
	
	//sort merge
	//heapSort
	//Collectios
}
