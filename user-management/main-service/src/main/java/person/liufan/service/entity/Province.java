package person.liufan.service.entity;

import java.beans.Transient;
import java.util.List;

public class Province {
    private Integer id;

    private String name;

    private String alias;

    private Byte resource;

    private List<City> cities;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Byte getResource() {
        return resource;
    }

    public void setResource(Byte resource) {
        this.resource = resource;
    }

    public List<City> getCities() {
        return cities;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }
}