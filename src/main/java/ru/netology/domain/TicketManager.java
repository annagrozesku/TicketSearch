package ru.netology.domain;

import ru.netology.repository.TicketRepository;

public class TicketManager {

    protected TicketRepository repo;

    public TicketManager(TicketRepository repo) {
        this.repo = repo;
    }

    public void add(Ticket ticket) {
        repo.save(ticket);
    }

    public Ticket[] findAll() {
        Ticket[] tickets = repo.findAll();
        return tickets;
    }

    public void removeById(int id) {
        repo.removeById(id);
    }

    public Ticket[] searchBy(String from, String to) {
        Ticket[] result = new Ticket[0];
        for (Ticket ticket : repo.findAll()) {
            if (matches(ticket, from, to)) {
                Ticket[] tmp = new Ticket[result.length + 1];
                for (int i = 0; i < result.length; i++) {
                    tmp[i] = result[i];
                }
                tmp[tmp.length - 1] = ticket;
                result = tmp;
            }
        }
//        Arrays.sort(result);
        return result;
    }

    public boolean matches(Ticket ticket, String from, String to) {
       if (ticket.getFrom().equals(from)) {
           return true;
       }
       if (ticket.getTo().equals(to)) {
           return true;
       }
        return false;
    }
}
