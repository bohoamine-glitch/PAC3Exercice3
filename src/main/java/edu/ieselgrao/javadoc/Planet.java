package edu.ieselgrao.javadoc;
import java.time.LocalDate;

/**
 * Representa un planeta con sus propiedades físicas y características astronómicas.
 *
 * Esta clase almacena información como el nombre, número de lunas,
 * masa, radio, gravedad, presencia de anillos y tipo de planeta.
 * Además, puede contener una atmósfera asociada representada por
 * la clase {@link edu.ieselgrao.javadoc.Atmosphere}
 *
 * Se realizan validaciones en los métodos setter
 *
 * @author Amine BOHO
 */
public class Planet {
    // Constants for error messages
    public static final String INVALID_NAME = "[ERROR] Name cannot be null or empty";
    public static final String INVALID_NUMBER_OF_MOONS = "[ERROR] Number of moons cannot be negative";
    public static final String INVALID_MASS = "[ERROR] Mass cannot be less than 10e23 kg";
    public static final String INVALID_RADIUS = "[ERROR] Radius cannot be less than 500 km";
    public static final String INVALID_GRAVITY = "[ERROR] Gravity cannot be negative or zero";
    public static final String INVALID_LAST_ALBEDO_MEASUREMENT = "[ERROR] Last albedo measurement cannot be null or in the future";
    public static final String INVALID_PLANET_TYPE = "[ERROR] Invalid planet type";

    // Constants for minimum values
    private static final double MIN_MASS = 5.97e22;
    private static final double MIN_RADIUS = 500;

    // Attributes
    private String name;
    private int numberOfMoons;
    private double mass;
    private double radius;
    private double gravity;
    private LocalDate lastAlbedoMeasurement;
    private boolean hasRings;
    private Atmosphere atmosphere;
    private PlanetType type;

    /**
     *Constructor basico de la classe Planet.
     *
     * @param name Nombre del planeta.
     * @param numberOfMoons Número de lunas del planeta.
     * @param mass Masa del planeta medida en kilogramos
     * @param radius Radio del planeta medido en kilómetros o la unidad definida.
     * @param gravity gravity Gravedad superficial del planeta.
     * @param lastAlbedoMeasurement lastAlbedoMeasurement Fecha de la última medición de albedo.
     * @param hasRings hasRings Indica si el planeta posee anillos planetarios.
     * @param type Tipo de planeta según la enumeración PlanetType.
     */
    // Basic constructor
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        atmosphere = null;
    }

    /**
     * Este methodo es un contructor con atmosphere.
     *
     * Inicializa un planeta con sus propiedades físicas y, además,
     * intenta crear y asociar una atmósfera utilizando los datos proporcionados.
     *
     * Los atributos principales del planeta se asignan mediante sus métodos setter,
     * lo que permite validar los valores antes de almacenarlos.
     *
     * En cuanto a la atmósfera, si los datos proporcionados no son válidos y se
     * produce una IllegalArgumentException, la atmósfera no se asignará y quedará
     * como null.
     *
     * @param name Nombre del planeta.
     * @param numberOfMoons Número de lunas del planeta.
     * @param mass Masa del planeta medida en kilogramos
     * @param radius Radio del planeta medido en kilómetros o la unidad definida.
     * @param gravity gravity Gravedad superficial del planeta.
     * @param lastAlbedoMeasurement lastAlbedoMeasurement Fecha de la última medición de albedo.
     * @param hasRings hasRings Indica si el planeta posee anillos planetarios.
     * @param type Tipo de planeta según la enumeración PlanetType.
     * @param composition Se refiere a la composición del aire o sustancia.
     * @param lastObservation Significa la última observación registrada.
     * @param airQuality Es la calidad del aire.
     * @param pressure Es la presión atmosférica.
     * @param density Es la densidad del aire, es decir, cuánta masa hay en un determinado volumen.
     * @param hasClouds Es un valor booleano (true o false) que indica si hay nubes presentes.
     */
    // Detailed constructor with atmosphere
    public Planet(String name, int numberOfMoons, double mass, double radius, double gravity, LocalDate lastAlbedoMeasurement, boolean hasRings, PlanetType type, String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        setName(name);
        setNumberOfMoons(numberOfMoons);
        setMass(mass);
        setRadius(radius);
        setGravity(gravity);
        setLastAlbedoMeasurement(lastAlbedoMeasurement);
        setHasRings(hasRings);
        setType(type);

        try {
            setAtmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
        } catch (IllegalArgumentException e) {
            this.atmosphere = null;
        }
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    /**
     * Este mehodo sirve para comprobar el variable antes de asignarlo al atributo Name.
     *
     * @param name Nombre del planeta.
     * @throws  IllegalArgumentException if name = null o name esta vacío.
     */
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(INVALID_NAME);
        }
        this.name = name;
    }

    public int getNumberOfMoons() {
        return numberOfMoons;
    }

    /**
     * Este methodo sirve para verificar si la variable number of moons es negativo  antes de asignarlo al atributo.
     *
     * @param numberOfMoons Número de lunas del planeta.
     * @throws IllegalArgumentException if number of moons es negativo.
     */
    public void setNumberOfMoons(int numberOfMoons) {
        if (numberOfMoons < 0) {
            throw new IllegalArgumentException(INVALID_NUMBER_OF_MOONS);
        }
        this.numberOfMoons = numberOfMoons;
    }

    public double getMass() {
        return mass;
    }

    /**
     * Este methodo sirve para verificar si la masa del plante es menor que la masa minima de un planete antes de asignarlo.
     *
     * @param mass Masa del planeta medida en kilogramos
     * @throws IllegalArgumentException if la masa es menor que la masa minima de un planete.
     */
    public void setMass(double mass) {
        if (mass < MIN_MASS) {
            throw new IllegalArgumentException(INVALID_MASS);
        }
        this.mass = mass;
    }

    public double getRadius() {
        return radius;
    }

    /**
     * Este methodo sirve para verificar que el variable radio es mayor que el minimu antes de asignarlo al atributo.
     *
     * @param radius Radio del planeta medido en kilómetros o la unidad definida.
     * @throws IllegalArgumentException if radio es menor que el minimo.
     */
    public void setRadius(double radius) {
        if (radius < MIN_RADIUS) {
            throw new IllegalArgumentException(INVALID_RADIUS);
        }
        this.radius = radius;
    }

    public double getGravity() {
        return gravity;
    }

    /**
     * Este methodo sirve para comprobar si la varibale gravity es negativo antes de asignarlo.
     *
     * @param gravity gravity Gravedad superficial del planeta.
     * @throws IllegalArgumentException if graviti es negativo
     */
    public void setGravity(double gravity) {
        if (gravity <= 0) {
            throw new IllegalArgumentException(INVALID_GRAVITY);
        }
        this.gravity = gravity;
    }
    public LocalDate getLastAlbedoMeasurement() {
        return lastAlbedoMeasurement;
    }

    /**
     * Establece un valor al atributo LastAlbedoMeasurement
     *
     * @param lastAlbedoMeasurement lastAlbedoMeasurement Fecha de la última medición de albedo.
     * @throws  IllegalArgumentException if lastAlbedoMeasurement es null o despues del la varible LocaleDate.Now.
     */
    public void setLastAlbedoMeasurement(LocalDate lastAlbedoMeasurement) {
        // last albedo measurement is allowed to be today (LocalDate.now())
        if (lastAlbedoMeasurement == null || lastAlbedoMeasurement.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException(INVALID_LAST_ALBEDO_MEASUREMENT);
        }
        this.lastAlbedoMeasurement = lastAlbedoMeasurement;
    }
    public boolean hasRings() {
        return hasRings;
    }

    /**
     * Este methodo sirve para asignar un variable al atributo hasRings.
     *
     * @param hasRings hasRings Indica si el planeta posee anillos planetarios.
     */
    public void setHasRings(boolean hasRings) {
        this.hasRings = hasRings;
    }

    public Atmosphere getAtmosphere() {
        return atmosphere;
    }

    /**
     *Este methodo crea y asigna una nueva atmósfera al planeta utilizando los datos proporcionados.
     *
     * Este método instancia un objeto Atmosphere con los parámetros recibidos
     * y lo asigna al atributo atmosphere. Si alguno de los valores no es válido,
     * puede lanzarse una IllegalArgumentException desde el constructor de Atmosphere.
     *
     * @param composition Se refiere a la composición del aire o sustancia.
     * @param lastObservation Significa la última observación registrada.
     * @param airQuality Es la calidad del aire.
     * @param pressure Es la presión atmosférica.
     * @param density Es la densidad del aire, es decir, cuánta masa hay en un determinado volumen.
     * @param hasClouds Es un valor booleano (true o false) que indica si hay nubes presentes.
     */
    public void setAtmosphere(String composition, LocalDate lastObservation, int airQuality, double pressure, double density, boolean hasClouds) {
        // Can propagate IllegalArgumentException
        atmosphere = new Atmosphere(composition, lastObservation, airQuality, pressure, density, hasClouds);
    }

    public PlanetType getType() {
        return type;
    }

    /**
     * Este methodo sirve para comprobar si la varibale type es null antes de asignarlo al atributo.
     *
     * @param type Tipo de planeta según la enumeración PlanetType.
     * @throws IllegalArgumentException if type es null.
     */
    public void setType(PlanetType type) {
        if (type == null) {
            throw new IllegalArgumentException(INVALID_PLANET_TYPE);
        }
        this.type = type;
    }
}
