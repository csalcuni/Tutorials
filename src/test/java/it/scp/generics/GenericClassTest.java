package it.scp.generics;

import org.junit.Test;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class GenericClassTest {

    @Test
    public void modelMapperSimpleTest() {

        Order order = createOrder("Antimo", "Di Comite","Roma", "Via Indro Montanelli");

        ModelMapper modelMapper = new ModelMapper();
        OrderDTO orderDTO = modelMapper.map(order, OrderDTO.class);

        System.out.println("ORDER: " + order);
        System.out.println("ORDER DTO : " + orderDTO);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());

    }

    @Test
    public void modelMapperGenericListTest() throws InstantiationException, IllegalAccessException {

        List<Order> orders = createOrderList();

        GenericClass<List<Order>, List<OrderDTO>, OrderDTO> genericClass = new GenericClass<>();

        List<OrderDTO> orderDTOs = genericClass.convertToDtoList(orders, new TypeToken<List<OrderDTO>>(){});

        for (OrderDTO orderDTO : orderDTOs) {
            System.out.println("ORDER DTO : " + orderDTO);
        }
    }

    @Test
    public void modelMapperGenericListTest3() throws InstantiationException, IllegalAccessException {

        List<Order> orders = createOrderList();

        GenericClass<List<Order>, List<OrderDTO>, OrderDTO> genericClass = new GenericClass<>();

        List<OrderDTO> orderDTOs = genericClass.convertToDtoList(orders, OrderDTO.class);

        for (OrderDTO orderDTO : orderDTOs) {
            System.out.println("ORDER DTO : " + orderDTO);
        }
    }

    @Test
    public void modelMapperGenericListTest2() {

        List<Order> orders = createOrderList();

        GenericClass<Order, OrderDTO, OrderDTO> genericClass = new GenericClass<>();

        List<OrderDTO> orderDTOs = genericClass.convertToDtoList(orders, OrderDTO.class);

        for (OrderDTO orderDTO : orderDTOs) {
            System.out.println("ORDER DTO : " + orderDTO);
        }
    }


    @Test
    public void modelMapperGenericTest() {

        Order order = createOrder("Carlo", "Salcuni","Roma", "Via Rosasco");

        GenericClass<Order, OrderDTO, OrderDTO> genericClass = new GenericClass<>();

        OrderDTO orderDTO = genericClass.convertToDto(order, OrderDTO.class);

        System.out.println("ORDER: " + order);
        System.out.println("ORDER DTO : " + orderDTO);

        assertEquals(order.getCustomer().getName().getFirstName(), orderDTO.getCustomerFirstName());
        assertEquals(order.getCustomer().getName().getLastName(), orderDTO.getCustomerLastName());
        assertEquals(order.getBillingAddress().getStreet(), orderDTO.getBillingStreet());
        assertEquals(order.getBillingAddress().getCity(), orderDTO.getBillingCity());

    }


    private List<Order> createOrderList() {
        List<Order> orders = new ArrayList<>();
        orders.add(createOrder("Carlo", "Salcuni","Roma", "Via Rosasco"));
        orders.add(createOrder("Antimo", "Di Comite","Taranto", "Via Cozze"));
        orders.add(createOrder("Fabio", "Tanese","Milano", "Via Risotto alla milanese"));

        return orders;
    }

    private Order createOrder(String firstName, String lastName, String billingCity, String billingStreet) {
        Address address = new Address();
        address.setStreet(billingStreet);
        address.setCity(billingCity);
        Name name = new Name();
        name.setFirstName(firstName);
        name.setLastName(lastName);
        Customer customer = new Customer();
        customer.setName(name);
        Order order = new Order();
        order.setBillingAddress(address);
        order.setCustomer(customer);

        return order;
    }
}
