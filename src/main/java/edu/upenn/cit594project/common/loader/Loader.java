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
            scanner.nextLong();
            String key = scanner.next();
            li.setRoot(key);
            pi.add(key);
            while (scanner.hasNext()) {
                scanner.nextLong();
                key = scanner.next();
                li.add(key);
                pi.add(key);
            }
        }
        return 0;
    }
}
