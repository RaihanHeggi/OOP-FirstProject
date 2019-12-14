/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;
import View.*;
import Controller.*;
import Database.*;
/**
 *
 * @author user
 */
public class Driver {
    public static void main(String[] args) {
        Database db = new Database();
        db.connect();
        
        new HomeGUIController();
    }
}
