// Yogesh Thambidurai APCS 2022-23
package com.gyoge.apcs;

import java.util.LinkedList;
import java.util.Set;

@SuppressWarnings("unused")
public class HashMap<K, V> {
    private static final int MAX_ARRAY_SIZE = 5;
    private static final int DEFAULT_BUCKETS = 32;
    private LinkedList<Entry<K, V>>[] buckets;
    private int numArrayResized;
    private long lastTimeToResize;
    private long totalTimeToResize;

    public HashMap(int size) {
        //noinspection unchecked
        this.buckets = ((LinkedList<Entry<K, V>>[]) new LinkedList[size]);
    }

    public HashMap() {
        this(DEFAULT_BUCKETS);
    }

    public static void testGet(HashMap<String, String> hashMap, String str) {
        System.out.print("testGet: key=" + str + ", found: ");
        String value = hashMap.get(str);
        if (value == null) System.out.println("false");
        else System.out.println("true (" + value + ")");
    }

    public static void main(String[] args) {
        HashMap<String, String> myDictionary = new HashMap<>(5);
        System.out.println(myDictionary);
        myDictionary.put("dog", "dog");
        myDictionary.put("cat", "cat");
        myDictionary.put("hog", "hog");
        myDictionary.put("frog", "frog");
        myDictionary.put("bee", "bee");
        myDictionary.put("abc", "abc");
        myDictionary.put("flea", "flea");
        System.out.println(myDictionary);

        System.out.println("\nTesting get(key)");

        testGet(myDictionary, "dog");
        testGet(myDictionary, "cat");
        testGet(myDictionary, "hog");
        testGet(myDictionary, "frog");
        testGet(myDictionary, "bee");
        testGet(myDictionary, "abc");
        testGet(myDictionary, "flea");
        testGet(myDictionary, "notInThere");
        testGet(myDictionary, "a key can contain spaces...");

        System.out.println("\nTesting keySet");
        Set<String> mySet = myDictionary.keySet();
        System.out.println("keys: " + mySet + ", size=" + mySet.size());

        System.out.println("\nAdding more gets to verify resizing the static array works");
        int dupCnt = 0;
        for (int k = 0; k < 30; k++) {
            StringBuilder str = new StringBuilder();
            for (int j = 0; j < 3; j++) str.append((char) (Math.random() * 10 + 'a'));

            String result = myDictionary.put(str.toString(), str.toString());
            if (result != null) dupCnt++;

            //noinspection ConstantValue
            if (k + 1 % 20 == 0) {
                System.out.println(myDictionary);
            }
        }
        System.out.println(myDictionary);
        System.out.println("duplicate cnt: " + dupCnt);
        System.out.println("Container cnt: " + myDictionary.size());

        System.out.println(myDictionary.getStats());
    }

    public V get(K key) {
        int bucket = key.hashCode() % buckets.length;
        if (buckets[bucket] == null) {
            return null;
        }
        for (Entry<K, V> entry : buckets[bucket]) {
            if (entry.getKey().equals(key)) {
                return entry.getValue();
            }
        }
        return null;
    }

    public V put(K key, V value) {
        int bucket = Math.abs(key.hashCode()) % buckets.length;
        if (buckets[bucket] == null) {
            buckets[bucket] = new LinkedList<>();
        }
        for (Entry<K, V> entry : buckets[bucket]) {
            if (entry.getKey().equals(key)) {
                V oldValue = entry.getValue();
                entry.value = value;
                return oldValue;
            }
        }
        if (buckets[bucket].size() > MAX_ARRAY_SIZE) {
            resizeHashArray();
        }
        buckets[bucket].add(new Entry<>(key, value));
        return null;
    }

    public Set<K> keySet() {
        Set<K> keys = new java.util.HashSet<>();
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    keys.add(entry.getKey());
                }
            }
        }
        return keys;
    }

    public int size() {
        int size = 0;
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                size += bucket.size();
            }
        }
        return size;
    }

    public void resizeHashArray() {
        long startTime = System.nanoTime();

        LinkedList<Entry<K, V>>[] oldBuckets = buckets;
        //noinspection unchecked
        buckets = ((LinkedList<Entry<K, V>>[]) new LinkedList[buckets.length * 2]);
        for (LinkedList<Entry<K, V>> bucket : oldBuckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    int newBucket = entry.getKey().hashCode() % buckets.length;
                    if (buckets[newBucket] == null) {
                        buckets[newBucket] = new LinkedList<>();
                    }
                    buckets[newBucket].add(entry);
                }
            }
        }

        numArrayResized++;
        long endTime = System.nanoTime();
        lastTimeToResize = endTime - startTime;
        totalTimeToResize += lastTimeToResize;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket != null) {
                for (Entry<K, V> entry : bucket) {
                    sb.append(entry.getKey()).append("=").append(entry.getValue()).append(", ");
                }
            }
        }
        if (sb.lastIndexOf(",") != -1) {
            sb.delete(sb.lastIndexOf(","), sb.length());
        }
        sb.append("}");
        return sb.toString();
    }

    public String getStats() {
        String str = "number of times static array was resized: " + numArrayResized + "\n";
        str +=
                String.format(
                        "last time it took to resize array: %.2f usecs\n",
                        lastTimeToResize / 1000.0);
        str +=
                String.format(
                        "total time it took to resize array: %.2f usecs\n",
                        totalTimeToResize / 1000.0);
        str +=
                String.format(
                        "static array size: %d,  number of elements: %d\n", buckets.length, size());

        int max = 0;
        int cntNulls = 0;
        double avg = 0;

        for (LinkedList<Entry<K, V>> bucket : buckets) {
            if (bucket == null) {
                cntNulls++;
            } else {
                avg += bucket.size();
                if (bucket.size() > max) {
                    max = bucket.size();
                }
            }
        }
        avg /= buckets.length - cntNulls;

        str += String.format("max ArrayList size: %d,  average AL size: %.2f\n", max, avg);
        str +=
                String.format(
                        "AL size threshold: %d,  num null entries: %d\n", MAX_ARRAY_SIZE, cntNulls);
        return str;
    }

    public static class Entry<K, V> {
        private final K key;
        private V value;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public void setValue(V value) {
            this.value = value;
        }
    }
}
