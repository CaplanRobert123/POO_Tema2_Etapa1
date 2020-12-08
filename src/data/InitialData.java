package data;

import consumer.Consumer;
import distribuitor.Distributor;

import java.util.List;

public class InitialData {
    private List<Consumer> consumers;
    private List<Distributor> distributors;

    public List<Consumer> getConsumers() {
        return consumers;
    }

    public void setConsumers(List<Consumer> consumers) {
        this.consumers = consumers;
    }

    public List<Distributor> getDistributors() {
        return distributors;
    }

    public void setDistributors(List<Distributor> distribuitors) {
        this.distributors = distribuitors;
    }

    @Override
    public String toString() {
        return "InitialData{" +
                "consumers=" + consumers +
                ", distributors=" + distributors +
                '}';
    }
}
