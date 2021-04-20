package ws1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BillCalculatorTest {
	
	private BillCalculator bc;
	
	@BeforeEach
	public void initialiseBillCalculator() {
		System.out.println("Initialising bill calculator...");
		bc = new BillCalculator();
	}
	
	@Test
	public void testNoItems() {
		BillCalculator bc = new BillCalculator();
		assertEquals(0, bc.calculateTotal(), "Empty bill");
	}
	
	@Test
	public void testAddOneItem() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Additing item of value 5");
	}
	
	@Test
	public void testAddThreeItems() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Adding first item of value 5");
		assertEquals(7, bc.addItem(2), "Adding second item of value 2");
		assertEquals(8, bc.addItem(1), "Adding third item of value 1");
	}
	
	@Test
	public void testToStringEmptyBill() {
		BillCalculator bc = new BillCalculator();
		assertEquals("NOTHING", bc.toString());
	}
	
	@Test
	public void testToStringNonEmptyBill() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Adding first item of value 5");
		assertEquals(7, bc.addItem(2), "Adding second item of value 2");
		assertNotEquals("NOTHING", bc.toString());
	}
	
	@Test
	public void testCalculateTotal() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Adding first item of value 5");
		assertEquals(7, bc.addItem(2), "Adding second item of value 2");
		assertEquals(7, bc.calculateTotal(), "5+2=7");
	}
	
	@Test
	public void testDiscountedTotal() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Adding first item of value 5");
		assertEquals(7, bc.addItem(2), "Adding second item of value 2");
		assertEquals(5.25, bc.applyDiscount(25), "25% discount");
	}
	
	@Test
	public void testFreeLunch() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Adding first item of value 5");
		assertEquals(7, bc.addItem(2), "Adding second item of value 2");
		assertEquals(0, bc.applyDiscount(100), "100% discount");
	}
	
	@Test
	public void testNegativeDiscount() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Adding first item of value 5");
		assertEquals(7, bc.addItem(2), "Adding second item of value 2");
		assertEquals(7, bc.applyDiscount(-50), "-50% discount");
	}
	
	@Test
	public void testDiscountGreaterThanHundred() {
		BillCalculator bc = new BillCalculator();
		assertEquals(5, bc.addItem(5), "Adding first item of value 5");
		assertEquals(7, bc.addItem(2), "Adding second item of value 2");
		assertEquals(0, bc.applyDiscount(150), "150% discount");
	}
	
	@Test
	public void testRemoveLastItem() {
		BillCalculator bc = new BillCalculator();
		assertEquals(0, bc.removeLastItem(), "Remove last item from an empty bill");
		bc.addItem(5);
		assertEquals(0, bc.removeLastItem(), "Remove last item from a non-empty empty bill");		
	}

}
