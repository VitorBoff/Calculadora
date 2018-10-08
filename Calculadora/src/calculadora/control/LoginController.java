/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculadora.control;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import calculadora.model.Usuario;

/**
 * FXML Controller class
 *
 * @author 04646777266
 */
public class LoginController implements Initializable {

    @FXML
    private TextField TxtUsuario;
    @FXML
    private TextField TxtSenha;
    @FXML
    private Button btnEntrar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    private void fechar(){
    Stage stage = (Stage) btnEntrar.getScene().getWindow();
    stage.close();
    }
    @FXML
    private void Logar(ActionEvent event) throws IOException{ 
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("calculadora");
        EntityManager em = emf.createEntityManager();
       
        Query query = em.createQuery("SELECT u FROM Aluno as u WHERE u.usuario = :user");
        query.setParameter("user", TxtUsuario.getText());
        
         if(query.getResultList().isEmpty()){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("O usuário não existe");
            alert.showAndWait();
            TxtUsuario.setText("");
            TxtSenha.setText("");
        }
        else{
             Usuario f = (Usuario) query.getSingleResult();
                if (!f.getSenha().equals(TxtSenha.getText())){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("Senha não confere");
                alert.showAndWait();
                TxtSenha.setText("");
            }
            else{        
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/br/edu/ifro/view/Principal.fxml"));
                Scene scene = new Scene(fxmlLoader.load());
                Stage stage = new Stage();
                stage.setTitle("Menu Principal");
                stage.setScene(scene);
                stage.show();
                
            
               TxtSenha.setText("");
               fechar();
            }
        }      
}
}