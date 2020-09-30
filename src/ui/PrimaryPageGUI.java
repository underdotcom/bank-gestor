package ui;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Optional;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ChoiceBox;
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
    private AnchorPane anchorMain;
    
    @FXML
   	private TabPane tabPanePrimary;
    
    @FXML
    private AnchorPane borderCenter;
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
    
    @FXML
    private Tab cpTab;
    
    @FXML
    private Tab cTab;
    
    @FXML
    private Tab wcTab;
    
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
    private Label dateCancelation;

    @FXML
    private ChoiceBox<String> criteriaChoiceBox;

    @FXML
    private ChoiceBox<String> sortChoiceBox;
    
    @FXML
    private Button buttonStart;
    
    @FXML
    private Button backButton;

    @FXML
    private Button undoButton;

    @FXML
    void startButton(ActionEvent event) throws IOException {
    	buttonStart.setVisible(false);
    	anchorMain.setStyle("-fx-background-color: #ffffff");
    	loadMenu();
    }

    public PrimaryPageGUI() throws IOException{
    	bank= new Bank();
    	currentUser=null;
    }
    
    @FXML
    void clickAttentCommon(ActionEvent event) throws IOException {
    	try {
    		currentUser(0);
    		loadInformation();
    	}catch(NullPointerException e) {
    		generateAlert("Queue empty", AlertType.INFORMATION);
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
    		if(withdrawRadioButton.isSelected()==false && consignmentRadioButton.isSelected()==false ) {
    			generateAlert("Please, choose an option", AlertType.ERROR);
    		}else if(withdrawRadioButton.isSelected()) {
        		bank.attendCommon(1, currentUser.getId(), amount, null, null, false);
        		 generateAlert("Amount Modificated Succesfully. Do you want to exit?", AlertType.CONFIRMATION);
        	}else if(consignmentRadioButton.isSelected()) {
        		bank.attendCommon(2, currentUser.getId(), amount, null, null, false);
        		 generateAlert("Amount Modificated Succesfully. Do you want to exit?", AlertType.CONFIRMATION);
        	}
    		updateInformation();
    	}catch(NumberFormatException e) {
    		generateAlert("Write an amount, please", AlertType.ERROR);
    	}
    }
    
    @FXML
    void acceptClickCancel(ActionEvent event) throws IOException {
    	if(cancelReasonText.getText().equals("")) {
    		generateAlert("Please, write the reason of your goodybye", AlertType.ERROR);	
    	}else {
    		updateInformation();
    		bank.attendCommon(2, currentUser.getId(), 0, cancelReasonText.getText(), LocalDate.now(), false);
    		generateAlert("Account cancelled Succesfully. We are sorry for you goodybye. Do you want to exit?",AlertType.CONFIRMATION);
    	}
    }

    @FXML
    void acceptClickPay(ActionEvent event) throws IOException {
    	try {
    		if(cashRadioButton.isSelected()==false && savingButton.isSelected()==false) {
    			generateAlert("Please, choose an option", AlertType.ERROR);
    		}else if(cashRadioButton.isSelected()) {
    			bank.attendCommon(2, currentUser.getId(), 0.0, null, null, true);
    			generateAlert("Pay Sucessful. Do you want to exit?",AlertType.CONFIRMATION);
    		}else if (savingButton.isSelected()){
    			bank.attendCommon(3, currentUser.getId(), 0.0, null, null, false);
    			generateAlert("Pay Sucessful. Do you want to exit?",AlertType.CONFIRMATION);
    		}
    		updateInformation();
    	}catch(NumberFormatException e) {
    		generateAlert("Write an amount, please",AlertType.ERROR);
    	}
    }
    
    @FXML
    void generateUserClick(ActionEvent event) {
    	bank.addNewTurn();
    	initialiceTableViews();
    }
    
    @FXML
    void backClick(ActionEvent event) throws IOException {
    	loadMenu();
    }

    @FXML
    void undoClick(ActionEvent event) {

    }

    ////////////////////////////////////////////////////////////////////////////////////////////
    
    void loadInformation() throws IOException {
    	if(currentUser==null) {
    		generateAlert("The queues are empty", AlertType.ERROR);    	
    	}else {
    		load("BankSecondPage.fxml");
    		updateInformation();
    	}
    }
    
    void updateInformation() {
    	backButton.setVisible(true);
		undoButton.setVisible(true);
		nameField.setText(""+currentUser.getName());
        idField.setText(""+currentUser.getId());
        dateCancelation.setText(LocalDate.now().toString());
        balanceField.setText("$ "+currentUser.getCurrentAccount().getBalanceAvailable());
        balanceOwingCreditText.setText( String.valueOf((((CreditCard)currentUser.getCreditCard()).getBalanceOwing())));
        payDateText.setText(((CreditCard) currentUser.getCreditCard()).getPayDate().toString());   
    }
    
    void currentUser(int type) {
    	if(type==0) {
    		String id=bank.getIdCommonClient();
        	currentUser=bank.searchUser(id);
    	}else {
    		String id=bank.getIdPrioritaryClient();
        	currentUser=bank.searchUser(id);
    	}
    }
    
    void loadMenu() throws IOException {
    	backButton.setVisible(false);
		undoButton.setVisible(false);
    	FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource("BankPrincipalPage.fxml"));
    	fxmlLoader.setController(this);
    	Parent parent = fxmlLoader.load();
    	anchorMain.getChildren().clear();
    	anchorMain.getChildren().addAll(parent);
    	initialiceTableViews();
    }
    
    void load(String route) throws IOException {
    	FXMLLoader fxmlLoader=new FXMLLoader(getClass().getResource(route));
    	fxmlLoader.setController(this);
    	Parent parent = fxmlLoader.load();
    	anchorMain.getChildren().clear();
    	anchorMain.getChildren().addAll(parent); 
    }
    
    void generateAlert(String msg, AlertType type) throws IOException {
    	Alert alert = new Alert(type);
    	alert.setContentText(msg);
    	if(type.equals(AlertType.CONFIRMATION)){
			ButtonType buttonTypeOne = new ButtonType("Yes");
			ButtonType buttonTypeTwo = new ButtonType("No");
			alert.getButtonTypes().setAll(buttonTypeOne, buttonTypeTwo);
    		Optional<ButtonType> result = alert.showAndWait();
    		if (result.get()== buttonTypeOne){
    		   bank.deleteUser(currentUser.getId());
    		   loadMenu();
    		   currentUser=null;
    		}
    	}
    	alert.show();
    }
    
    void initialiceTableViews() {
    	ArrayList<User> commonUser= bank.getCommonList();
    	ArrayList<User> priorityUser= bank.getPrioritayList();
  
    	ObservableList<User> itemsC=FXCollections.observableArrayList(commonUser);
    	ObservableList<User> itemsP=FXCollections.observableArrayList(priorityUser);
    	
    	queueCommonTable.setItems(itemsC);
    	queuePrioritaryTable.setItems(itemsP);
    	
    	commonColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Id"));
    	priorityColumn.setCellValueFactory(new PropertyValueFactory<User, String>("Id"));
    }
}
