package hdtseis;

public class PokeMapFactory<E> implements PokeMapFactoryInterface<E> {
    @Override
    public PokeMap<E> createPokeMap() {
        return new PokeMap<>();
    }
}
