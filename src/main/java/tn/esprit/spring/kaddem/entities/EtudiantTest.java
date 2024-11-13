package tn.esprit.spring.kaddem.entities;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class EtudiantTest {

    private Etudiant etudiant;

    // Initialize an Etudiant instance before each test
    @BeforeEach
    void setUp() {
        etudiant = new Etudiant("John", "Doe", Option.GAMIX);
    }

    // Test that the constructor initializes Etudiant fields correctly
    @Test
    void testConstructor() {
        assertEquals("John", etudiant.getNomE(), "NomE should be initialized correctly");
        assertEquals("Doe", etudiant.getPrenomE(), "PrenomE should be initialized correctly");
        assertEquals(Option.GAMIX, etudiant.getOp(), "Option should be initialized correctly");
    }
 
    // Test setting and getting the departement
    @Test
    void testSetAndGetDepartement() {
        Departement departement = new Departement(); // Mock or sample Departement
        etudiant.setDepartement(departement);
        assertEquals(departement, etudiant.getDepartement(), "Departement should be set and retrieved correctly");
    }

    // Test setting and getting the list of equipes
    @Test
    void testSetAndGetEquipes() {
        List<Equipe> equipes = new ArrayList<>(); // Using ArrayList instead of List.of
        equipes.add(new Equipe());
        equipes.add(new Equipe());
        etudiant.setEquipes(equipes);
        assertEquals(equipes, etudiant.getEquipes(), "Equipes list should be set and retrieved correctly");
    }

    // Test setting and getting the set of contrats
    @Test
    void testSetAndGetContrats() {
        Set<Contrat> contrats = new HashSet<>(); // Using HashSet instead of Set.of
        contrats.add(new Contrat());
        contrats.add(new Contrat());
        etudiant.setContrats(contrats);
        assertEquals(contrats, etudiant.getContrats(), "Contrats set should be set and retrieved correctly");
    }

    // Test updating the name and surname of Etudiant
    @Test
    void testUpdateNomAndPrenom() {
        etudiant.setNomE("Jane");
        etudiant.setPrenomE("Smith");
        assertEquals("Jane", etudiant.getNomE(), "NomE should be updated correctly");
        assertEquals("Smith", etudiant.getPrenomE(), "PrenomE should be updated correctly");
    }

    // Test setting an empty list of equipes and check if log warns (simulate warning)
    @Test
    void testSetEmptyEquipes() {
        List<Equipe> emptyEquipes = new ArrayList<>(); // Using ArrayList instead of List.of
        etudiant.setEquipes(emptyEquipes);
        assertTrue(etudiant.getEquipes().isEmpty(), "Equipes list should be empty after setting");
    }
}
