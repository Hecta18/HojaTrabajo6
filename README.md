# HojaTrabajo6
Actividad de la clase "Algoritmos y estructuras de datos"

## Preparación con ayuda de IA
Este programa requiere una implementación modular y bien estructurada en Java. Aquí te sugiero un plan de acción:  

### Procedimiento recomendado:
1. **Lectura del archivo CSV:**  
   - Usa `BufferedReader` para leer el archivo línea por línea.  
   - Divide cada línea usando `split(",")` para extraer los valores.  
   - Crea una clase `Pokemon` con los atributos del dataset.  

2. **Implementación del patrón Factory:**  
   - Crea una interfaz `PokemonMapFactory` con un método `createMap()`.  
   - Implementa tres clases (`HashMapFactory`, `TreeMapFactory`, `LinkedHashMapFactory`) que devuelvan sus respectivas implementaciones.  
   - En el programa principal, permite al usuario seleccionar qué `Map` utilizar.  

3. **Operaciones sobre la colección del usuario:**  
   - Usa una colección adecuada para almacenar los Pokémon seleccionados por el usuario.  
   - Para evitar duplicados, puedes usar un `Set` o validar la existencia antes de agregar un nuevo Pokémon.  
   - Para ordenar por `Type1`, usa `Comparator` en una lista de Pokémon.  

4. **Implementación de funciones requeridas:**  
   - Métodos para agregar, buscar y listar Pokémon.  
   - Uso de `Collections.sort()` para ordenar por `Type1`.  

5. **Pruebas unitarias:**  
   - Prueba la correcta adición de Pokémon.  
   - Prueba la búsqueda de Pokémon por habilidad.  

6. **Complejidad de operación #4:**  
   - Si usas `TreeMap`, la ordenación se mantiene `O(log N)`.  
   - Si usas `HashMap`, debes ordenar manualmente, lo cual es `O(N log N)`.
  
### Conceptos:
#### **`Set` en Java**
Un `Set` es una colección en Java que **no permite elementos duplicados**. Es útil para garantizar que la colección del usuario no tenga Pokémon repetidos. Algunas implementaciones comunes de `Set` incluyen:

- **`HashSet<E>`** → Implementado con una tabla hash (sin orden). Tiempo de búsqueda promedio `O(1)`.  
- **`TreeSet<E>`** → Basado en un árbol rojo-negro (ordenado automáticamente). Tiempo de búsqueda `O(log N)`.  
- **`LinkedHashSet<E>`** → Mantiene el orden de inserción. Tiempo de búsqueda `O(1)`.  

**Ejemplo de uso:**
```java
Set<String> pokemonSet = new HashSet<>();
pokemonSet.add("Pikachu");
pokemonSet.add("Charizard");
pokemonSet.add("Pikachu"); // No se agrega, ya que Pikachu ya existe en el set

System.out.println(pokemonSet); // [Pikachu, Charizard]
```



#### **`Comparator` en Java**
Un `Comparator<T>` es una interfaz en Java que permite definir **criterios de comparación personalizados** para ordenar objetos.

En tu caso, necesitas ordenar Pokémon por su atributo `Type1`. Como `Map` no mantiene un orden definido (excepto `TreeMap`), puedes convertir los valores en una `List<Pokemon>` y ordenarlos con `Collections.sort()` usando un `Comparator`.

**Ejemplo de un `Comparator` para ordenar por `Type1`:**
```java
import java.util.*;

class Pokemon {
    String name;
    String type1;

    public Pokemon(String name, String type1) {
        this.name = name;
        this.type1 = type1;
    }

    @Override
    public String toString() {
        return name + " - " + type1;
    }
}

// Comparator que ordena por Type1
class PokemonTypeComparator implements Comparator<Pokemon> {
    @Override
    public int compare(Pokemon p1, Pokemon p2) {
        return p1.type1.compareTo(p2.type1); // Orden alfabético
    }
}

public class Main {
    public static void main(String[] args) {
        List<Pokemon> pokemons = new ArrayList<>();
        pokemons.add(new Pokemon("Pikachu", "Electric"));
        pokemons.add(new Pokemon("Charizard", "Fire"));
        pokemons.add(new Pokemon("Bulbasaur", "Grass"));

        Collections.sort(pokemons, new PokemonTypeComparator());

        System.out.println(pokemons); 
        // Salida: [Charizard - Fire, Pikachu - Electric, Bulbasaur - Grass]
    }
}
```

#### **Complejidad de `Set` (HashSet, TreeSet, LinkedHashSet)**

| Implementación | Inserción | Búsqueda | Eliminación | Ordenamiento |
|--------------|------------|------------|------------|-------------|
| `HashSet`       | **O(1)** (promedio), O(N) (peor caso) | **O(1)** (promedio), O(N) (peor caso) | **O(1)** (promedio), O(N) (peor caso) | **No mantiene orden** |
| `TreeSet`       | **O(log N)** | **O(log N)** | **O(log N)** | **Ordenado automáticamente** |
| `LinkedHashSet` | **O(1)** | **O(1)** | **O(1)** | **Mantiene orden de inserción** |

---

#### **Complejidad de `Comparator` y `Collections.sort()`**
El método `Collections.sort(List<T>, Comparator<T>)` usa **MergeSort** internamente, que tiene una complejidad de:
- **O(N log N)** en todos los casos.

Esto se debe a que:
1. Se divide la lista en partes más pequeñas (O(log N) pasos).
2. Se compara y fusiona (O(N) por cada paso).

Si la colección ya está ordenada, usando `TreeMap`, no es necesario `sort()`, ya que `TreeMap` mantiene los elementos ordenados con **O(log N)** por cada inserción.

---

#### **Complejidad de `Map` (HashMap, TreeMap, LinkedHashMap)**

| Implementación | Inserción | Búsqueda | Eliminación | Ordenamiento |
|--------------|------------|------------|------------|-------------|
| `HashMap`       | **O(1)** (promedio), O(N) (peor caso con colisiones) | **O(1)** (promedio), O(N) (peor caso) | **O(1)** (promedio) | **No mantiene orden** |
| `TreeMap`       | **O(log N)** | **O(log N)** | **O(log N)** | **Ordenado por clave** |
| `LinkedHashMap` | **O(1)** | **O(1)** | **O(1)** | **Mantiene orden de inserción** |

Si eliges `TreeMap`, la búsqueda y almacenamiento de Pokémon se mantienen ordenados con **O(log N)**, lo que lo hace más eficiente para la operación #4.

---

#### **Complejidad de la Operación #4: Mostrar todos los Pokémon ordenados por `Type1`**
En esta operación, queremos **ordenar todos los Pokémon leídos desde el archivo por `Type1`**.

**Caso 1: Usando `TreeMap`**
Si usas `TreeMap<String, Pokemon>` con `Type1` como clave:
- La inserción de cada Pokémon es **O(log N)**.
- Recuperar todos los Pokémon ordenados por `Type1` es **O(N)** (porque solo iteramos sobre el `TreeMap`).

🔹 **Complejidad total: O(N log N)** (por las inserciones).

---

**Caso 2: Usando `HashMap` + `sort()`**
Si usas `HashMap<String, Pokemon>` y luego conviertes a `List` para ordenarlo manualmente con `Collections.sort()`:
1. La inserción en `HashMap` es **O(1)** por Pokémon → **O(N)** en total.
2. Convertir `Map.values()` a `List` es **O(N)**.
3. Ordenar con `Collections.sort()` es **O(N log N)**.

🔹 **Complejidad total: O(N log N)** (por el ordenamiento con `sort()`).

Ambos enfoques tienen la **misma complejidad asintótica**, pero `TreeMap` es más eficiente si necesitas acceder frecuentemente a los datos ordenados.

## Referencias:
Java Platform, Standard Edition Documentation - Releases. (2024, 16 septiembre). Oracle Help Center. https://docs.oracle.com/en/java/javase/

ChatGPT. (2025). Respuesta generada por un modelo de inteligencia artificial de OpenAI sobre Java Collection Framework y complejidad algorítmica. OpenAI.
