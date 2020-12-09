import consumer.Consumer;
import contract.Contract;
import distribuitor.Distributor;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public static long calcMonthlyPayment(Distributor distributor) {
        return Math.round(Math.floor(distributor.getInitialInfrastructureCost() / distributor.getContracts().size()) + distributor.getInitialProductionCost() + distributor.getProfit());
    }

    public static long calcDelayedPayment(Consumer consumer) {
        return Math.round(Math.floor(1.2*calcMonthlyPayment(consumer.getCurrentDistributor()))) + calcMonthlyPayment(consumer.getCurrentDistributor());
    }

    public static void uploadNewConsumers(List<Consumer> newConsumers, List<Distributor> distributorList) {
        for (Consumer newConsumer : newConsumers) {
            newConsumer.getBestContract(newConsumer, distributorList);
        }
    }

    public static void setInitialDistributor(List<Consumer> consumerList, List<Distributor> distributorList) {
        long minContractPrice = Integer.MAX_VALUE;
        Distributor bestPriceDistributor = new Distributor();
        for (Distributor distributor : distributorList) {
            if (distributor.calcInitialContractPrice(distributor) < minContractPrice) {
                bestPriceDistributor = distributor;
            }
        }
        bestPriceDistributor.setContracts(new ArrayList<>());
        for (Consumer consumer : consumerList) {
            consumer.setContract(new Contract());
            consumer.setCurrentDistributor(bestPriceDistributor);
            consumer.getContract().setConsumerID(consumer.getId());
            consumer.getContract().setDistributorID(bestPriceDistributor.getId());
            consumer.getContract().setLength(bestPriceDistributor.getContractLength());
            consumer.getContract().setMonthlyPaymentPrice(bestPriceDistributor.calcInitialContractPrice(bestPriceDistributor));
            bestPriceDistributor.getContracts().add(consumer.getContract());
        }
    }

}
