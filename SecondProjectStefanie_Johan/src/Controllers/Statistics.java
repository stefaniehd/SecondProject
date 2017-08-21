/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controllers;

/**
 *
 * @author Stefanie
 */
public class Statistics {

    private Models.Statistics statistics;

    public Statistics() {
        statistics = new Models.Statistics();
    }

    public Statistics(Models.Statistics statistics) {
        this.statistics = statistics;
    }

    /**
     * Brings a report with the statistics of the game
     * @return the report
     */
    public String report() {
        return this.statistics.generateReport();
    }

    /**
     * cleans the statistics saved
     */
    public void clean() {
        this.statistics.clean();
    }

    /**
     * loads the statistics
     * @return 
     */
    public Models.Statistics load() {
        return this.statistics.load();
    }

    /**
     * update the statistics
     */
    public void update() {
        this.statistics.update();
    }
}
