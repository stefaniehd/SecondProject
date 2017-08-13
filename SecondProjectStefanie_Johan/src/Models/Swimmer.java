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
public class Swimmer {

    private String name;
    private String code;
    private String lastName;
    private int perdidas;
    private int ganadas;
    private String time;
    private boolean finish;
    private int velocity;
    private FileManager fileManager;

    public Swimmer() {
        fileManager = new FileManager();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getPerdidas() {
        return perdidas;
    }

    public void setPerdidas(int perdidas) {
        this.perdidas = perdidas;
    }

    public int getGanadas() {
        return ganadas;
    }

    public void setGanadas(int ganadas) {
        this.ganadas = ganadas;
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getVelocity() {
        return velocity;
    }

    public void setVelocity(int velocity) {
        this.velocity = velocity;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void add() {
        String text = "";
        try {
            text = fileManager.read("swimmers.txt");
        } catch (Exception e) {
            text = "";
        }
        text += this.getCode() + ";" + this.getName() + ";" + this.getLastName() + ";"
                + this.getGanadas() + ";" + this.getPerdidas();
        fileManager.write("swimmers.txt", text);
    }

    public void delete() {
        String[] text = fileManager.read("swimmers.txt").split("\n");
        String finalText = "";
        for (int i = 0; i < text.length; i++) {
            String[] data = text[i].split(";");
            if (!data[0].equals(this.getCode())) {
                finalText += text[i];
                if (i != (text.length - 1)) {
                    finalText += "\n";
                }
            }
        }
        fileManager.write("swimmers.txt", finalText);
    }

    public LinkedList<Models.Swimmer> select() {
        LinkedList<Models.Swimmer> s = new LinkedList<>();
        try {
            String[] text = fileManager.read("swimmers.txt").split("\n");
            for (int i = 0; i < text.length; i++) {
                String[] data = text[i].split(";");
                Models.Swimmer swimmer = new Swimmer();
                swimmer.setCode(data[0]);
                swimmer.setName(data[1]);
                swimmer.setLastName(data[2]);
                swimmer.setGanadas(Integer.parseInt(data[3]));
                swimmer.setPerdidas(Integer.parseInt(data[4]));
                s.add(swimmer);
            }
        } catch (Exception e) {
        }
        return s;
    }

    public void update() {
        String[] text = fileManager.read("swimmers.txt").split("\n");
        String finalText = "";
        for (int i = 0; i < text.length; i++) {
            String[] data = text[i].split(";");
            if (!data[0].equals(this.getCode())) {
                finalText += text[i];
            } else {
                finalText += this.getCode() + ";" + this.getName() + ";" + this.getLastName() + ";"
                + this.getGanadas() + ";" + this.getPerdidas();
            }
            if (i != (text.length - 1)) {
                finalText += "\n";
            }
        }
        fileManager.write("swimmers.txt", finalText);
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getLastName();
    }

}
