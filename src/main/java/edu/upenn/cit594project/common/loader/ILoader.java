package edu.upenn.cit594project.common.loader;

/**
 * General interface for loading data into memory
 */
public interface ILoader {
    /**
     * load data into memory
     * @param uri the URI of the data to be loaded
     */
    void load(String uri);
}
