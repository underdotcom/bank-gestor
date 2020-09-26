package model;

import java.time.LocalDate;
import java.util.ArrayList;
import interfaces.*;
import structures.*;

public class Bank {

	private final int ARRAY_SIZE = 100;
	
	private InterfaceHashTable<String, User> dataBase;
	private ArrayList<User> presentUsersList;
	private InterfaceHashTable<String, Desertor> deserters;
	private InterfaceQueue<Turn> commonTurns;
	//cola de prioridad AllWithPriority>0
	
	public Bank() {
		dataBase = new HashTable<String, User>(ARRAY_SIZE);
		deserters = new HashTable<String, Desertor>(ARRAY_SIZE/2);
		commonTurns = new Queue<Turn>();
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
			commonTurns.enqueue(turn);
		}
		
		presentUsersList.add(dataBase.getValue(turn.getId()));
	}
	
	public void attendCommon(int option) {
		
		//Aqui van las opciones.
		
		
		String idDelete = commonTurns.dequeue().getData().getId();
		boolean delete = false;
		for (int i = 0; i < presentUsersList.size() && !delete; i++) {
			if(presentUsersList.get(i).getId().equals(idDelete)) {
				presentUsersList.remove(i);
				delete = true;
			}
		}
	}
	
	public void attendSpecial(int option) {
		
		
		
		//Elimina de la cola prioritaria
	}
	
	//Cualquier cliente
	private void cancelAccount(User user, String cancelationReason, LocalDate cancelationDate) {
		deserters.add(user.getId(), new Desertor(user, cancelationReason, cancelationDate));
		dataBase.remove(user.getId());
	}
	
	//Cuenta de ahorro
	//--
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
	//--
	
	
	//Credit
	//--
	private boolean pagarTarjeta(String id, boolean cash) {
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
