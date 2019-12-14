/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eLearning;

/**
 *
 * @author user
 */
abstract class Person {
   public Person(String s,int u){
       setName(s);
       setAge(u);
   }
   public abstract void setName(String s);
   public abstract void setAge(int u);  
}
