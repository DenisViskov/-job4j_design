package map;

import java.util.*;

/**
 * Class has realize HashMap
 *
 * @author Денис Висков
 * @version 1.0
 * @since 18.02.2020
 */
public class HashMap<K, V> implements Iterable<V> {
    /**
     * Table
     */
    private Entry[] table;

    /**
     * Size
     */
    private int size;

    /**
     * Load factor
     */
    private final double loadFactor = 0.75;

    public HashMap() {
        this.table = new Entry[16];
        this.size = 0;
    }

    /**
     * Method has realize add element in table which includes key and value
     *
     * @param key   - key
     * @param value - value
     * @return - true or false in dependency of result
     */
    public boolean insert(K key, V value) {
        boolean result = true;
        boolean isChangedCapacity = changeTable();
        int index = this.indexFor(key.hashCode());
        if (this.table[index] == null) {
            this.table[index] = new Entry(key, value);
            this.size++;
        } else if (isChangedCapacity) {
            this.table[index] = new Entry(key, value);
            this.size++;
        } else {
            result = this.table[index].key.hashCode() == key.hashCode()
                    ? this.table[index].key.equals(key) : false;
            if (result) {
                this.table[index].value = value;
                this.size++;
            }
        }
        return result;
    }

    /**
     * Method has realize get of element on the given key in parameters
     *
     * @param key - key
     * @return - V
     */
    public V get(K key) {
        int index = this.indexFor(key.hashCode());
        if (this.table[index] == null) {
            throw new NoSuchElementException();
        }
        return (V) this.table[index].value;
    }

    /**
     * Method has realize delete element in table on the given key
     *
     * @param key - key
     * @return - true or false in dependency of result
     */
    public boolean delete(K key) {
        int index = this.indexFor(key.hashCode());
        if (this.table[index] == null) {
            return false;
        }
        this.table[index] = null;
        return true;
    }

    /**
     * Method has realizes making of index in table for new element
     *
     * @param hash - hashcode
     * @return - index
     */
    private int indexFor(int hash) {
        return hash & (this.table.length - 1);
    }

    /**
     * Method has realizes change for table by twice capacity
     */
    private boolean changeTable() {
        boolean changeCapacity = ((double) this.size / (double) this.table.length) > loadFactor;
        if (changeCapacity) {
            int capacity = this.table.length;
            List<Entry<K, V>> nonNull = new ArrayList<>();
            for (Entry<K, V> element : this.table) {
                Optional.ofNullable(element).ifPresent(i -> nonNull.add(i));
            }
            this.table = new Entry[capacity * 2];
            for (Entry<K, V> res : nonNull) {
                insert(res.key, res.value);
            }
        }
        return changeCapacity;
    }

    @Override
    public Iterator iterator() {
        return new Iterator<V>() {
            /**
             * Position in table
             */
            private int position = 0;

            /**
             * Entry
             */
            private Optional<Entry> entry;

            @Override
            public boolean hasNext() {
                int index = position;
                boolean flag = false;
                while (index < table.length) {
                    if (table[index] != null) {
                        flag = true;
                        break;
                    }
                    index++;
                }
                return flag;
            }

            @Override
            public V next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                entry = Optional.ofNullable(table[position++]);
                while (!entry.isPresent()) {
                    entry = Optional.ofNullable(table[position++]);
                }
                return (V) entry.get().value;
            }
        };
    }

    /**
     * Class has realizes model of data Entry object who's accumulates itself two parameters K and V
     *
     * @param <K> - key
     * @param <V> - value
     */
    private static class Entry<K, V> {
        /**
         * Key
         */
        private K key;

        /**
         * Value
         */
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }
}
