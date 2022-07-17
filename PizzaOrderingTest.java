package com.jap.pizzaorderingsystem;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
//import org.junit.Assert.assertTrue;
//import org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

public class PizzaOrderingTest {
    PizzaOrdering pizzaOrdering;

    @BeforeEach
    void setUp() {
        pizzaOrdering = new PizzaOrdering();
    }

    @AfterEach
    void tearDown() {
        pizzaOrdering = null;
    }

    /* NOTE: Write a minimum of 4 assert statements for each test case */

    @Test
    public void givenPizzaChoiceAndSizeCalculateBill() {
		assertEquals(250,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(3,'R'));
		assertEquals(300,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(4,'M'));
		assertEquals(500,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(5,'L'));
		assertEquals(0,pizzaOrdering.calculateBillBasedOnPizzaChoiceAndSize(2,'R'));
    }

    @Test
    public void givenCrustChoiceEstimatePrice() {
		assertEquals(70,pizzaOrdering.displayCrustChoicesAndEstimatePrice(3));
		assertEquals(80,pizzaOrdering.displayCrustChoicesAndEstimatePrice(2));
		assertEquals(60,pizzaOrdering.displayCrustChoicesAndEstimatePrice(1));
		assertEquals(0,pizzaOrdering.displayCrustChoicesAndEstimatePrice(0));
    }

    @Test
    public void givenToppingsChoiceEstimatePrice() {
		assertEquals(80,pizzaOrdering.displayToppingsAndEstimatePrice(1));
		assertEquals(120,pizzaOrdering.displayToppingsAndEstimatePrice(2));
		assertEquals(0,pizzaOrdering.displayToppingsAndEstimatePrice(0));
		assertEquals(0,pizzaOrdering.displayToppingsAndEstimatePrice(4));
    }

    @Test
    public void givenCrustAndToppingsCostCalculateTotalBill() {
		assertEquals(620,pizzaOrdering.calculateBillWithCrustAndToppings(500,0,120));
		assertEquals(420,pizzaOrdering.calculateBillWithCrustAndToppings(350,70,0));
		assertEquals(70,pizzaOrdering.calculateBillWithCrustAndToppings(0,70,0));
		assertEquals(375,pizzaOrdering.calculateBillWithCrustAndToppings(375,0,0));
    }

    @Test
    public void givenBreadChoiceCalculateTotalBill() {
		assertEquals(90,pizzaOrdering.displayBreadChoiceAndCalculateBill(1));
		assertEquals(80,pizzaOrdering.displayBreadChoiceAndCalculateBill(2));
		assertEquals(0,pizzaOrdering.displayBreadChoiceAndCalculateBill(0));
		assertEquals(0,pizzaOrdering.displayBreadChoiceAndCalculateBill(4));
    }

    @Test
    public void givenDrinksChoiceCalculateTotalBill() {
		assertEquals(60,pizzaOrdering.displayDrinksChoicesAndCalculateBill(1));
		assertEquals(60,pizzaOrdering.displayDrinksChoicesAndCalculateBill(2));
		assertEquals(0,pizzaOrdering.displayDrinksChoicesAndCalculateBill(0));
		assertEquals(0,pizzaOrdering.displayDrinksChoicesAndCalculateBill(7));
    }

    @Test
    public void givenTotalBillEstimateDiscountAmount() {
		assertEquals(25,pizzaOrdering.estimateDiscountAmount(500));
		assertEquals(130,pizzaOrdering.estimateDiscountAmount(1300));
		assertEquals(0,pizzaOrdering.estimateDiscountAmount(499));
		assertEquals(0,pizzaOrdering.estimateDiscountAmount(1501));
    }

    @Test
    public void givenDeliveryAndTipChargeCalculateFinalBill() {
		assertEquals(680,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(670,0,10));
		assertEquals(600,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(500,100,0));
		assertEquals(125,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(0,100,25));
		assertEquals(0,pizzaOrdering.calculateFinalBillBasedOnDeliveryChargeAndTipCharge(0,0,0));
    }

}
