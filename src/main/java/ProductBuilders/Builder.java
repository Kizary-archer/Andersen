package ProductBuilders;

import ProductEntityes.Product;

public interface Builder {

    public void setManufactore(String manufacture);
    public void setModel(String model);
    public void setPrise(int prise);
    public Product build();
}
