package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import java.util.ArrayList;

public class DiscountApplierTest {

    static DiscountApplier discountApplier;
    static ProductDao productDao;
    static ArrayList<Product> products, productsExpected;
    static Product homeProduct, homeProductResult;
    static Product officeProduct, officeProductResult;
    static Product otherProduct, otherProductResult;

    @BeforeEach
    void setup() {
        products = new ArrayList<>();
        productsExpected = new ArrayList<>();
        productDao = Mockito.mock(ProductDao.class);
        discountApplier = new DiscountApplier(productDao);
        homeProduct = new Product("homeProduct", 1, "HOME");
        officeProduct = new Product("officeProduct", 1, "BUSINESS");
        otherProduct = new Product("otherProduct", 1, "OTHER");
        homeProductResult = new Product("homeProduct", 0.9, "HOME");
        officeProductResult = new Product("officeProduct", 1.1, "BUSINESS");
        otherProductResult = new Product("otherProduct", 1, "OTHER");
    }

    @Test
    void emptyListTest() {
        Mockito.when(productDao.all()).thenReturn(new ArrayList<>());
        discountApplier.setNewPrices();
        Assertions.assertEquals(new ArrayList<>(), productDao.all());
    }

    @Test
    void oneHomeProduct() {
        products.add(homeProduct);
        productsExpected.add(homeProductResult);
        Mockito.when(productDao.all()).thenReturn(products);
        discountApplier.setNewPrices();
        Assertions.assertEquals(productsExpected.get(0).getPrice(), productDao.all().get(0).getPrice());
    }
    @Test
    void oneOfficeProduct() {
        products.add(officeProduct);
        productsExpected.add(officeProductResult);
        Mockito.when(productDao.all()).thenReturn(products);
        discountApplier.setNewPrices();
        Assertions.assertEquals(productsExpected.get(0).getPrice(), productDao.all().get(0).getPrice());
    }

    @Test
    void oneOtherProduct() {
        products.add(otherProduct);
        productsExpected.add(otherProductResult);
        Mockito.when(productDao.all()).thenReturn(products);
        discountApplier.setNewPrices();
        Assertions.assertEquals(productsExpected.get(0).getPrice(), productDao.all().get(0).getPrice());
    }
}

