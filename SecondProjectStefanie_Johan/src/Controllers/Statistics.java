/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author Magdalena
 */
public class Statistics {
    private Models.Statistics statistics;

    public Statistics() {
        statistics = new Models.Statistics();
    }

    public Statistics(Models.Statistics statistics) {
        this.statistics = statistics;
    }
    
    public String report(){
        return this.statistics.generateReport();
    }
    
    public void clean(){
        this.statistics.clean();
    }
}
