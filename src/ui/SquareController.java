package ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import model.Square;

public class SquareController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField txtOrder;

    @FXML
    private Label txtAdvice;


    @FXML
    private BorderPane borderLocal;

    @FXML
    private ComboBox<?> startOption;

    @FXML
    private ComboBox<?> wayOption;
    
    @FXML
    private GridPane square;
    
    private Square s;
    
    
    @FXML
    void initialize() {
    	s = new Square();
    	 	
    }
    
    public int startValue(String first) {
    	int n = 0;
    	if(first.equals("Up-Center")) {
    		n=1;
    	}else if(first.equals("Down-Center")) {
    		n=2;
    	}/*else if(first.equals("Left-Center")) {
    		n=3;
    	}else {
    		n=4;
    	}*/
    	return n;
    }
    
    public int wayValue(String way) {
    	
    	int n = 0;
    	if(way.equals("NO")) {
    		n=1;
    	}else if(way.equals("NE")) {
    		n=2;
    	}else if(way.equals("SO")) {
    		n=3;
    	}else {
    		n=4;
    	}
    	return n;
    }
    
    public void generateSquare(ActionEvent event) {
    	
    	
    	//square.setGridLinesVisible(true);
    	try{
    		
        square.getChildren().clear();
    	
    	int o = Integer.parseInt(txtOrder.getText());
    	s.setOrder(o);
    	
    	}catch (NumberFormatException eo) {
    		
    		txtAdvice.setText("The value is invalid, please insert another one");
    		
    	} catch (NegativeArraySizeException oe) {
    		
    		txtAdvice.setText("The value is invalid");
    		
    	}
    	
    	if(s.check()==true) {
    		txtAdvice.setVisible(false);
    		square.setGridLinesVisible(true);
    		System.out.println("Generando...");
        	
        	String first =(String) startOption.getValue();
        	String way = (String) wayOption.getValue();
        	int f = startValue(first);
        	int w = wayValue(way);
        	
        	
        	int[][] matrix = s.generate();
        	s.fill(f, w);
        	
        	for(int i=0; i < matrix.length; i++) {
        		for(int j=0; j < matrix.length; j++) {
        			if(j==matrix.length-1) {
        				System.out.print(matrix[i][j]+"\t\n");
        			}else {
        				System.out.print(matrix[i][j]+"\t");
        			}
        			Button label = new Button(matrix[i][j]+"");
        			square.add(label, j, i);
        		}
        	}
    	}else {
    		txtAdvice.setVisible(true);
    	}
    	
    	
    	
    }
    
    

}
