package ui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

import model.Bank;
import model.CreditCard;
import model.User;

public class PrimaryPageGUI {
	
	private Bank bank;
	
	private User currentUser;

	////////// Containers
    @FXML
    private BorderPane borderPrimary;

    @FXML
    private BorderPane primaryBorder;
    
    @FXML
    private BorderPane borderMain;
    
    @FXML
   	private TabPane tabPanePrimary;
    
    ////////// Tap Pane
   
    @FXML
    private TableView<User> queueCommonTable;

    @FXML
    private TableView<User> queuePrioritaryTable;

    @FXML
    private TableView<User> dataBase;
    
    @FXML
    private TableView<User> queueCommonColumn;
    
    @FXML
    private TableColumn<User, String> commonColumn;

    @FXML
    private TableColumn<User, String> priorityColumn;

    @FXML
    private TableColumn<User, String> ccColumn;

    @FXML
    private TableColumn<User, String>  nameColumn;

    @FXML
    private TableColumn<User, String> accountNumberColumn;

    @FXML
    private TableColumn<User, String> connectionDateColumn;

    @FXML
    private TableColumn<User, String> balanceColumn;

    @FXML
    private TableColumn<User, String>  payDateColumn;

    @FXML
    private TableColumn<User, String>  cardColumn;

    @FXML
    private TableColumn<User, String>  currentColumn;

    @FXML
    private TableColumn<User, String>  creditColumn;
    
    
    
    /////////// 	
    
    @FXML
    private Label nameField;

    @FXML
    private Label balanceField;
    
    @FXML
    private Label idField;
    
    @FXML
    private Text balanceOwingCreditText;

    @FXML
    private Text payDateText;
    
    @FXML
    private TextArea cancelReasonText;

    @FXML
    private TextField amountCreditCard;
    
    @FXML
    private TextField amountCurrent;
    
    @FXML
    private ToggleGroup currentAction;
   
    @FXML
    private ToggleGroup creditAction;
    
    @FXML
    private RadioButton cashRadioButton;

    @FXML
    private RadioButton savingButton;

    @FXML
    private RadioButton withdrawRadioButton;

    @FXML
    private RadioButton consignmentRadioButton;

    @FXML
    private DatePicker dateCancellation;

    @FXML
    private ChoiceBox<String> criteriaChoiceBox;

    @FXML
    private ChoiceBox<String> sortChoiceBox;

    public PrimaryPageGUI() throws IOException{
    	bank= new Bank();
    	currentUser=null;
    }
    
    @FXML
    void clickAttentCommon(ActionEvent event) throws IOException {
    	currentUser();
    	
    	if(currentUser==null) {
    		generateAlert("The queues are empty", AlertType.ERROR);    	
    	}else {
    		load("BankSecondPage.fxml");
	        nameField.setText(""+currentUser.getName());
	        idField.setText(""+currentUser.getId());
	        balanceField.setText(""+currentUser.getCurrentAccount().getBalanceAvailable());
	        balanceOwingCreditText.setText( String.valueOf((((CreditCard)currentUser.getCreditCard()).getBalanceOwing())));
	        LocalDate date= ((CreditCard) currentUser.getCreditCard()).getPayDate();
	        payDateText.setText(date.toString());     		
    	}
    }

    @FXML
    void clickAttentPrioritary(ActionEvent event) throws IOException {
    	load("BankSecondPage.fxml");
    }

    @FXML
    void clickSort(ActionEvent event) {
    
    }

    @FXML
    void acceptClickWC(ActionEvent event) throws IOException {
    	try {
    		double amount= Double.parseDouble(amountCurrent.getText());
    		if(withdrawRadioButton.isSelected()) {
        		bank.attendCommon(1, currentUser.getId(), amount, null, null, false);
        	}else if(consignmentRadioButton.isSelected()) {
        		bank.attendCommon(2, currentUser.getId(), amount, null, null, false);
        	}
    		generateAlert("Amount Modificated Succesfully. /n Actual Amount: "+currentUser.getCurrentAccount().getBalanceAvailable(), AlertType.INFORMATION);
    		loadMenu();
    	}catch(NumberFormatException e) {
    		generateAlert("Write an amount, please", AlertType.ERROR);
    	}

    }
    
    @FXML
    void acceptClickCancel(ActionEvent event) {
    	if(cancelReasonText.getText().equals("")) {
    		generateAlert("Please, write the reason of your goodybye", AlertType.ERROR);	
    	}else {
    		bank.attendCommon(2, currentUser.getId(), 0, cancelReasonText.getText(), dateCancellation.getValue(), false);
    		generateAlert("Account cancelled Succesfully. We are sorry for you goodybye",AlertType.INFORMATION);
    	}
    }

    @FXML
    void acceptClickPay(ActionEvent event) {
    	try {
    		if(cashRadioButton.isSelected()) {
    			bank.attendCommon(2, currentUser.getId(), 0, cancelReasonText.getText(), dateCancellation.getValue(), true);
    		}else {
    			bank.attendCommon(3, currentUser.getId(), 0, null, null, false);
    		}	
    	}catch(NumberFormatException e) {
    		generateAlert("Write an amount, please",AlertType.ERROR);
    	}
    }

    @FXML
    void backClick(MouseEvent event) throws IOException {
    	loadMenu();
    	generateUser();
    }
    
    @FXML
    void generateUserClick(ActionEvent event) {
    	bank.addNewTurn();
    	generateUser();
    }

    @FXML
    void undoClick(MouseEvent event) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////
   
    void currentUser() {
    	String id=bank.attend(1);
    	currentUser=bank.searchUser(id);
    }
    
    @FXML
    void startButton(MouseEvent event) throws IOException {
    	loadMenu();
    }

    void loadMenu() throws IOException {
    	FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("BankPrincipalPage.fxml"));
    	fxmlLoader.setController(this);
    	Parent parent = fxmlLoader.load();
    	borderMain.setCenter(parent); 
    }
    
    void load(String route) throws IOException {
    	FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource(route));
    	fxmlLoader.setController(this);
    	Parent parent = fxmlLoader.load();
    	borderMain.setCenter(parent); 
    }
    
    void generateAlert(String msg, AlertType type) {
    	Alert alert = new Alert(type);
    	alert.setContentText(msg);
    	alert.show();
    }
    
    void generateUser() {
    	ArrayList<User> commonUser= bank.commonList();
    	ArrayList<User> priorityUser= bank.priorityList();
  
    	ObservableList<User> itemsC=FXCollections.observableArrayList(commonUser);
    	ObservableList<User> itemsP=FXCollections.observableArrayList(priorityUser);
    	
    	queueCommonTable.setItems(itemsC);
    	queuePrioritaryTable.setItems(itemsP);
    	
    	commonColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Id"));
    	priorityColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Id"));
    }
}
