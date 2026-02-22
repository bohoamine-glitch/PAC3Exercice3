package edu.ieselgrao.javadoc;

public enum PlanetType {
    //ROCKY, GAS_GIANT, ICE_GIANT;
    ROCKY("Rocky Planet", 15.0, 1000.0, 300.0),
    GAS_GIANT("Gas Giant", 50.0, 3000.0, -150.0),
    ICE_GIANT("Ice Giant", 40.0, 5000.0, -200.0);

    private final String description;
    private final double magneticFieldStrength;
    private final double averageDistanceFromStar;
    private final double averageTemperature;

    /**
     * Constructor de la enumeracion PlanetType
     *
     * @param description Descripción del tipo de planeta.
     * @param magneticFieldStrength Intensidad del campo magnético.
     * @param averageDistanceFromStar Distancia media respecto a su estrella.
     * @param averageTemperature Temperatura media del planeta.
     */
    PlanetType(String description, double magneticFieldStrength, double averageDistanceFromStar, double averageTemperature) {
        this.description = description;
        this.magneticFieldStrength = magneticFieldStrength;
        this.averageDistanceFromStar = averageDistanceFromStar;
        this.averageTemperature = averageTemperature;
    }

    /**
     * Sirve para devolver el valor del atributo
     *
     * @return descripcion
     */
    public String getDescription(){
        return description;
    }

    /**
     * Sirve para devolver el valor del atributo magneticFieldStrength
     *
     * @return magneticFieldStrength
     */
    public double getMagneticFieldStrength(){
        return magneticFieldStrength;
    }

    /**
     * Sirve para devolver el valor del atributo averageDistanceFromStar
     *
     * @return averageDistanceFromStar
     */
    public double getAverageDistanceFromStar(){
        return averageDistanceFromStar;
    }

    /**
     * Sirve para devolver el valor del atributo averageTemperature
     *
     * @return averageDistanceFromStar
     */
    public double getAverageTemperature(){
        return averageTemperature;
    }

    /**
     * Devuelve el tipo de planeta cuya descripción coincide con la proporcionada.
     *
     * @param description Descripción del tipo de planeta a buscar.
     * @return El PlanetType cuya descripción coincide, o null si no se encuentra ninguno.
     */
    public static PlanetType getType(String description){
        for(PlanetType type : PlanetType.values()){
            if(type.description.equals(description)){
                return type;
            }
        }
        return null;
    }

    /**
     * Devuelve el siguiente tipo de planeta esperado según un orden predefinido.
     *
     * El orden definido es:
     * ROCKY → GAS_GIANT → ICE_GIANT → ROCKY.
     *
     * @return El siguiente PlanetType según la secuencia establecida.
     */
    public PlanetType getNextExpectedType(){
        PlanetType nextType = switch (this) {
            case ROCKY -> PlanetType.GAS_GIANT;
            case GAS_GIANT -> PlanetType.ICE_GIANT;
            case ICE_GIANT -> PlanetType.ROCKY;
        };
        return nextType;
    }
}
