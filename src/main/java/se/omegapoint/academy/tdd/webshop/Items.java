package se.omegapoint.academy.tdd.webshop;

import java.math.BigDecimal;

public class Items {

    public static final Item KEXCHOKLAD = new Item(1, "Kexchoklad", BigDecimal.valueOf(14));
    public static final Item BILAR = new Item(2, "Ahlgrens bilar", BigDecimal.valueOf(23));
    public static final Item VECKANS_NU = new Item(3, "Veckans nu!", BigDecimal.valueOf(29));
    public static final Item BRUN_BANAN = new Item(4, "Banan", BigDecimal.valueOf(7));
    public static final Item LORANGA = new Item(5, "Loranga", BigDecimal.valueOf(13));
    public static final Item JOLT = new Item(5, "JOLT Cola", BigDecimal.valueOf(1450, 2));
}
