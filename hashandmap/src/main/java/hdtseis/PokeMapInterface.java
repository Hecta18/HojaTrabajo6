package hdtseis;

public interface PokeMapInterface<E> {
    void agregarPokemon(E pokemon);
    E buscarPokemon(E pokemon);
    String[] listarPokemones();
}
