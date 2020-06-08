package ru.job4j.ood.isp.menu;

/**
 * @author Денис Висков
 * @version 1.0
 * @since 08.06.2020
 */
public class Use implements Functional<Structure> {

    /**
     * Structure
     */
    private final Structure structure;

    public Use(Structure structure) {
        this.structure = structure;
    }

    /**
     * Method print structure
     */
    @Override
    public void printStructure() {
        System.out.print(structure);
    }

    /**
     * Method select something by name and execute his method
     *
     * @param name
     */
    @Override
    public void select(String name) {
        Something something = (Something) structure.getItem(name);
        something.doSomething();
    }
}
