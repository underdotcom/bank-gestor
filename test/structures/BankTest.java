package structures;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.time.LocalDate;
import org.junit.Test;
import model.Bank;
import model.CreditCard;
import model.RandomGenerator;


public class BankTest {
	private Bank bank;
	
	void setUp1() throws IOException {
		 bank= new Bank();
	}

	
	@Test
	public void initializeTestCasesTest() throws IOException {
		setUp1();
		assertEquals(bank.getSizeDataBase(), 100);
		//// First Case. It create one user with the ID 1 in the array
		bank.addNewTurn();
		if( bank.getCommonList().size()>0) {
		assertEquals(String.valueOf(RandomGenerator.ID[1]), bank.getCommonList().get(0).getId());
		}else {
			
		}
	}
	
	@Test
	public void addNewTurnTest() throws IOException {
		setUp1();
		//// First case. In the empty hash, a new element has added
		bank.addNewTurn();
		assertEquals(String.valueOf(RandomGenerator.ID[1]), bank.searchUser(String.valueOf(RandomGenerator.ID[1])).getId());
		if(bank.getCommonList().size()>0) {
			assertEquals(String.valueOf(RandomGenerator.ID[1]), bank.getCommonList().get(0).getId());
		}else {
			
		}
		
		//// Second case. The hash has elements. It has to add the ID[4] of randomGenerator to the hashTable successfully and in the arraylist of turns
		bank.addNewTurn();
		bank.addNewTurn();
		bank.addNewTurn();

		if(bank.getCommonList().size()>0) { /////test to common 
			assertEquals(String.valueOf(RandomGenerator.ID[4]), bank.searchUser(String.valueOf(RandomGenerator.ID[4])).getId());
		}
		
	}

	@Test
	public void cancelAccountTest() throws IOException {
		setUp1();
		
		//// First case. The bank just has one user
		bank.addNewTurn();
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			bank.attend(3, userId, 0.0, "Too much expensive for me", LocalDate.now(), false);
			assertNull(bank.searchUser(userId));
			assertEquals(bank.getDesertors().get(0).getId(), userId);
			assertEquals(bank.searchDesertor(userId).getId(),userId);
			bank.deleteUser(userId);
		}
		
		//// Second case. The bank have more clients in a queue and all of them cancel their accounts.
		bank.addNewTurn();
		bank.addNewTurn();
		bank.addNewTurn();
		
		for (int i = 0; i < 2; i++) {
		try {
			if(bank.getCommonList().size()>i) { ///test for commons
				String userId=bank.getCommonList().get(i).getId();
				bank.attend(3, userId, 0.0, "Too much expensive for me", LocalDate.now(), false);
				assertNull(bank.searchUser(userId));
				assertEquals(bank.getDesertors().get(i+1).getId(), userId);
				assertEquals(bank.searchDesertor(userId).getId(),userId);
			}
		}catch(IndexOutOfBoundsException e) {
			assertTrue(false, "This Test Case is volatile because the random system can create a 2 common users or 1 User or even nothing. Instead, this created an another type of User");
			}	
		}
	}
	
	@Test
	public void withDrawalsTest() throws IOException {
		setUp1();
		double amountTowithdraw = 150.5;
		
		//// First case. The bank just has one user
		bank.addNewTurn();
		
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			int finalAmount= (int)(bank.searchUser(userId).getCurrentAccount().getBalanceAvailable() - amountTowithdraw);
			bank.attend(1, userId, amountTowithdraw , null, LocalDate.now(), false);
			assertEquals(finalAmount, (int)bank.searchUser(userId).getCurrentAccount().getBalanceAvailable());
			bank.deleteUser(userId);
		}else 
		
		//// Second case. The amount is same than the available
		bank.addNewTurn();
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			amountTowithdraw=bank.searchUser(userId).getCurrentAccount().getBalanceAvailable();
			int finalAmount= (int)(bank.searchUser(userId).getCurrentAccount().getBalanceAvailable() - amountTowithdraw);
			bank.attend(1, userId, amountTowithdraw , null, LocalDate.now(), false);
			assertEquals(finalAmount, (int)bank.searchUser(userId).getCurrentAccount().getBalanceAvailable());
			bank.deleteUser(userId);
		}
		bank.addNewTurn();
		//// Third case. The amount is superior than the available
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			amountTowithdraw=bank.searchUser(userId).getCurrentAccount().getBalanceAvailable()+100;
			assertFalse("It is accepting wrong values", bank.attend(1, userId, amountTowithdraw , null, LocalDate.now(), false));
		}else { ////// test for prioritary
				
		}
	}
	
	@Test
	public void payCreditCardTest() throws IOException {
		setUp1();
		////// First case. The user pay on the day of pay and it pays with cash
		bank.addNewTurn();
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			bank.attend(4, userId, 0.0 ,null , LocalDate.now(), true);
			assertEquals((int)bank.searchUser(userId).getCreditCard().getBalanceAvailable(),(int)CreditCard.quota);
			bank.deleteUser(userId);
		}
		
		///// Second case. The user pay on the dat but use it money of currentCount
		bank.addNewTurn();
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			bank.searchUser(userId).getCurrentAccount().setBalanceAvailable(5000000);
			assertTrue(bank.attend(4, userId, 0.0 ,null , LocalDate.now(), false));
			assertEquals((int)bank.searchUser(userId).getCreditCard().getBalanceAvailable(),(int)CreditCard.quota);
			bank.deleteUser(userId);
		}
		
		//// Third case. The user pay on the day, use money from it currentAccount but in this time, it isn't enought
		bank.addNewTurn();
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			bank.searchUser(userId).getCurrentAccount().setBalanceAvailable(0);
			bank.attend(4, userId, 0.0 ,null , LocalDate.now(), false);
		}
		
	}
	
	@Test
	public void consignTest() throws IOException {
		setUp1();
		double amount=1800.0;
		bank.addNewTurn();
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			int total= (int)(bank.searchUser(userId).getCurrentAccount().getBalanceAvailable() +amount);
		
			bank.attend(2, userId, amount ,null , LocalDate.now(), false);
			assertEquals((int)(bank.searchUser(userId).getCurrentAccount().getBalanceAvailable()), total);
		
		}
		
	}

	@Test
	public void deleteUser() throws IOException {
		setUp1();
		//// First case. The bank just have one person in a queue
		bank.addNewTurn();
		if(bank.getCommonList().size()>0) { ///test for commons
			String userId=bank.getCommonList().get(0).getId();
			bank.deleteUser(userId);
			try {
				assertNull(bank.getCommonList().get(0));
			}catch(IndexOutOfBoundsException e) {
				assertTrue(true, "Everything right");
			}
		}
	}
}

