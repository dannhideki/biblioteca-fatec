package br.gov.sp.centropaulasouza.biblioteca.model.enums;

/**
 *
 * @author Daniel Hideki
 */
public enum TipoAquisicaoEnum {
    
    COMPRA(0,"Compra"),
    DOACAO(1,"Doação"),
    CEETEPS(2,"Ceeteps");
    
    
    private final Integer codigo;
    private final String descricao;

    private TipoAquisicaoEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }


    

}
