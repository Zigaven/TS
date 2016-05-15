package New;

/**
 * @author Danil Khisamov
 *         11-402
 */
public class IndexETour {
    public Integer value;
    public IndexETour next;
    public IndexETour prev;

    public IndexETour(Integer value, IndexETour prev, IndexETour next) {
        this.value = value;
        this.next = next;
        this.prev = prev;
    }
}
