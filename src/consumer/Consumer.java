package consumer;

import contract.Contract;
import distribuitor.Distributor;

import java.util.List;

public class Consumer {
    private int id;
    private int initialBudget;
    private int monthlyIncome;
    private int currentBudget;
    private boolean delayedPayment;
    private Distributor currentDistributor;
    private Contract contract;
    private long monthlyPayment;

    public Contract getContract() {
        return contract;
    }

    public void setContract(Contract contract) {
        this.contract = contract;
    }

    public long getMonthlyPayment() {
        return monthlyPayment;
    }

    public void setMonthlyPayment(long monthlyPayment) {
        this.monthlyPayment = monthlyPayment;
    }

    public Distributor getCurrentDistributor() {
        return currentDistributor;
    }

    public void setCurrentDistributor(Distributor currentDistributor) {
        this.currentDistributor = currentDistributor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInitialBudget() {
        return initialBudget;
    }

    public void setInitialBudget(int initialBudget) {
        this.initialBudget = initialBudget;
    }

    public int getMonthlyIncome() {
        return monthlyIncome;
    }

    public void setMonthlyIncome(int monthlyIncome) {
        this.monthlyIncome = monthlyIncome;
    }

    public int getCurrentBudget() {
        return currentBudget;
    }

    public void setCurrentBudget(int currentBudget) {
        this.currentBudget = currentBudget;
    }

    public boolean isDelayedPayment() {
        return delayedPayment;
    }

    public void setDelayedPayment(boolean delayedPayment) {
        this.delayedPayment = delayedPayment;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", initialBudget=" + initialBudget +
                ", monthlyIncome=" + monthlyIncome +
                '}';
    }

    public boolean hasContract(Consumer consumer) {
        return consumer.getContract() != null;
    }

    public void reduceContractLength(Consumer consumer) {
        if (consumer.hasContract(consumer) && consumer.getContract().getLength() != 0) {
            consumer.getContract().setLength(consumer.getContract().getLength() - 1);
        }
    }

    public int calcCurrentBudget(Consumer consumer) {
        return 0;
    }
    public void delayPayment(Consumer consumer) {
        if (consumer.getCurrentBudget() < consumer.getCurrentDistributor().getInitialInfrastructureCost()) {

        }
    }

    public void doUpdate(Consumer consumer, List<Distributor> distributorList) {
        consumer.reduceContractLength(consumer);
        if (consumer.getContract().getLength() == 0) {
            consumer.setContract(null);
            consumer.getBestContract(consumer, distributorList);
        }
    }

    public void getBestContract(Consumer consumer, List<Distributor> distributorList) {
        long lowestPrice = Integer.MAX_VALUE;
        Distributor cheapestDistributor = new Distributor();
        for (Distributor distributor: distributorList) {
            if (distributor.calcContractPrice(distributor) < lowestPrice) {
                cheapestDistributor = distributor;
            }
        }
        consumer.setContract(new Contract());
        consumer.getContract().setConsumerID(consumer.getId());
        consumer.getContract().setDistributorID(cheapestDistributor.getId());
        consumer.getContract().setMonthlyPaymentPrice(cheapestDistributor
                                                        .calcContractPrice(cheapestDistributor));
        consumer.getContract().setLength(cheapestDistributor.getContractLength());
        cheapestDistributor.getContracts().add(consumer.getContract());
    }
}