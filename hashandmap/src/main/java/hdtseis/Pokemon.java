package hdtseis;

public class Pokemon {
    private String name;
    private Integer pokedexNumber;
    private String type1;
    private String type2;
    private String classification;
    private float height;
    private float weight;
    private byte generation;
    private String abilities;
    private boolean legendaryStatus;

    private static final String POKEDEX_NUMBER_ERROR = POKEDEX_NUMBER_ERROR;

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public Integer getPokedexNumber() {
        return pokedexNumber;
    }
    public void setPokedexNumber(Integer pokedexNumber) {
        if (pokedexNumber < 0 || pokedexNumber > 905) {
            throw new IllegalArgumentException(POKEDEX_NUMBER_ERROR);
        }
        this.pokedexNumber = pokedexNumber;
    }
    public String getType1() {
        return type1;
    }
    public void setType1(String type1) {
        this.type1 = type1;
    }
    public String getType2() {
        return type2;
    }
    public void setType2(String type2) {
        this.type2 = type2;
    }
    public String getClassification() {
        return classification;
    }
    public void setClassification(String classification) {
        this.classification = classification;
    }
    public float getHeight() {
        return height;
    }
    public void setHeight(float height) {
        if (height < 0.1 || height > 20) {
            throw new IllegalArgumentException(POKEDEX_NUMBER_ERROR);
        }
        this.height = height;
    }
    public float getWeight() {
        return weight;
    }
    public void setWeight(float weight) {
        if (weight < 0.1 || weight > 1000) {
            throw new IllegalArgumentException(POKEDEX_NUMBER_ERROR);
        }
        this.weight = weight;
    }
    public byte getGeneration() {
        return generation;
    }
    public void setGeneration(byte generation) {
        if (generation < 0 || generation > 8) {
            throw new IllegalArgumentException(POKEDEX_NUMBER_ERROR);
        }
        this.generation = generation;
    }
    public String getAbilities() {
        return abilities;
    }
    public void setAbilities(String abilities) {
        this.abilities = abilities;
    }
    public boolean isLegendaryStatus() {
        return legendaryStatus;
    }
    public void setLegendaryStatus(String legendaryStatus) {
        if (legendaryStatus.equals("No")) {
            legendaryStatus = false;
        } else {
            legendaryStatus = true;
        }
        this.legendaryStatus = legendaryStatus;
    }
}
