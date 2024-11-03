package tn.esprit.spring.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@SuppressWarnings("SpellCheckingInspection")
@Entity
public class Etudiant implements Serializable {

    private static final Logger logger = LogManager.getLogger(Etudiant.class);

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEtudiant;
    private String nomE;
    private String prenomE;

    @Enumerated(EnumType.STRING)
    private Option op;

    @OneToMany(mappedBy="etudiant", cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Contrat> Contrats;

    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @ManyToMany(mappedBy="etudiants")
    @JsonIgnore
    private List<Equipe> equipes;

    public Etudiant() {
        logger.info("Default Etudiant constructor called");
    }

    public Etudiant(String nomE, String prenomE) {
        this.nomE = nomE;
        this.prenomE = prenomE;
        logger.info("Creating Etudiant with nomE: {} and prenomE: {}", nomE, prenomE);
    }

    public Etudiant(String nomE, String prenomE, Option op) {
        this.nomE = nomE;
        this.prenomE = prenomE;
        this.op = op;
        logger.info("Creating Etudiant with nomE: {}, prenomE: {}, and option: {}", nomE, prenomE, op);
    }

    public Integer getIdEtudiant() {
        logger.debug("Getting idEtudiant: {}", idEtudiant);
        return idEtudiant;
    }

    public void setIdEtudiant(Integer idEtudiant) {
        this.idEtudiant = idEtudiant;
        logger.debug("Setting idEtudiant: {}", idEtudiant);
    }

    public String getNomE() {
        return nomE;
    }

    public void setNomE(String nomE) {
        this.nomE = nomE;
        logger.debug("Setting nomE: {}", nomE);
    }

    public String getPrenomE() {
        return prenomE;
    }

    public void setPrenomE(String prenomE) {
        this.prenomE = prenomE;
        logger.debug("Setting prenomE: {}", prenomE);
    }

    public Option getOp() {
        return op;
    }

    public void setOp(Option op) {
        this.op = op;
        logger.debug("Setting option: {}", op);
    }

    public Set<Contrat> getContrats() {
        logger.info("Retrieving contrats for Etudiant ID: {}", idEtudiant);
        return Contrats;
    }

    public void setContrats(Set<Contrat> contrats) {
        this.Contrats = contrats;
        logger.debug("Setting contrats for Etudiant ID: {}", idEtudiant);
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
        logger.debug("Setting departement: {}", departement);
    }

    public List<Equipe> getEquipes() {
        return equipes;
    }

    public void setEquipes(List<Equipe> equipes) {
        if (equipes == null || equipes.isEmpty()) {
            logger.warn("No equipes provided for Etudiant ID: {}", idEtudiant);
        }
        this.equipes = equipes;
        logger.debug("Setting equipes for Etudiant ID: {}", idEtudiant);
    }
}
