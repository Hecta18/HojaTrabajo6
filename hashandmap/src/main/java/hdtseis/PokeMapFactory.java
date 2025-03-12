package hdtseis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class PokeMapFactory<E> implements PokeMapFactoryInterface<E> {
    @Override
    public PokeMap createPokeMap() {
        return new PokeMap<E>();
    }
}
