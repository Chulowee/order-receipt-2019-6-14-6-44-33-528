package org.katas.refactoring;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class OrderReceiptTest {
    @Test
    public void shouldPrintCustomerInformationOnOrder() {
        Order order = new Order("Mr X", "Chicago, 60601", new ArrayList<LineItem>());
        OrderReceipt receipt = new OrderReceipt(order);

        String output = receipt.printReceipt();

        assertThat(output).contains("Mr X", "Chicago, 60601");
    }

    @Test
    public void shouldPrintLineItemAndSalesTaxInformation() {
        ArrayList<LineItem> lineItems = new ArrayList<LineItem>() {{
            add(new LineItem("milk", 10.0, 2));
            add(new LineItem("biscuits", 5.0, 5));
            add(new LineItem("chocolate", 20.0, 1));
        }};
        OrderReceipt receipt = new OrderReceipt(new Order(null, null, lineItems));

        String output = receipt.printReceipt();

        assertThat(output).contains(
                "milk\t10.0\t2\t20.0\n",
                "biscuits\t5.0\t5\t25.0\n",
                "chocolate\t20.0\t1\t20.0\n",
                "Sales Tax\t6.5",
                "Total Amount\t71.5"
        );
    }

    @Test
    void should_order_created_return_order_customer_name() {
        Order customerInformation = createOrder();

        assertEquals("SpongeBob", customerInformation.getCustomerName());
    }

    @Test
    void should_order_created_return_order_customer_Address() {
        Order customerInformation = createOrder();

        assertEquals("Bikini Bottom", customerInformation.getCustomerAddress());
    }

    @Test
    void should_return_total_when_item_list_has_items() {
        Order order = createOrder();
        OrderReceipt orderReceipt = new OrderReceipt(order);

        assertEquals("<======Printing Orders======\n"+
        "SpongeBobBikini BottomApple	12.0	2	24.0\n"+
        "Sales Tax	2.4000000000000004Total Amount	26.4>", orderReceipt.printReceipt());
    }

    private Order createOrder() {
        String customerName = "SpongeBob";
        String customerAddress = "Bikini Bottom";
        List<LineItem> lineItemList = new ArrayList<>();
        LineItem lineItem = new LineItem("Apple", 12.0, 2);
        lineItemList.add(lineItem);

        return new Order(customerName, customerAddress, lineItemList);
    }
}
