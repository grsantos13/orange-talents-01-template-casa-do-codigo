package br.com.zup.casadocodigo.state;

public class StateResponse {

    private Long id;
    private String name;
    private String countryName;

    @Deprecated
    public StateResponse(){
    }

    public StateResponse(Long id, String name, String countryName) {
        this.id = id;
        this.name = name;
        this.countryName = countryName;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }
}
