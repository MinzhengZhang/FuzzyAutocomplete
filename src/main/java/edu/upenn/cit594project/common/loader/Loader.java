package edu.upenn.cit594project.common.loader;

import edu.upenn.cit594project.repo.LinkRepo;
import edu.upenn.cit594project.repo.index.LevenshteinIndex;
import edu.upenn.cit594project.repo.index.PhoneticIndex;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Scanner;

@Component
public class Loader implements ILoader {
    final LevenshteinIndex li;

    final PhoneticIndex pi;

    final LinkRepo lr;

    /**
     * Constructor for Loader
     *
     * @param li LevenshteinIndex instance
     * @param pi PhoneticIndex instance
     * @param lr LinkRepo instance
     */
    public Loader(LevenshteinIndex li, PhoneticIndex pi, LinkRepo lr) {
        this.li = li;
        this.pi = pi;
        this.lr = lr;
    }

    /**
     * load dictionary into memory
     *
     * @param uri the URI of the data to be loaded
     * @return the num of lines read
     */
    @Override
    public int load(String uri) {
        try (Scanner scanner = new Scanner(
                Objects.requireNonNull(Loader.class.getClassLoader().getResourceAsStream(uri))
        )) {
            String key = scanner.next();
            String link = scanner.next();
            li.setRoot(key);
            pi.add(key);
            lr.setLink(key, link);
            while (scanner.hasNext()) {
                key = scanner.next();
                link = scanner.next();
                li.add(key);
                pi.add(key);
                lr.setLink(key, link);
            }
        }
        return 0;
    }
}
