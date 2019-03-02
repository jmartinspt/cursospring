package pt.jmartinspt.cursospring.domain.enums;

public enum TipoCliente {

    PARTICULAR(1, "Cliente particular"),
    EMPRESARIAL(2, "Cliente empresrial");


    private int cod;
    private String descricao;


    private TipoCliente(int cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public int getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }

    public static TipoCliente toEnum(Integer cod) {

        if (cod == null) {
            return null;

        }

        for (TipoCliente x : TipoCliente.values()) {

            if (cod.equals(x.getCod())) {

                return x;

            }
        }

        throw new IllegalArgumentException(("Código inválido: " + cod));

    }
}
