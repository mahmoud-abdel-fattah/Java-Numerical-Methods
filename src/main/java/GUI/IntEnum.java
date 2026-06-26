package GUI;

public enum IntEnum {
    SIMPSON("Simpson 1/3"),
    TRAPEZOIDAL("Trapezoidal"),
    ROMBERG("Romberg Integration"),
    GAUSS("Gauss Quadrature"),
    LEFT("Left Rectangular"),
    RIGHT("Right Rectangular");

    private String description;

    private IntEnum(String description){
        this.description = description;
    }

    @Override
    public String toString(){
        return description;
    }

}
