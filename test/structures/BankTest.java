package structures;
import java.io.IOException;
import org.junit.Test;
import model.Bank;
import model.RandomGenerator;
import model.User;

public class BankTest {
	private Bank bank;
	void setUp1() throws IOException {
		 bank= new Bank();
	}
	
	@Test
	public void initializeTestCasesTest() throws IOException {
		setUp1();
		User user=null;
		RandomGenerator randomData = new RandomGenerator(100);

		
		for (int i = 0; i < 99; i++) {
			String key=String.valueOf(randomData.getId(i));
			System.out.println("keys: "+ key);
			System.out.println(user.toString());
		}
		
	}
}
