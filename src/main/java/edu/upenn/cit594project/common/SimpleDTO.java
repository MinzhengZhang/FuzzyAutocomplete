package edu.upenn.cit594project.common;

/**
 * Thin wrapper around a single Java object to be transferred
 * Needed to ensure the response body contains a JSON object
 * rather an array or a primitive-type value
 *
 * @param <D> Type of the underlying data
 */
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
