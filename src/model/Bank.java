package model;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

import interfaces.*;
import sort_algorithms.*;
import structures.*;

public class Bank {

	private final int ARRAY_SIZE = 100;
	private InterfaceHashTable<String, User> dataBase;
	private InterfaceHashTable<String, Desertor> deserters;
	private InterfaceQueue<Turn> commonTurns;
	private InterfaceHeap<String, String> prioritaryTurns;
	
	private Sort<User> sort;
	private RandomGenerator randomData;
	private ArrayList<User> presentUsersList;
	private ArrayList<User> commonUser;
	private ArrayList<User> prioritaryUsers;
	private ArrayList<Desertor> desertorsList;
	private int index;
	//heap queue AllWithPriority>0
	
	public Bank() throws IOException {
		dataBase = new HashTable<String, User>(ARRAY_SIZE);
		deserters = new HashTable<String, Desertor>(ARRAY_SIZE/2);
		presentUsersList= new ArrayList <User>();
		commonUser= new ArrayList <User>();
		prioritaryUsers=new ArrayList<User>();
		desertorsList=new ArrayList<Desertor>();
		commonTurns = new Queue<Turn>();
		prioritaryTurns= new Heap<String, String>(100,100);
		randomData= new RandomGenerator(100);
		index=0;
		initializeTestCases();
	}

//////////////////////////////////////////////////////PRINCIPAL METHODS//////////////////////////////////////////////////////
	
	//////////////////////Any client//////////////////////////////////
	
	private void cancelAccount(String key, String cancelationReason, LocalDate cancelationDate) {
		User user=dataBase.getValue(key);
		deserters.add(user.getId(), new Desertor(user, cancelationReason, cancelationDate));
		dataBase.remove(user.getId());
		desertorsList.add(new Desertor(user, cancelationReason, cancelationDate));
	}
	
	///////////////////////Just Current Account //////////////////////
	private boolean withdrawals(String id, double ammount) {
		double actualBalance = dataBase.getValue(id).getCurrentAccount().getBalanceAvailable();
		if(actualBalance >= ammount) {
			dataBase.getValue(id).getCurrentAccount().setBalanceAvailable(actualBalance - ammount);
			return true;
		}
		return false;
	}
	
	private void consign(String id, double ammount) {
		double actualBalance = dataBase.getValue(id).getCurrentAccount().getBalanceAvailable();
		dataBase.getValue(id).getCurrentAccount().setBalanceAvailable(actualBalance + ammount);
		
	}
	
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
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
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
			prioritaryTurns.insert(new HeapNode<String, String>(turn.getUser(), turn.getId(), turn.getPriorityValue()));
		}else {
			commonUser.add(dataBase.getValue(turn.getId()));
			commonTurns.enqueue(turn);
		}
		presentUsersList.add(dataBase.getValue(turn.getId()));
	}
	
	public boolean attend(int option, String id, double amount, String cancelationReason, LocalDate cancelationDate,boolean cash) {
		if(option==1) {
			return withdrawals(id, amount);
		}else if(option==2) {
			consign(id, amount);
			return true;
		}else if(option==3) {
			cancelAccount(id, cancelationReason, cancelationDate);
			return true;
		}else {
			return payCreditCard(id, cash);
		}
	}
	
	public void deletePrioritaryUser(int option) {
		boolean delete = false;
		User aux=prioritaryUsers.get(0);
		prioritaryUsers.remove(0);
		for (int i = 0; i < presentUsersList.size() && !delete; i++) {
			if(presentUsersList.get(i).getId().equals(aux.getId())) {
				presentUsersList.remove(i);
				delete = true;
			}
		}
	}
	
	public void deleteUser(String id) {
		boolean delete = false;
		commonTurns.dequeue();
		commonUser.remove(0);
		for (int i = 0; i < presentUsersList.size() && !delete; i++) {
			if(presentUsersList.get(i).getId().equals(id)) {
				presentUsersList.remove(i);
				delete = true;
			}
		}
	}
	
	public void mergeSort(ArrayList<User> list) {
		sort = new MergeSort<User>();
		sort.sortAscending(list);
	}
	
	public void bubbleSort(ArrayList<User> list) {
		sort = new BubbleSort<User>();
		sort.sortAscending(list);
	}
	
	public void collectionsSort(ArrayList<User> list) {
		Collections.sort(list);
	}
	
	//heapSort
	
	/////////////////////////////////////////Getters Methods////////////////////////////////////////////////////////
	
	public ArrayList<User> getCommonList(){
		return commonUser;
	}
	
	public ArrayList<User> getPrioritayList(){
		return prioritaryUsers;
	}
	
	public ArrayList<User> getPresentUserList(){
		return presentUsersList;
	}
	
	public String getIdCommonClient() {
		return commonTurns.front().getData().getId();
	}
	
	public String getIdPrioritaryClient() {
		return prioritaryUsers.get(0).getId();
	}
	
	public ArrayList<Desertor> getDesertors(){
		return desertorsList;
	}
	
	public long getSizeDataBase() {
		return dataBase.getSize();
	}
	
	public User searchUser(String key) {
		return dataBase.getValue(key);
	}
	
	public User searchDesertor(String key) {
		return deserters.getValue(key);
	}
}
