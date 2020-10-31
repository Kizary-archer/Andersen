package ProductEntityes;

public class Microphone extends Product{
    private String connector;
    private String type = "Микрофон";

    public String getConnector() {
        return connector;
    }

    public void setConnector(String connector) {
        this.connector = connector;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
