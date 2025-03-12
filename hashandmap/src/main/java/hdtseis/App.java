package hdtseis;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
public class App 
{
    public static void main( String[] args )
    {
        try {
            BufferedReader brcsv = new BufferedReader(new FileReader("/home/hek_distro/uvg_repos/HojaTrabajo6/pokemones.csv"));
            List<String> pokemones = brcsv.lines().collect(Collectors.toList());
            brcsv.close();
            for (String pokemon : pokemones) {
                String[] unPokemon = pokemon.split(",");
                for (String atributo : unPokemon) {
                    Pokemon poke = new Pokemon(unPokemon[0], unPokemon[1], unPokemon[2], unPokemon[8]);
                }
            }

            BufferedReader brinput = new BufferedReader(new InputStreamReader(System.in));
            System.out.println("Ingrese el tipo de mapa que desea utilizar: ");
            String tipoMapa = brinput.readLine();
            brinput.close();

            PokeMapFactory<Pokemon> pokeMapFactory = new PokeMapFactory<>();
            PokeMap<Pokemon> pokeMap = pokeMapFactory.createPokeMap();
            pokeMap.setMapType(tipoMapa);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
