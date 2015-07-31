package main;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by tine kleivane on 30/07/15.
 *
 * Registered under MIT License, see @http://opensource.org/licenses/MIT
 */
public class KommentertKlasse {

    // Navn
    private String name;

    public KommentertKlasse(String name) {
        this.name = name;
    }

    /** Default constructor **/
    public KommentertKlasse() {
    }

    public boolean erKlassenKommentert(){
        //TODO: Implementer funksjonaliteten for å sjekke kommentarer
        throw new NotImplementedException();
    }

    /**
     *
     * Sorterer kommentarer
     *
     * @param kommentarer usorterte kommentarer
     * @return sorterte kommentarer
     */
    public void sorterKommentarer(List<String> kommentarer){
        // Collections.sort(kommentarer);
        kommentarer.sort(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                // Se bortifra første bokstav, da denne representerer type
                return o1.substring(1).compareTo(o2.substring(1));
            }
        });
    }
}
