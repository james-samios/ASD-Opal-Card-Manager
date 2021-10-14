package group2.asd.uts.edu.au.opal.model;
/**
 * The type of card assigned to this object.
 */
public enum CardType1 {
    CHILD,
    SCHOOL,
    CONCESSION,
    ADULT;
    @Override
    public String toString() {
        return name().charAt(0) + name().substring(1).toUpperCase();
    }
}
