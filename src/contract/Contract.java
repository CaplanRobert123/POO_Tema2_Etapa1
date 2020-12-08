package contract;

public class Contract {
    private int consumerID;
    private int distributorID;
    private long monthlyPaymentPrice;
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getConsumerID() {
        return consumerID;
    }

    public void setConsumerID(int consumerID) {
        this.consumerID = consumerID;
    }

    public int getDistributorID() {
        return distributorID;
    }

    public void setDistributorID(int distributorID) {
        this.distributorID = distributorID;
    }

    public long getMonthlyPaymentPrice() {
        return monthlyPaymentPrice;
    }

    public void setMonthlyPaymentPrice(long monthlyPaymentPrice) {
        this.monthlyPaymentPrice = monthlyPaymentPrice;
    }

    @Override
    public String toString() {
        return "Contract{" +
                "consumerID=" + consumerID +
                ", distributorID=" + distributorID +
                ", monthlyPaymentPrice=" + monthlyPaymentPrice +
                '}';
    }


}
