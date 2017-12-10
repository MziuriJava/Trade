package ge.mziuri.TSP.model.exception;

public class TSPException extends Exception{

    private String messageKey;

    private Exception ex;

    public TSPException(String messageKey) {
        this.messageKey = messageKey;
    }

    public TSPException(String messageKey, Exception ex) {
        super(ex);
        this.messageKey = messageKey;
    }

    public String getMessageKey() {
        return messageKey;
    }

}
