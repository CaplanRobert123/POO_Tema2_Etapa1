package distribuitor;

import contract.Contract;
import data.CostsChanges;

import java.util.List;

public class Distributor {
    private int id;
    private int contractLength;
    private long initialBudget;
    private long initialInfrastructureCost;
    private long initialProductionCost;
    private List<Contract> contracts;
    private long profit;
    private long updatedInfrastructureCost;
    private long updatedProductionCost;

    public long getUpdatedInfrastructureCost() {
        return updatedInfrastructureCost;
    }

    public void setUpdatedInfrastructureCost(long updatedInfrastructureCost) {
        this.updatedInfrastructureCost = updatedInfrastructureCost;
    }

    public long getUpdatedProductionCost() {
        return updatedProductionCost;
    }

    public void setUpdatedProductionCost(long updatedProductionCost) {
        this.updatedProductionCost = updatedProductionCost;
    }

    public int getId() {
        return id;
    }

    public long getProfit() {
        return profit;
    }

    public void setProfit(long profit) {
        this.profit = profit;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getContractLength() {
        return contractLength;
    }

    public void setContractLength(int contractLength) {
        this.contractLength = contractLength;
    }

    public long getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(long initialBudget) {
        this.initialBudget = initialBudget;
    }

    public List<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(List<Contract> contracts) {
        this.contracts = contracts;
    }

    public long getInitialInfrastructureCost() {
        return initialInfrastructureCost;
    }

    public void setInitialInfrastructureCost(long initialInfrastructureCost) {
        this.initialInfrastructureCost = initialInfrastructureCost;
    }

    public long getInitialProductionCost() {
        return initialProductionCost;
    }

    public void setInitialProductionCost(long initialProductionCost) {
        this.initialProductionCost = initialProductionCost;
    }

    @Override
    public String toString() {
        return "Distributor{" +
                "id=" + id +
                ", contractLength=" + contractLength +
                ", initialBudget=" + initialBudget +
                ", initialInfrastructureCost=" + initialInfrastructureCost +
                ", initialProductionCost=" + initialProductionCost +
                ", profit=" + profit +
                ", updatedInfrastructureCost=" + updatedInfrastructureCost +
                ", updatedProductionCost=" + updatedProductionCost +
                '}';
    }

    public void calcProfit(Distributor distributor) {
        setProfit(Math.round(Math.floor(0.2 * initialProductionCost)));
    }

    public long calcInitialContractPrice(Distributor distributor) {
        return initialInfrastructureCost + initialProductionCost + profit;
    }

    public long calcContractPrice(Distributor distributor) {
        return Math.round(Math.floor(updatedInfrastructureCost / contracts.size()) + updatedProductionCost + profit);
    }

/*    public long updatePrices() {

    }*/

    public static void updateDistributorList(List<Distributor> distributorList, List<CostsChanges> costsChangesList) {
        for (CostsChanges costsChanges : costsChangesList) {
            distributorList.get(costsChanges.getId()).setUpdatedProductionCost(costsChanges.getProductionCost());
            distributorList.get(costsChanges.getId()).setUpdatedInfrastructureCost(costsChanges.getInfrastructureCost());
        }
    }
}
