package hdtseis;

public interface PokeMapFactoryInterface<E> {
    public PokeMap createPokeMap()<E>;
}

//Definicion Factory segun Copilot
// The Factory Design Pattern is a creational pattern 
// that provides an interface for creating objects in 
// a superclass, but allows subclasses to alter the type 
// of objects that will be created. It is used to *encapsulate 
// the instantiation logic* and can help in managing 
// and maintaining the creation process.