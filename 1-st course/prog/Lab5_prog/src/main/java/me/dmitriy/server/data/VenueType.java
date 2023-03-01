package me.dmitriy.server.data;

/**
 * Enum, представляющий поле venueType.
 */

public enum VenueType{
    BAR,
    LOFT,
    MALL;

    /**
     * @return Вывод содержимого enum'a.
     */

    public static String showList(){
        StringBuilder ticketTypeList = new StringBuilder("Доступно: \n");
        for(VenueType venueType : values()){
            ticketTypeList.append(venueType.name()).append(",\n");
        }
        return ticketTypeList.substring(0, ticketTypeList.length() - 2);
    }
}
