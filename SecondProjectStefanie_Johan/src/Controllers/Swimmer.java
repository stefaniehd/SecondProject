/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

import java.util.LinkedList;

/**
 *
 * @author Stefanie
 */
public class Swimmer {
    private Models.Swimmer swimmer;

    public Swimmer(Models.Swimmer swimmer) {
        this.swimmer = swimmer;
    }

    public Swimmer() {
        swimmer= new Models.Swimmer();
    }
    
    public void add(){
        swimmer.add();
    }
    
    public void delete(){
        swimmer.delete();
    }
    
    public LinkedList<Models.Swimmer> select(){
        return swimmer.select();
    }
    
    public void update(){
        swimmer.update();
    }
}
