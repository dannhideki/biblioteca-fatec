package br.gov.sp.centropaulasouza.biblioteca.model.enums;

/**
 *
 * @author hideki
 */
public enum RoleEnum {
     
    ROLE_ADMIN("ROLE_ADMIN"),
    ROLE_COMMON("ROLE_COMMON");
 
    private String value;
     
    private RoleEnum(String value){
        this.value = value;
    }
 
    public String getValue() {
        return value;
    }    
}
