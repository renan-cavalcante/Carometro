package enums;

public enum Tipo {
    LIVRE(1),
    FATEC(2);

    private final int codigo;

    Tipo(int codigo) {
        this.codigo = codigo;
    }

    public int getCodigo() {
        return codigo;
    }

}
