package ru.netology.domain;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.repository.TicketRepository;
import java.util.Arrays;

public class TicketManagerTest {

    TicketRepository repo = new TicketRepository();
    TicketManager manager = new TicketManager(repo);

    Ticket ticket1 = new Ticket(552, 2_500, "DME", "ASF", 120);
    Ticket ticket2 = new Ticket(724, 5_000, "DME", "ASF", 180);
    Ticket ticket3 = new Ticket(351, 25_000, "AYT", "LED",240);
    Ticket ticket4 = new Ticket(112, 10_000, "VKO", "ALA", 190);
    Ticket ticket5 = new Ticket(221, 1_500, "LED", "SVO", 90);

    @Test
    public void shouldAddSomeProducts() {

        manager.add(ticket1);
        manager.add(ticket3);
        manager.add(ticket5);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket1, ticket3, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOneProduct() {

        manager.add(ticket2);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldNotAddProduct() {

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveById() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.removeById(351);

        Ticket[] actual = manager.findAll();
        Ticket[] expected = {ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldNotSearchProduct() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("ALA", "VKO");
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchOneProduct() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("VKO", "ALA");
        Ticket[] expected = {ticket4};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void ShouldSearchTwoProducts() {

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("DME", "ASF");
        Ticket[] expected = {ticket1, ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

        @Test
        public void ShouldSortedFromLowestPriceToHighest() {

            manager.add(ticket1);
            manager.add(ticket2);
            manager.add(ticket3);
            manager.add(ticket4);
            manager.add(ticket5);

            Ticket[] tickets = {ticket1, ticket2, ticket3, ticket4, ticket5};
            Arrays.sort(tickets);

            Ticket[] expected = {ticket5, ticket1, ticket2, ticket4, ticket3};

            Assertions.assertArrayEquals(expected, tickets);}

}
