package ProductBuilders;

import ProductEntityes.Microphone;

public class MicrophoneBuilder implements Builder {

    Microphone microphone;

    public MicrophoneBuilder(Microphone microphone) {
        this.microphone = microphone;
    }

    @Override
    public void setManufactore(String manufacture) {
        microphone.setManufacture(manufacture);
    }

    @Override
    public void setModel(String model) {
        microphone.setModel(model);
    }

    @Override
    public void setPrise(int prise) {
        microphone.setPrice(prise);
    }

    public void setConnector(String  connector) {
        microphone.setConnector(connector);
    }
    @Override
    public Microphone build() {
        return microphone;
    }

}
