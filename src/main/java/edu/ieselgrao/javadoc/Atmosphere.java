package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * Representa las condiciones atmosféricas de una observación dada.
 * Esta clase almacena información sobre la composición del aire, fecha de observación,
 * calidad del aire, presión, densidad y presencia de nubes.
 *
 * Proporciona validación al modificar los atributos para asegurar la integridad de los datos.
 *
 * @autor Amine BOHO
 */
public class Atmosphere
{
    // Constants for error messages
    public static final String INVALID_COMPOSITION = "[ERROR] Composition cannot be null or empty";
    public static final String INVALID_LAST_OBSERVATION = "[ERROR] Last observation cannot be null or in the future";
    public static final String INVALID_PRESSURE = "[ERROR] Pressure cannot be negative";
    public static final String INVALID_DENSITY = "[ERROR] Density cannot be negative";

    // Attributes
    private String composition;
    private LocalDate lastObservation;
    private int airQuality;
    private double pressure;
    private double density;
    private boolean hasClouds;

    /**
     * @param composition Se refiere a la composición del aire o sustancia.
     * @param lastObservation Significa la última observación registrada.
     * @param airQuality Es la calidad del aire.
     * @param pressure Es la presión atmosférica.
     * @param density Es la densidad del aire, es decir, cuánta masa hay en un determinado volumen.
     * @param hasClouds Es un valor booleano (true o false) que indica si hay nubes presentes.
     */
    // Constructor
    public Atmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setComposition(composition);
        setLastObservation(lastObservation);
        setAirQuality(airQuality);
        setPressure(pressure);
        setDensity(density);
        setHasClouds(hasClouds);
    }

    // Getters and setters
    public String getComposition() {
        return composition;
    }

    /**
     * Este methodo sirve para comprobar la variable antes de asignarla al atributo composicion.
     * @param composition Se refiere a la composición del aire o sustancia.
     * @throws Exception if composition is null, vacia o contiene caracteres no validos.
     */
    public void setComposition(String composition) {
        if (composition == null || composition.trim().isEmpty() || !composition.matches("[a-zA-Z0-9, ]+"))
        {
            throw new IllegalArgumentException(INVALID_COMPOSITION);
        }
        this.composition = composition;
    }

    public LocalDate getLastObservation() {
        return lastObservation;
    }

    /**
     * Este methodo sirve para comprobar el lastObservation antes de asignarla al atributo lastObservation.
     * @param lastObservation Significa la última observación registrada.
     * @throws Exception if lastObservation is null o lastObservation is after localDate Now.
     */
    public void setLastObservation(LocalDate lastObservation) {
        // LocalDate.now() can be setted
        if (lastObservation == null || lastObservation.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_OBSERVATION);
        }
        this.lastObservation = lastObservation;
    }

    public int getAirQuality() {
        return airQuality;
    }

    /**
     * Este methodo sirve para asignar un valor al atributo airQuality dependiendo de su valor,asegurando que se mantenga dentro del rango [0, 100].
     * @param airQuality Es la calidad del aire.
     */
    public void setAirQuality(int airQuality) {
        // Adjust to range [0, 100]
        if (airQuality < 0) {
            this.airQuality = 0;
        } else if (airQuality > 100) {
            this.airQuality = 100;
        } else {
            this.airQuality = airQuality;
        }
    }


    public double getPressure() {
        return pressure;
    }

    /**
     * Este methodo sirve para comprobar la variable pressure if es negativo antes de asignarlo
     * @param pressure Es la presión atmosférica.
     * @throws Exception if pressure is negativo
     */
    public void setPressure(double pressure) {
        if (pressure < 0) {
            throw new IllegalArgumentException(INVALID_PRESSURE);
        }
        this.pressure = pressure;
    }

    public double getDensity() {
        return density;
    }

    /**
     * Este methodo sirve para comprobar if density es negativo
     * @param density Es la densidad del aire, es decir, cuánta masa hay en un determinado volumen.
     * @throws Exception if density es negativo
     */
    public void setDensity(double density) {
        if (density < 0) {
            throw new IllegalArgumentException(INVALID_DENSITY);
        }
        this.density = density;
    }

    /**
     * Indica si existe presencia de nubes.
     * @return true if hasClouds is true, false if hasClouds is false
     */
    public boolean hasClouds()
    {
        return hasClouds;
    }

    /**
     * Este methodo sirve para asignar valor al atributo hasClouds
     * @param hasClouds Es un valor booleano (true o false) que indica si hay nubes presentes.
     */
    public void setHasClouds(boolean hasClouds)
    {
        this.hasClouds = hasClouds;
    }
}
