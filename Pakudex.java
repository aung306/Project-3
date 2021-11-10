import java.util.Objects;

public class Pakudex {

    int pakuSize;
    String[] pakudex;
    String[] allPakus;

    boolean evolve = false;

    //Default constructor; if called, the default size for the Pakudex should be 20
    public Pakudex() {
        pakuSize = 20;
        pakudex = new String[pakuSize];
    }

    //Initializes this object to contain exactly capacity objects when completely full
    public Pakudex(int capacity) {
        pakuSize = capacity;
        pakudex = new String[pakuSize];

    }

    //Returns the number of critters currently being stored in the Pakudex
    public int getSize() {

        int finalCount = 0;

        for (int i = 0; i <= pakuSize - 1; i++) {
            if (pakudex[i] != null) {
                finalCount++;
            }
        }
        return finalCount;
    }

    //Returns the number of critters that the Pakudex has the capacity to hold at most
    public int getCapacity() {
        return pakudex.length;
    }

    //Returns a String array containing the species of the critters as ordered in the Pakudex; if there are no species
    //added yet, this method should return null
    public String[] getSpeciesArray() {
        allPakus = new String[getSize()];
        String[] test  = new String[getSize()];
        //This should return null if there are no species of Pakuri
        if (getSize() == 0) {
            return null;
        }
        for (int i = 0; i < getSize(); i++) {
            allPakus[i] = pakudex[i];
            test[i] = pakudex[i];
        }
        return allPakus;
    }

    //Returns an int array containing the attack, defense, and speed statistics of species at indices 0, 1, and 2
    //respectively; if species is not in the Pakudex, returns null
    public int[] getStats(String species) {
        Pakuri statSpecies;
        statSpecies = new Pakuri(species);
        if(evolve == true) {
            statSpecies.evolve();
        }
        int[] stats = new int[3];
        for (int i = 0; i <= getSize(); i++) {
            if (Objects.equals(pakudex[i], species)) {
                stats[0] = statSpecies.getAttack();
                stats[1] = statSpecies.getDefense();
                stats[2] = statSpecies.getSpeed();
                return stats;
            }
        }
                return null;
    }

    //Sorts the Pakuri objects in this Pakudex according to Java standard lexicographical ordering of species name
    public void sortPakuri() {
        getSpeciesArray();
        for(int i = 0; i < getCapacity()-1; ++i) {
            for (int j = i + 1; j < getSize(); ++j) {
                if (pakudex[i].compareTo(pakudex[j]) > 0) {
                    String temp = pakudex[i];
                    pakudex[i] = pakudex[j];
                    pakudex[j] = temp;
                }
            }
        }

    }

    //Adds species to the Pakudex; if successful, return true, and false otherwise
    public boolean addPakuri(String species) {

        for (int i = 0; i < pakuSize; i++) {
            if (Objects.equals(pakudex[i], species)) {
                break;
            }
            if (pakudex[i] == null) {
                pakudex[i] = species;
                return true;
            }
        }
        return false;
    }

    //Attempts to evolve species within the Pakudex; if successful, return true, and false otherwise
    public boolean evolveSpecies(String species) {
        Pakuri statSpecies;
        statSpecies = new Pakuri(species);
        for (int i = 0; i < pakuSize; i++) {
            if (Objects.equals(pakudex[i], species)) {
                statSpecies.evolve();
                evolve = true;
                return true;
            }
        }
        return false;
    }


}
