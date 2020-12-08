package data;

import consumer.Consumer;

import java.util.List;

public class MonthlyUpdate {
    private List<Consumer> newConsumers;
    private List<CostsChanges> costsChanges;

    public List<Consumer> getNewConsumers() {
        return newConsumers;
    }

    public void setNewConsumers(List<Consumer> newConsumers) {
        this.newConsumers = newConsumers;
    }

    public List<CostsChanges> getCostsChanges() {
        return costsChanges;
    }

    public void setCostsChanges(List<CostsChanges> costsChanges) {
        this.costsChanges = costsChanges;
    }

    @Override
    public String toString() {
        return "MonthlyUpdate{" +
                "newConsumers=" + newConsumers +
                ", costsChanges=" + costsChanges +
                '}';
    }


}
