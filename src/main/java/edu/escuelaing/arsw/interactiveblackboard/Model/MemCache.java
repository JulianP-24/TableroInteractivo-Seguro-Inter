package edu.escuelaing.arsw.interactiveblackboard.Model;

import java.util.ArrayList;
import java.util.List;


public class MemCache {
    private int numeroTicket;
    private List<String> tickets;
    private static MemCache memCache;

    public MemCache() {
        tickets = new ArrayList<>();
        numeroTicket = 0;
    }

    public static MemCache getInstance() {
        if (memCache == null) {
            memCache = new MemCache();
        }
        return memCache;
    }

    public synchronized Integer getTicket() {
        Integer numero = numeroTicket++;
        tickets.add(numero.toString());
        return numero;
    }

    public boolean validateTicket(String ticket) {
        boolean valido = tickets.remove(ticket);
        return valido;
    }

    public List<String> getTickets() {
        return tickets;
    }

    public void setTickets(List<String> tickets) {
        this.tickets = tickets;
    }

}
