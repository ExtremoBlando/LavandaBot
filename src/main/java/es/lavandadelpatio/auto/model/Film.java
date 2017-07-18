package es.lavandadelpatio.auto.model;

import javax.persistence.*;
import java.util.*;
import java.util.stream.Stream;

/**
 * Created by raulm on 29/06/2017.
 */
@Entity
public class Film {

    @Id
    @GeneratedValue
    private long id;

    private String longName;

    private Extension ext;

    @Column(unique=true)
    private String name;

    private int year;

    @ElementCollection(fetch = FetchType.EAGER)
    Set<String> sinonimos;

    /*@ElementCollection
    private Set<Attr> atributos = new HashSet<>();*/

    protected Film(){}

    public Film(String longName, String name, Extension ext) {
        this.longName = longName;
        this.name = name;
    }

    public Film(String longName, String name, int year) {
        this.longName = longName;
        this.name = name;
        this.year = year;
    }

    public Film(String longName, String name, Extension ext, int year) {
        this.longName = longName;
        this.ext = ext;
        this.name = name;
        this.year = year;
    }

    public Film(String longName, String name, Extension ext, int year, Collection<String> sinonimos) {
        this.longName = longName;
        this.ext = ext;
        this.name = name;
        this.year = year;
        this.sinonimos = new HashSet<>(sinonimos);
    }


    /**
     * Este constructor intentara crear una pelicula a partir de una linea, siempre que la linea de texto tenga toda la
     * info que necesitamos
     */

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    /*public Set<Attr> getAtributos() {
        return new HashSet<>(atributos);
    }

    public void setAtributos(Set<Attr> atributos) {
        this.atributos = atributos;
    }

    public void addAtributo(String attr){
        this.addAtributo(Attr.valueOf(attr.toUpperCase()));
    }

    public void addAtributo(Attr attr){
        this.atributos.add(attr);
    }*/

    public List<String> getSinonimos() {
        return new ArrayList<>(this.sinonimos);
    }

    public void setSinonimos(Set<String> sinonimos) {
        this.sinonimos = sinonimos;
    }
}
