package tudelft.invoice;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class InvoiceFilterTest {

    static InvoiceDao dao;
    static List<Invoice> result;
    static Invoice larger1;
    static Invoice larger2;
    static Invoice smallestLarger;
    static Invoice largestSmallest;
    static Invoice smaller1;
    static Invoice smaller2;

    @BeforeAll
    static void setUp() {
        dao = Mockito.mock(InvoiceDao.class);
        larger1 = new Invoice("larger1", 200);
        larger2 = new Invoice("larger2", 300);
        smallestLarger = new Invoice("smallestLarger", 100);
        largestSmallest = new Invoice("largestSmallest", 99);
        smaller1 = new Invoice("smaller1", 50);
        smaller2 = new Invoice("smaller2", 25);
    }

    @Test
    void emptyDatabase() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList());
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(0, result.size());
        dao.close();
    }

    @AfterAll
    static void finish() {
        dao.close();

    }

    @Test
    void singleElementLarger() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList(larger1));
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void singleElementSmaller() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList(smaller1));
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(smaller1, result.get(0));
    }

    @Test
    void multipleElementsAllLarger() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList(larger1, larger2));
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void multipleElementsAllSmaller() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList(smaller1, smaller2));
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(2, result.size());
        Assertions.assertEquals(smaller1, result.get(0));
        Assertions.assertEquals(smaller2, result.get(1));
    }

    @Test
    void multipleElementsOneSmaller() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList(smaller1, larger1));
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(smaller1, result.get(0));
    }

    @Test
    void smallestLarger() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList(smallestLarger));
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(0, result.size());
    }

    @Test
    void largestSmallest() {
        Mockito.when(dao.all()).thenReturn(Arrays.asList(largestSmallest));
        InvoiceFilter filter = new InvoiceFilter();
        result = filter.filter(dao);
        Assertions.assertEquals(1, result.size());
        Assertions.assertEquals(largestSmallest, result.get(0));
    }


//    @Test
//    void filterInvoices() {
//        Invoice mauricio = new Invoice("Mauricio", 20.0);
//        Invoice arie = new Invoice("Arie", 300.0);
//
//        dao.save(mauricio);
//        dao.save(arie);
//
//        InvoiceFilter filter = new InvoiceFilter();
//        List<Invoice> result = filter.filter(dao);
//
//        Assertions.assertEquals(mauricio, result.get(0));
//        Assertions.assertEquals(1, result.size());
//
//        dao.close();
//    }

}
