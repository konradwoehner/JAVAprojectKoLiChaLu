import static org.junit.jupiter.api.Assertions.*;

class JAVAprojectGUITest {
    @org.junit.jupiter.api.Test

    void berechnenTest() {

        //non-static method "berechnen()" durch Instanzerstellung zu für Test gefordert static (Denkanstoß durch Chat GPT)
        JAVAprojectGUI gui = new JAVAprojectGUI();

        // Test für Apple iPhone14 mit 32 GB Speicher und 4 GB RAM
        double result = gui.berechnen("Apple iPhone14", "32", "4");

        // Erwarteter Preis: 799.99
        assertEquals(799.99, result);
    }
}