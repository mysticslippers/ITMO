package me.dmitriy.server.data;

/**
 * Enum, представляющий поле ticketType.
 */

public enum TicketType{
    VIP,
    USUAL,
    BUDGETARY;

    /**
     * @return Красивый вывод enum'а.
     */

    public static String showList(){
        StringBuilder ticketTypeList = new StringBuilder("Доступно: \n");
        for(TicketType ticketType : values()){
            ticketTypeList.append(ticketType.name()).append(",\n");
        }
        return ticketTypeList.substring(0, ticketTypeList.length() - 2);
    }
}

