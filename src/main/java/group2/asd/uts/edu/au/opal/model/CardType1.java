<<<<<<< Updated upstream
package group2.asd.uts.edu.au.opal.model;
/**
 * The type of card assigned to this object.
 *  @author Qiyang Wu
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
=======
package group2.asd.uts.edu.au.opal.model;public class CardType1 {
>>>>>>> Stashed changes
}
