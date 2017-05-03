package controller;

import model.User;
import view.AdminFrame;
import view.EmployeeFrame;
import view.IntroFrame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by dandeac on 02/05/2017.
 */
public class MainController {
    IntroFrame introFrame;

    public MainController(IntroFrame frame){
        this.introFrame=frame;
        introFrame.addLoginListener(new LoginListener());
    }
    public class LoginListener implements ActionListener{
        public void actionPerformed(ActionEvent event){
            if(event.getActionCommand().equalsIgnoreCase("Click")){
                if(User.loginVerification(introFrame.getUsername(),introFrame.getPassword()))
                {
                    if(User.getUserType(introFrame.getUsername()).equalsIgnoreCase("admin"))
                        new AdminController(new AdminFrame());
                    else new EmployeeController(new EmployeeFrame());
                    introFrame.closeWindow();
                }
                else introFrame.displayMessage("Wrong username or password!");
            }
        }
    }

    public static void main(String[] args){
            new MainController(new IntroFrame());
    }
}
