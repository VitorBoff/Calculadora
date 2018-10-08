/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.control;

import calculadora.model.Historico;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * FXML Controller class
 *
 * @author 04026720209
 */
public class CalculadoraController implements Initializable {

    @FXML
    private TextField txtNum1;
    @FXML
    private TextField txtNum2;
    @FXML
    private TextField txtResultado;
    @FXML
    private TextField txtOperador;

    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
   private void somar(ActionEvent event) {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
    EntityManager  em = emf.createEntityManager();
    
        Historico historico1 = new Historico();
        
        historico1.setPrimeiroValor(Double.parseDouble(txtNum1.getText()));
        historico1.setPrimeiroValor(Double.parseDouble(txtNum2.getText()));
        historico1.setOperador(txtOperador.getText());

        em.getTransaction().begin();
        em.persist(historico1);
        em.getTransaction().commit();
    
     
     Double num1 = Double.parseDouble(txtNum1.getText());
     Double num2 = Double.parseDouble(txtNum2.getText());
     Double result;
     
     result = num1 + num2;
     
     txtResultado.setText(result.toString());
     historico1.setOperador("+");
     
   }
   
    @FXML
    private void subtrair(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager  em = emf.createEntityManager();
    
        Historico historico1 = new Historico();
        
        historico1.setPrimeiroValor(Double.parseDouble(txtNum1.getText()));
        historico1.setPrimeiroValor(Double.parseDouble(txtNum2.getText()));
        historico1.setOperador(txtOperador.getText());

        em.getTransaction().begin();
        em.persist(historico1);
        em.getTransaction().commit();   
        
     Double num1 = Double.parseDouble(txtNum1.getText());
     Double num2 = Double.parseDouble(txtNum2.getText());
     Double result;
     
     result = num1 - num2;
     
     txtResultado.setText(result.toString());
     historico1.setOperador("-");
    }
     
     @FXML
    private void dividir(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager  em = emf.createEntityManager();
    
        Historico historico1 = new Historico();
        
        historico1.setPrimeiroValor(Double.parseDouble(txtNum1.getText()));
        historico1.setPrimeiroValor(Double.parseDouble(txtNum2.getText()));
        historico1.setOperador(txtOperador.getText());

        em.getTransaction().begin();
        em.persist(historico1);
        em.getTransaction().commit();   
        
     Double num1 = Double.parseDouble(txtNum1.getText());
     Double num2 = Double.parseDouble(txtNum2.getText());
     Double result;
     
     result = num1 / num2;
     
     txtResultado.setText(result.toString());
      txtOperador.setText("/");
    }
    
     @FXML
    private void multiplicar(ActionEvent event) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("aula");
        EntityManager  em = emf.createEntityManager();
    
        Historico historico1 = new Historico();
        
        historico1.setPrimeiroValor(Double.parseDouble(txtNum1.getText()));
        historico1.setPrimeiroValor(Double.parseDouble(txtNum2.getText()));
        historico1.setOperador(txtOperador.getText());

        em.getTransaction().begin();
        em.persist(historico1);
        em.getTransaction().commit();
        
     Double num1 = Double.parseDouble(txtNum1.getText());
     Double num2 = Double.parseDouble(txtNum2.getText());
     Double result;
     
     result = num1 * num2;
     
      txtResultado.setText(result.toString());
       txtOperador.setText("*");
    }
}