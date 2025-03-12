package hdtseis;

import java.io.*;
public class App 
{
    public static void main( String[] args )
    {
        BufferedReader brcsv = new BufferedReader(new FileReader("../../../../../pokemones.csv"));
        String[] pokemones = brcsv.split(",");

        BufferedReader brinput = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Ingrese el tipo de mapa que desea utilizar: ");
        String tipoMapa = brinput.readLine();

        PokeMapFactory pokeMapFactory = new PokeMapFactory();
        PokeMap pokeMap = pokeMapFactory.createPokeMap();
        pokeMap.setMapType(tipoMapa);
    }
}
