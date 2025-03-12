package hdtseis;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class PokeMap<E> implements PokeMapInterface<E> {
    private static final String TYPE_STRING_ERROR = "Invalid map type provided.";
    private Map<E, E> map;

    public void setMap(Map<E, E> map) {
        this.map = map;
    }
   
    public void setMapType(String mapType) {
        switch (mapType) {
            case "HashMap":
                map = new HashMap<>();
                setMap(map);
                break;
            case "TreeMap":
                map = new TreeMap<>();
                setMap(map);
                break;
            case "LinkedHashMap":
                map = new LinkedHashMap<>();
                setMap(map);
                break;
            default:
                throw new IllegalArgumentException(TYPE_STRING_ERROR);
        }
    }

    @Override
    public void agregarPokemon(E pokemon) {
        map.put(pokemon, pokemon);
    }

    @Override
    public E buscarPokemon(E pokemon) {
        return map.get(pokemon);
    }

    @Override
    public String[] listarPokemones() {
        return map.keySet().toArray(new String[0]);
    }
    
}
