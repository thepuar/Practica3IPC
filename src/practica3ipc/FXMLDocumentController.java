/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica3ipc;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

/**
 *
 * @author frapecha
 */
public class FXMLDocumentController implements Initializable {
    
    private Label label;
    @FXML
    private TextField textbox;
    @FXML
    private Label LabelInfo;
    @FXML
    private Button ButtonAdd;
    @FXML
    private Button ButtonDelete;
    @FXML
    private ListView<String> MiListView;
    
    private ObservableList<String> olist = null;
    
    private void handleButtonAction(ActionEvent event) {
        System.out.println("You clicked me!");
        label.setText("Hello World!");
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        ButtonAdd.setDisable(true);
        ButtonDelete.setDisable(true);
        
        ArrayList<String> misdatos = new ArrayList<>();
        
        misdatos.add("Java");
        misdatos.add("JavaFX");
        misdatos.add("C++");
        misdatos.add("Python");
        misdatos.add("JavaScript");
        misdatos.add("C#");
        olist = FXCollections.observableArrayList(misdatos);
        MiListView.setItems(olist);
        
        
        // TODO
        
        textbox.textProperty().addListener((o,oldval,newval)->{
        if(newval.length()>0)ButtonAdd.setDisable(false);
        else ButtonAdd.setDisable(true);
        
        });
        
        MiListView.getSelectionModel().selectedIndexProperty().addListener((o,oldval,newval)->{
            if(newval.intValue()==-1){ButtonDelete.setDisable(true);
                this.LabelInfo.setText("Selected: none");
            }else{
                ButtonDelete.setDisable(false);
                this.LabelInfo.setText("Selected: "+olist.get(newval.intValue()));
            }
        
        });
        
        
        
    }    

    @FXML
    private void onPressed(ActionEvent event) {
        if(textbox.getText().length()>0){
            this.olist.add(textbox.getText());
            textbox.setText("");
        }
    }

    @FXML
    private void OnPressedDelete(ActionEvent event) {
        olist.remove(MiListView.getSelectionModel().selectedIndexProperty().getValue().intValue());
        System.out.println("Eliminando elemento: "+MiListView.getSelectionModel().selectedIndexProperty().getValue());
        System.out.println("Tamaño de olist: "+olist.size());
    }
    
}
