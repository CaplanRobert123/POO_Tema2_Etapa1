import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.Consumer;
import distribuitor.Distributor;
import input.Input;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Input input = objectMapper.readValue(new File("C:/Users/capla/Desktop/proiect-etapa1/checker/resources/in/basic_1.json"), Input.class);
        List<Consumer> consumerList = input.getInitialData().getConsumers();
        List<Distributor> distributorList = input.getInitialData().getDistributors();
        int numberOfTurns = input.getNumberOfTurns();

        Utils.setInitialDistributor(consumerList, distributorList);
        for (int i = 0; i < numberOfTurns; i++) {
            Distributor.updateDistributorList(distributorList, input.getMonthlyUpdates().get(i).getCostsChanges());
            for (Consumer consumer : consumerList) {
                consumer.doRound(consumer);
            }
            for (Consumer newConsumer: input.getMonthlyUpdates().get(i).getNewConsumers()) {
                consumerList.add(newConsumer);
                newConsumer.getBestContract(newConsumer, distributorList);
            }
        }
    }
}
