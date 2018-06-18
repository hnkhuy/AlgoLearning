package WeightedRandom;

public class Message {
    private String messageContent;
    private int weighth;

    public Message(String messageContent, int weighth) {
        this.messageContent = messageContent;
        this.weighth = weighth;
    }

    public String getMessageContent() {
        return messageContent;
    }

    public int getWeighth() {
        return weighth;
    }
}
