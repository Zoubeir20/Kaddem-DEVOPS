package tn.esprit.spring.kaddem;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import tn.esprit.spring.kaddem.entities.DetailEquipe;
import tn.esprit.spring.kaddem.entities.Equipe;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Niveau;

import java.util.HashSet;
import java.util.Set;
import static org.junit.jupiter.api.Assertions.*;

public class EquipeTest {

    private Equipe equipe;

    @BeforeEach
    public void setUp() {
        equipe = new Equipe("Team Alpha", Niveau.JUNIOR);
    }

    // Test Constructors
    @Test
    public void testDefaultConstructor() {
        Equipe defaultEquipe = new Equipe();
        assertNotNull(defaultEquipe, "The default constructor should create an instance.");
    }

    @Test
    public void testConstructorWithNomEquipe() {
        Equipe equipeWithNom = new Equipe("Team Beta");
        assertEquals("Team Beta", equipeWithNom.getNomEquipe(), "The team name should match the provided value.");
    }

    @Test
    public void testConstructorWithNomEquipeAndNiveau() {
        assertEquals("Team Alpha", equipe.getNomEquipe(), "The team name should match the initialized value.");
        assertEquals(Niveau.JUNIOR, equipe.getNiveau(), "The level should match the initialized value.");
    }

    @Test
    public void testConstructorWithAllFields() {
        Set<Etudiant> etudiants = new HashSet<>();
        DetailEquipe detailEquipe = new DetailEquipe();
        Equipe equipeWithAll = new Equipe(1, "Team Gamma", Niveau.SENIOR, etudiants, detailEquipe);

        assertEquals(1, equipeWithAll.getIdEquipe(), "The ID should match the provided value.");
        assertEquals("Team Gamma", equipeWithAll.getNomEquipe(), "The team name should match the provided value.");
        assertEquals(Niveau.SENIOR, equipeWithAll.getNiveau(), "The level should match the provided value.");
        assertEquals(etudiants, equipeWithAll.getEtudiants(), "The students should match the provided set.");
        assertEquals(detailEquipe, equipeWithAll.getDetailEquipe(), "The detailEquipe should match the provided value.");
    }

    // Test Getters and Setters
    @Test
    public void testSetAndGetIdEquipe() {
        equipe.setIdEquipe(10);
        assertEquals(10, equipe.getIdEquipe(), "The ID should be updated to the new value.");
    }

    @Test
    public void testSetAndGetNomEquipe() {
        equipe.setNomEquipe("Team Delta");
        assertEquals("Team Delta", equipe.getNomEquipe(), "The team name should be updated to the new value.");
    }

    @Test
    public void testSetAndGetNiveau() {
        equipe.setNiveau(Niveau.EXPERT);
        assertEquals(Niveau.EXPERT, equipe.getNiveau(), "The level should be updated to EXPERT.");
    }

    // Test Relationship with Etudiant (Many-to-Many)
    @Test
    public void testSetAndGetEtudiants() {
        Set<Etudiant> etudiants = new HashSet<>();
        Etudiant etudiant1 = new Etudiant("Smith", "John");
        Etudiant etudiant2 = new Etudiant("Doe", "Jane");
        etudiants.add(etudiant1);
        etudiants.add(etudiant2);

        equipe.setEtudiants(etudiants);
        assertEquals(etudiants, equipe.getEtudiants(), "The etudiants set should be updated to the provided set.");
        assertTrue(equipe.getEtudiants().contains(etudiant1), "The etudiants set should contain etudiant1.");
        assertTrue(equipe.getEtudiants().contains(etudiant2), "The etudiants set should contain etudiant2.");
    }

    @Test
    public void testSetEtudiantsWithEmptySet() {
        equipe.setEtudiants(new HashSet<>());
        assertTrue(equipe.getEtudiants().isEmpty(), "The etudiants set should be empty.");
    }

    // Test Relationship with DetailEquipe (One-to-One)
    @Test
    public void testSetAndGetDetailEquipe() {
        DetailEquipe detailEquipe = new DetailEquipe(202, "AI Research");
        equipe.setDetailEquipe(detailEquipe);
        assertEquals(detailEquipe, equipe.getDetailEquipe(), "The detailEquipe should be updated to the provided value.");
    }

    @Test
    public void testSetDetailEquipeWithNull() {
        equipe.setDetailEquipe(null);
        assertNull(equipe.getDetailEquipe(), "The detailEquipe should be null when set to null.");
    }
}
