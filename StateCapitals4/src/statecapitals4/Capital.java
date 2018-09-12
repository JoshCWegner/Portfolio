/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package statecapitals4;

/**
 *
 * @author softwareguild
 */
public class Capital {

    private String stateName;
    private int stateCapitalPopulation;
    private double stateCapitalSqaureMilage;

    public Capital(String stateName, int stateCapitalPopulation, double stateCapitalSquareMilage) {
        this.stateName = stateName;
        this.stateCapitalPopulation = stateCapitalPopulation;
        this.stateCapitalSqaureMilage = stateCapitalSquareMilage;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    public int getStateCapitalPopulation() {
        return stateCapitalPopulation;
    }

    public void setStateCapitalPopulation(int stateCapitalPopulation) {
        this.stateCapitalPopulation = stateCapitalPopulation;
    }

    public double getStateCapitalSqaureMilage() {
        return stateCapitalSqaureMilage;
    }

    public void setStateCapitalSqaureMilage(double stateCapitalSqaureMilage) {
        this.stateCapitalSqaureMilage = stateCapitalSqaureMilage;
    }

}
