package h10;

import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.Objects;

import static org.tudalgo.algoutils.student.Student.crash;

/**
 * Represents a skip list.
 *
 * @param <T> the type of the elements in this list
 *
 * @author Nhan Huynh
 * @see <a href="https://en.wikipedia.org/wiki/Skip_list">Skip list</a>
 */
public class SkipList<T> {

    /**
     * The comparator used to maintain order in this list.
     */
    protected final Comparator<? super T> cmp;

    /**
     * The maximum level of the skip list.
     */
    private final int maxHeight;

    /**
     * The probability function used to determine if a node should be added on another level.
     */
    private final Probability probability;

    /**
     * The head of the skip list.
     */
    @Nullable ListItem<ExpressNode<T>> head;

    /**
     * The current maximum level of the skip list.
     */
    int currentMaxLevel = 0;

    /**
     * The number of items in the skip list.
     */
    int size = 0;

    /**
     * Constructs and initializes an empty skip list.
     *
     * @param cmp         the comparator used to maintain order in this list
     * @param maxHeight   the maximum level of the skip list
     * @param probability the probability function used to determine if a node should be added on another level
     */
    public SkipList(Comparator<? super T> cmp, int maxHeight, Probability probability) {
        this.cmp = cmp;
        this.maxHeight = maxHeight;
        this.probability = probability;
    }

    /**
     * Returns the number of items in the skip list.
     *
     * @return the number of items in the skip list
     */
    public int getCurrentMaxLevel() {
        return currentMaxLevel;
    }

    /**
     * Returns the number of items in the skip list.
     *
     * @return the number of items in the skip list
     */
    public int size() {
        return size;
    }

    /**
     * Returns {@code true} if this list contains the specified element.
     *
     * @param key the element whose presence in this list is to be tested
     *
     * @return {@code true} if this list contains the specified element
     */
    public boolean contains(T key) {
        return crash(); // TODO: H1 - remove if implemented
    }

    /**
     * Adds the specified element to this list. The element will be added on the highest floor of the skip list and on
     * the next levels if the probability function returns {@code true}.
     *
     * @param key the element to be added
     */
    public void add(T key) {
        crash(); // TODO: H2 - remove if implemented
    }

    /**
     * Removes the first occurrence of the specified element from this list, if it is present. The element will be
     * removed from all levels.
     *
     * @param key the element to be removed from this list, if present
     */
    public void remove(T key) {
        crash(); // TODO: H3 - remove if implemented
    }

    /**
     * Returns {@code true} if this list contains no elements.
     *
     * @return {@code true} if this list contains no elements
     */
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        SkipList<?> skipList = (SkipList<?>) o;
        return currentMaxLevel == skipList.currentMaxLevel && size == skipList.size
            && Objects.equals(head, skipList.head);
    }

    @Override
    public int hashCode() {
        return Objects.hash(maxHeight, head, currentMaxLevel, size);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (ListItem<ExpressNode<T>> walker = head; walker != null; walker = walker.key.down) {
            sb.append("[");
            for (ListItem<ExpressNode<T>> walker2 = walker.next; walker2 != null; walker2 = walker2.next) {
                sb.append(walker2.key.value);
                if (walker2.next != null) {
                    sb.append(", ");
                }
            }
            sb.append("]");
            if (walker.key.down != null) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}
