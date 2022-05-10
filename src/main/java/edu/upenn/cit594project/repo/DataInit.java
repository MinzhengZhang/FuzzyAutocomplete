package edu.upenn.cit594project.repo;

import edu.upenn.cit594project.common.loader.Loader;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class DataInit implements ApplicationListener<ApplicationReadyEvent> {
    final Loader loader;

    public DataInit(Loader loader) {
        this.loader = loader;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        loader.load("./static/pokemonDict.txt");
    }
}
