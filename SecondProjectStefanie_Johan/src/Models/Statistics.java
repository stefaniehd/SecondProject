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
 * @author Stefanie
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

    /**
     * cleans the text file qith the statistics
     */
    public void clean() {
        fileManager.write("Statistics.txt", "0;0");
    }

    /**
     * loads the statistics from a text file
     * @return a list with the statistics
     */
    public Models.Statistics load() {
        Models.Statistics s = new Statistics();
        String[] text = fileManager.read("Statistics.txt").split(";");
        try {
            s.setRaces(Integer.parseInt(text[0].replace('\n', ' ').trim()));
            s.setEmpates(Integer.parseInt(text[1].replace('\n', ' ').trim()));
        } catch (Exception e) {
        }
        return s;
    }

    /**
     * generates a report with the statistics
     * @return the report
     */
    public String generateReport() {
        String result = "";
        Models.Statistics s = load();
        result += "---------Cantidad de veces ganadas---------\n\n";
        for (int i = 0; i < swimmer.size(); i++) {
            result += swimmer.get(i).getName() + " " + swimmer.get(i).getLastName() + " ha ganado "
                    + swimmer.get(i).getGanadas();
            if (swimmer.get(i).getGanadas() == 1) {
                result += " vez\n";
            } else {
                result += " veces\n";
            }
        }
        result += "\n--------------Perdedor y ganador-------------\n";
        result += "\n" + ganador() + " ha ganado más veces.\n";
        result += perdedor() + " ha perdido más veces.\n";
        result += "\n-----Carreras y empates registrados-----\n\n";
        result += "Carreras efectuadas: " + s.getRaces() + "\n";
        result += "Empates registrados: " + s.getEmpates();
        return result;
    }

    /**
     * updates the statistics
     */
    public void update() {
        int emp = 0;
        int carreras = 0;
        emp += this.getEmpates();
        carreras += this.getRaces();
        fileManager.write("Statistics.txt", carreras + ";" + emp);
    }

    /**
     * looks for the person who has won the most
     * @return the name
     */
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

    /**
     * looks for the person who has lost the most
     * @return the name
     */
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
