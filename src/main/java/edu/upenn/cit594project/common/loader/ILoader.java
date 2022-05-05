package edu.upenn.cit594project.common.loader;

/**
 * General interface for loading data into memory
 */
public interface ILoader {
    /**
     * load dictionary into memory
     * @param uri the URI of the data to be loaded
     * @return the num of lines readgit
     */
    int load(String uri);
}
