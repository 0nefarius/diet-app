package pl.dietap.modelfx;

import javafx.beans.property.*;
import org.junit.Test;

import static org.junit.Assert.*;

public class ProductFxTest {

    private ProductFx test = new ProductFx();


    @Test
    public void getId() throws Exception {
        test.setId(1);
        assertEquals(1, test.getId());
    }

    @Test
    public void setId() throws Exception {
        test.setId(1);
        assertEquals(1, test.getId(), 1);
    }

    @Test
    public void getName() throws Exception {
        test.setName("banan");
        assertEquals("banan", test.getName());
    }

    @Test
    public void setName() throws Exception {
        test.setName("Banan");
        assertEquals("Banan", test.getName(), "Banan");
    }

    @Test
    public void getKcal() throws Exception {
        test.setKcal("200");
        assertEquals("200", test.getKcal());
    }
}

