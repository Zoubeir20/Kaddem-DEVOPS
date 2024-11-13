package tn.esprit.spring.kaddem;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.esprit.spring.kaddem.entities.Contrat;
import tn.esprit.spring.kaddem.entities.Etudiant;
import tn.esprit.spring.kaddem.entities.Specialite;
import tn.esprit.spring.kaddem.repositories.ContratRepository;
import tn.esprit.spring.kaddem.repositories.EtudiantRepository;
import tn.esprit.spring.kaddem.services.ContratServiceImpl;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class ContratServiceImplTest {

    @Mock
    private ContratRepository contratRepository;

    @Mock
    private EtudiantRepository etudiantRepository;

    @InjectMocks
    private ContratServiceImpl contratService;

    private Contrat contrat;
    private Etudiant etudiant;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        // Setup test entities
        etudiant = new Etudiant();
        etudiant.setNomE("Doe");
        etudiant.setPrenomE("John");

        contrat = new Contrat();
        contrat.setIdContrat(1);
        contrat.setArchive(false);
        contrat.setEtudiant(etudiant);
        contrat.setSpecialite(Specialite.IA); // Set specialization to IA (as an example)
    }

    @Test
    public void testAddContrat() {
        when(contratRepository.save(any(Contrat.class))).thenReturn(contrat);

        Contrat result = contratService.addContrat(contrat);

        assertNotNull(result);
        assertEquals(1, result.getIdContrat());
        verify(contratRepository, times(1)).save(contrat);
    }

    @Test
    public void testRetrieveContrat() {
        when(contratRepository.findById(1)).thenReturn(Optional.of(contrat));

        Contrat result = contratService.retrieveContrat(1);

        assertNotNull(result);
        assertEquals(1, result.getIdContrat());
        verify(contratRepository, times(1)).findById(1);
    }

    @Test
    public void testUpdateContrat() {
        when(contratRepository.save(any(Contrat.class))).thenReturn(contrat);

        contrat.setArchive(true);
        Contrat result = contratService.updateContrat(contrat);

        assertNotNull(result);
        assertTrue(result.getArchive());
        verify(contratRepository, times(1)).save(contrat);
    }

    @Test
    public void testRemoveContrat() {
        when(contratRepository.findById(1)).thenReturn(Optional.of(contrat));

        contratService.removeContrat(1);

        verify(contratRepository, times(1)).delete(contrat);
    }


    @Test
    public void testNbContratsValides() {
        // You can mock the repository method using Mockito
        when(contratRepository.getnbContratsValides(any(), any())).thenReturn(5);

        int result = contratService.nbContratsValides(new Date(), new Date());

        assertEquals(5, result);
    }

    @Test
    public void testGetChiffreAffaireEntreDeuxDates() {
        // Mock repository to return a list of contracts with valid Specialites
        Contrat contrat2 = new Contrat();
        contrat2.setIdContrat(2);
        contrat2.setSpecialite(Specialite.CLOUD); // Another contract with a different specialization

        when(contratRepository.findAll()).thenReturn(List.of(contrat, contrat2));

        // Adjust dates as needed for your case
        Date startDate = new Date(System.currentTimeMillis() - 100000000L); // Adjust start date
        Date endDate = new Date(); // Current date as end date

        float result = contratService.getChiffreAffaireEntreDeuxDates(startDate, endDate);

        assertTrue(result > 0, "The revenue should be greater than 0, but was: " + result);
    }
}
