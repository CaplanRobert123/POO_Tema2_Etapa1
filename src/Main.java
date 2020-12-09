import com.fasterxml.jackson.databind.ObjectMapper;
import consumer.Consumer;
import distribuitor.Distributor;
import input.Input;

import java.io.File;
import java.util.List;

public class Main {

    public static void main(String[] args) throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();
        Input input = objectMapper.readValue(new File("C:/Users/capla/Desktop/proiect-etapa1/checker/resources/in/basic_2.json"), Input.class);
        List<Consumer> consumerList = input.getInitialData().getConsumers();
        List<Distributor> distributorList = input.getInitialData().getDistributors();
        int numberOfTurns = input.getNumberOfTurns();

        Utils.setInitialDistributor(consumerList, distributorList);
        for (int i = 0; i < numberOfTurns; i++) {
            Distributor.updateDistributorList(distributorList, input.getMonthlyUpdates().get(i).getCostsChanges());
            Utils.uploadNewConsumers(input.getMonthlyUpdates().get(i).getNewConsumers(), distributorList);
            for (Consumer consumer : consumerList) {
                consumer.doUpdate(consumer, distributorList);
            }
//            consumerList.addAll(input.getMonthlyUpdates().get(i).getNewConsumers());
            for (Distributor distributor : distributorList) {
                distributor.calcContractPrice(distributor);
            }
            System.out.println(distributorList);
        }
    }
}
