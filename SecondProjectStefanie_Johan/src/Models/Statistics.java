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

    public void clean() {
        fileManager.write("Statistics.txt", "0;0");
    }

    public Models.Statistics load() {
        Models.Statistics s = new Statistics();
        String[] text = fileManager.read("Statistics.txt").split(";");
        try {
            s.setEmpates(Integer.parseInt(text[0]));
            s.setRaces(Integer.parseInt(text[1]));
        } catch (Exception e) {
        }
        return s;
    }

    public String generateReport() {
        String result = "";
        for (int i = 0; i < swimmer.size(); i++) {
            result += swimmer.get(i).getName() + " " + swimmer.get(i).getLastName() + " ha ganado "
                    + swimmer.get(i).getGanadas();
            if (swimmer.get(i).getGanadas() == 1) {
                result += " vez\n";
            } else {
                result += " veces\n";
            }
        }
        result += "Carreras efectuadas: " + this.getRaces();
        result += "\n" + ganador() + " ha ganado más veces.\n";
        result += perdedor() + " ha perdido más veces.\n";
        result += "Empates registrados: " + this.getEmpates() + "\n";
        return result;
    }

    public void update() {
        int emp = 0;
        int carreras = 0;
        Models.Statistics s = this.load();
        try {
            String[] text = fileManager.read("Statistics.txt").split(";");
            emp = Integer.parseInt(text[0]);
            carreras = Integer.parseInt(text[1]);
        } catch (Exception e) {
        }
        emp += this.getEmpates();
        carreras += this.getRaces();
        fileManager.write("Statistics.txt", carreras + ";" + emp);
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
