package ss.week4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapUtil {

    /**
     * checks whatever Map<K,V> f passed as a parameter is an injection
     * @param map - map f
     * @param <K> - key set of map f
     * @param <V> - value set of map f
     * @return true if for all v in the value set of the map f, there exists exactly one key k in the map’s key set, such that v == f.get(k)
     */
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
        HashSet<V> valueSet = new HashSet<>(map.values());
        return (valueSet.size() == map.keySet().size());
    }

    /**
     * checks whether parameter map f is surjective
     * @param map - map f
     * @param range - range of elements
     * @param <K> - key set of map f
     * @param <V> - value set of map f
     * @return true if for all elements in range there is a key such that f maps to this element
     */
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        for (int i = 0; i < range.size(); i++) {
            if (!map.containsValue(range.toArray()[i])) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param map - map f
     * @param <K> - key set of map f
     * @param <V> - value set of map f
     * @return a map of type Map<V, Set<K>>
     */
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
        Map<V, Set<K>> inverse = new HashMap<>();
        //K[] keys = map.keySet().toArray();
        for (K key : map.keySet()) {
            List<K>Values = new ArrayList<K>();
            if (inverse.containsKey(map.get(key))) {
                Values = new ArrayList<K>(inverse.get(map.get(key)));
            }
            Values.add((K) key);
            inverse.put(map.get(key), new HashSet<K>(Values));
        }
        return inverse;
    }

    /**
     *
     * @param map - map f
     * @param <K> - key set of map f
     * @param <V> - value set of map f
     * @return returns a map of type Map<V, K> if the function is injective and surjective
     */
    public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        if(isOneOnOne(map)){
            Map<V, K> inverse = new HashMap<V, K>();
            for (K k : map.keySet()) {
                inverse.put(map.get(k), k);
            }
            return inverse;
        }
        return null;


    }
	
    public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-4.13
        return false;
    }
	
    public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-4.13
        return null;
    }
	
}
