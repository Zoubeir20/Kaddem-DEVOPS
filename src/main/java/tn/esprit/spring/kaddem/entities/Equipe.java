package tn.esprit.spring.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Equipe implements Serializable{

    private static final Logger logger = LogManager.getLogger(Equipe.class);

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    //@ManyToMany(mappedBy="equipes")
    @ManyToMany(cascade =CascadeType.ALL)

    @JsonIgnore
    private Set<Etudiant> etudiants;
    @OneToOne
    private DetailEquipe detailEquipe;

    public Equipe() { logger.info("Default Equipe constructor called");
        // TODO Auto-generated constructor stub
    }

    public Equipe(String nomEquipe) {

        this.nomEquipe = nomEquipe;
        logger.info("Creating Equipe with nomEquipe: {} ", nomEquipe);
    }

    public Equipe(String nomEquipe, Niveau niveau) {
        super();
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
        logger.info("Creating Equipe with nomEquipe: {} and niveau: {}  ", nomEquipe, niveau);
    }

    public Equipe(Integer idEquipe, String nomEquipe, Niveau niveau) {
        super();
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
        logger.info("Creating Equipe with idEquipe: {} , nomEquipe: {} and niveau: {}  ", idEquipe, nomEquipe, niveau);
    }

    public Equipe(String nomEquipe, Niveau niveau, Set<Etudiant> etudiants, DetailEquipe detailEquipe) {
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
        this.etudiants = etudiants;
        this.detailEquipe = detailEquipe;
        logger.info("Creating Equipe with nomEquipe: {} , niveau: {}, etudiants: {} and detailEquipe: {}  ", nomEquipe, niveau, etudiants, detailEquipe);
    }

    public Equipe(Integer idEquipe, String nomEquipe, Niveau niveau, Set<Etudiant> etudiants, DetailEquipe detailEquipe) {
        this.idEquipe = idEquipe;
        this.nomEquipe = nomEquipe;
        this.niveau = niveau;
        this.etudiants = etudiants;
        this.detailEquipe = detailEquipe;
        logger.info("Creating Equipe with idEquipe: {}, nomEquipe: {}, niveau: {}, etudiants: {} and detailEquipe: {}  ", idEquipe, nomEquipe, niveau, etudiants, detailEquipe);
    }




    public Set<Etudiant> getEtudiants() {
        logger.debug("Getting etudiant list: {}", etudiants);
        return etudiants;
    }

    public void setEtudiants(Set<Etudiant> etudiants) {
        this.etudiants = etudiants;
        logger.debug("Setting students: {}", etudiants);
    }



    //////////////////////////////////////////////////////////////////////////////////


    public DetailEquipe getDetailEquipe() {
        logger.debug("Getting etquipe details: {}", detailEquipe);
        return detailEquipe;
    }

    public void setDetailEquipe(DetailEquipe detailEquipe) {
        this.detailEquipe = detailEquipe;
        logger.debug("Setting team details: {}", detailEquipe);
    }

    ////////////////////////////////////////////////////////////////////////

    public Integer getIdEquipe() {
        logger.debug("Getting equipe ID: {}", idEquipe);
        return idEquipe;
    }
    public void setIdEquipe(Integer idEquipe) {
        this.idEquipe = idEquipe;
        logger.debug("Setting team id: {}", idEquipe);
    }

    //////////////////////////////////////////////////////////////////////////

    public String getNomEquipe() {
        logger.debug("Getting equipe name: {}", nomEquipe);
        return nomEquipe;
    }
    public void setNomEquipe(String nomEquipe) {
        this.nomEquipe = nomEquipe;
        logger.debug("Setting team name: {}", nomEquipe);
    }

    ///////////////////////////////////////////////////////////////////////////

    public Niveau getNiveau() {
        logger.debug("Getting equipe niveau: {}", niveau);
        return niveau;
    }
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
        logger.debug("Setting team lvl: {}", niveau);
    }

}
