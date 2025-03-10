package hdtseis;

import java.io.*;
public class App 
{
    public static void main( String[] args )
    {
        BufferedReader br = new BufferedReader(new FileReader("../../../../../pokemones.csv"));
        String[] pokemones = br.split(",");
    }
}
