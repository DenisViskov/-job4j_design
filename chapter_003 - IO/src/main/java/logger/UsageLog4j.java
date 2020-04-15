package logger;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Class is an example use log4J
 */
public class UsageLog4j {

    /**
     * Logger
     */
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Denis";
        int age = 27;
        double weight = 70.5;
        short iq = 150;
        char sex = 'm';
        byte footSize = 42;
        long money = 10000000L;
        boolean isProgger = true;
        LOG.debug("Name is {}, age: {}, weight : {}, iq: {}, sex: {}, foot size: {}, money : {}, isProgger: {}",
                name, age, weight, iq, sex, footSize, money, isProgger);
    }
}
