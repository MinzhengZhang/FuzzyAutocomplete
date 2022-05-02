package edu.upenn.cit594project.common;

public class SimpleDTO<D> {
    private D data;

    public SimpleDTO() {
    }

    public SimpleDTO(D data) {
        this.data = data;
    }

    public D getData() {
        return data;
    }

    public void setData(D data) {
        this.data = data;
    }
}
