package tests;

import io.qameta.allure.*;
import org.testng.annotations.Test;
import user.UserFactory;

import static org.testng.Assert.*;

public class AddGoodsToCartTest extends BaseTest {
    @Epic("Модуль логина интернет-магазина")
    @Feature("Юридические лица")
    @Story("STG")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Khrol Nat Ser bla@gmail.com")
    @TmsLink("UrnSu")
    @Issue("2")
    @Test(description = "проверяем, что товары добавлены в корзину")
    @Flaky
    public void checkGoodsInCart() {
        loginPage.open();
        loginPage.login(UserFactory.withAdminPermission());
        productsPage.isOpen();
        productsPage.addToCart(0);
        productsPage.addToCart(2);
        productsPage.addToCart(3);
        productsPage.openCart();
        assertTrue(cartPage.getProductsNames().contains("Sauce Labs Backpack"));
        assertEquals(cartPage.getProductsNames().size(), 3);
        assertFalse(cartPage.getProductsNames().isEmpty());
    }
}
