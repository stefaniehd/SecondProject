/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Models;

import Utils.FileManager;
import java.util.LinkedList;

/**
 *
 * @author Magdalena
 */
public class Statistics {

    private String loser;
    private String winner;
    private int empates;
    private int races;
    private LinkedList<Models.Swimmer> swimmer;
    private FileManager fileManager;

    public Statistics() {
        fileManager = new FileManager();
    }

    public String getLoser() {
        return loser;
    }

    public void setLoser(String loser) {
        this.loser = loser;
    }

    public String getWinner() {
        return winner;
    }

    public void setWinner(String winner) {
        this.winner = winner;
    }

    public int getEmpates() {
        return empates;
    }

    public void setEmpates(int empates) {
        this.empates = empates;
    }

    public int getRaces() {
        return races;
    }

    public void setRaces(int races) {
        this.races = races;
    }

    public LinkedList<Swimmer> getSwimmer() {
        return swimmer;
    }

    public void setSwimmer(LinkedList<Swimmer> swimmer) {
        this.swimmer = swimmer;
    }

    public void clean(){
        fileManager.write("statistics.txt", 0+";"+0);
    }
    
    public String generateReport() {
        int empates = 0;
        int races = 0;
        try {
            String[] text = fileManager.read("statistics.txt").split(";");
            empates = Integer.parseInt(text[0]);
            races = Integer.parseInt(text[1]);
        } catch (Exception e) {
        }
        String result = "";
        empates += this.getEmpates();
        races += this.getRaces();
        for (int i = 0; i < swimmer.size(); i++) {
            result += swimmer.get(i).getName() + " " + swimmer.get(i).getLastName() + " ha ganado "
                    + swimmer.get(i).getGanadas() + " veces\n";
        }
        result += "Carreras efectuadas: " + this.getRaces();
        result += "\n"+ganador() + " ha ganado más veces.\n";
        result += perdedor() + " ha perdido más veces.\n";
        result += "Empates registrados: " + this.getEmpates()+"\n";
        fileManager.write("statistics.txt", this.getRaces() + ";" + this.getEmpates());
        return result;
    }

    private String ganador() {
        String nombre = "";
        try {
            nombre = swimmer.get(0).getName() + " " + swimmer.get(0).getLastName();
            for (int i = 1; i < swimmer.size(); i++) {
                if (swimmer.get(0).getGanadas() < swimmer.get(i).getGanadas()) {
                    nombre = swimmer.get(i).getName() + " " + swimmer.get(i).getLastName();
                }
            }
        } catch (Exception e) {
        }
        return nombre;
    }

    private String perdedor() {
        String nombre = "";
        try {
            nombre = swimmer.get(0).getName() + " " + swimmer.get(0).getLastName();
            for (int i = 1; i < swimmer.size(); i++) {
                if (swimmer.get(0).getPerdidas() < swimmer.get(i).getPerdidas()) {
                    nombre = swimmer.get(i).getName() + " " + swimmer.get(i).getLastName();
                }
            }
        } catch (Exception e) {
        }
        return nombre;
    }
}
