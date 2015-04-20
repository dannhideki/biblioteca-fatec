package br.gov.sp.centropaulasouza.biblioteca.model;

/**
 *
 * @author Daniel Hideki
 */
public enum SexoEnum {
    
    MASCULINO("M", "MASCULINO"),
    FEMININO("F", "FEMININO"),
    INDIFERENTE("I", "INDIFERENTE");
    
    private final String codigo;
    private final String descricao;

    private SexoEnum(String value, String descricao) {
        this.codigo = value;
        this.descricao = descricao;
    }

    public String getValue() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
    
    public static SexoEnum getByValue(String value) {
        
        if (value == null) return null;
        
        for (SexoEnum t : values()) {
            if (t.codigo.equals(value)) {
                return t;
            }
        }
        
        return null;
    }
}
