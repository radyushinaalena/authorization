import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Config {
    private static final String PERSISTENT_UNIT_NAME = "myPersistenceUnit";

    public static EntityManager getEm() {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(PERSISTENT_UNIT_NAME);
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        return entityManager;
    }
}
