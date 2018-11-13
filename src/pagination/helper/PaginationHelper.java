package pagination.helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PaginationHelper<I> {
    public static void main(String[] args) {
        PaginationHelper ph = new PaginationHelper(Arrays.asList('a', 'b', 'c', 'd', 'e', 'f'), 4);
        System.out.println(ph.pageCount());
        System.out.println(ph.itemCount());
        System.out.println(ph.pageItemCount(0));
        System.out.println(ph.pageItemCount(1));
        System.out.println(ph.pageItemCount(2));

        System.out.println(ph.pageIndex(5));
        System.out.println(ph.pageIndex(2));
        System.out.println(ph.pageIndex(20));
        System.out.println(ph.pageIndex(-10));
        System.out.println(ph.pageIndex(0));
    }

    private ArrayList<I> collection;
    private int itemsPerPage;
    /**
     * The constructor takes in an array of items and a integer indicating how many
     * items fit within a single page
     */
    public PaginationHelper(List<I> collection, int itemsPerPage) {
        this.collection = new ArrayList<>(collection);
        this.itemsPerPage = itemsPerPage;
    }

    /**
     * returns the number of items within the entire collection
     */
    public int itemCount() {
        if (collection == null)
            return 0;
        return collection.size();
    }

    /**
     * returns the number of pages
     */
    public int pageCount() {
        if (collection == null)
            return 0;
        return (collection.size() % itemsPerPage == 0) ? collection.size() / itemsPerPage : collection.size() / itemsPerPage + 1;
    }

    /**
     * returns the number of items on the current page. page_index is zero based.
     * this method should return -1 for pageIndex values that are out of range
     */
    public int pageItemCount(int pageIndex) {
        if (pageIndex < 0 || pageIndex > this.pageCount() - 1)
            return -1;
        return (pageIndex < this.pageCount() - 1) ? itemsPerPage : collection.size() % itemsPerPage;
    }

    /**
     * determines what page an item is on. Zero based indexes
     * this method should return -1 for itemIndex values that are out of range
     */
    public int pageIndex(int itemIndex) {
        if (itemIndex < 0 || itemIndex > collection.size() - 1)
            return -1;
        return itemIndex / itemsPerPage;
    }

}

