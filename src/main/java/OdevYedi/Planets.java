package OdevYedi;

public enum Planets {
    MERCURY(1, 57.9, 2439, 1408),
    VENUS(2, 108.2, 6052, 5832),
    EARTH(3, 149.6, 6371, 24),
    MARS(4, 227.9, 3390, 24.6),
    JUPITER(5, 778.5, 69911, 9.9);

    private final int orderFromSun;
    private final double distanceFromSun; // in million km
    private final double radius;          // in km
    private final double rotationPeriod;   // in hours


    Planets(int orderFromSun, double distanceFromSun, double radius, double rotationPeriod) {
        this.orderFromSun = orderFromSun;
        this.distanceFromSun = distanceFromSun;
        this.radius = radius;
        this.rotationPeriod = rotationPeriod;
    }

    public int getOrderFromSun() {
        return orderFromSun;
    }
    public double getDistanceFromSun() {
        return distanceFromSun;
    }
    public double getRadius() {
        return radius;
    }

    public double getRotationPeriod() {
        return rotationPeriod;
    }

    @Override
    public String toString() {
        return "Planets: " + this.name() +
                " Features " +
                " orderFromSun=" + orderFromSun + ". " +
                ", distanceFromSun=" + distanceFromSun + "million km" +
                ", radius=" + radius + " km" +
                ", rotationPeriod=" + rotationPeriod + " hours" ;
    }
}
