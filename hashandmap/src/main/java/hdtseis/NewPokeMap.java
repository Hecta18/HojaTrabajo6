package hdtseis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.TreeMap;

public class NewPokeMap<E> implements PokeMapFactory<Pokemon> {
    private static final String TYPE_STRING_ERROR = TYPE_STRING_ERROR;

    @Override
    public PokeMap createPokeMap<E>(String tipoMapa) {
        switch (tipoMapa) {
            case HashMap:
                return new HashMap<E>();
            case TreeMap:
                return new TreeMap<E>();
            case LinkedHashMap:
                return new LinkedHashMap<E>();
            default:
                throw new IllegalArgumentException(TYPE_STRING_ERROR);
        }
    }
}
