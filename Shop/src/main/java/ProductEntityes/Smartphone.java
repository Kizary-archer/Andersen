package ProductEntityes;

public class Smartphone extends Product{
    private Integer diagonal;
    private String type = "Смартфон";

    public Integer getDiagonal() {
        return diagonal;
    }

    public void setDiagonal(Integer diagonal) {
        this.diagonal = diagonal;
    }

    @Override
    public String getType() {
        return this.type;
    }
}
