package fr.univbrest.dosi.business;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.convertisseur.MappeurDeFormation;
import fr.univbrest.dosi.exceptions.EntiteeNonTrouveeException;
import fr.univbrest.dosi.model.FormationComplete;
import fr.univbrest.dosi.repositories.FormationRepository;

@Component
public class FormationBusinessJPA implements FormationBusiness {
	
	private FormationRepository entrepotDeFormation;
	private MappeurDeFormation mappeurFormations;

	@Autowired
	FormationBusinessJPA(FormationRepository entrepotDeFormation){
		this.entrepotDeFormation = entrepotDeFormation;
		mappeurFormations = MappeurDeFormation.INSTANCE;
	}

	@Override
	public FormationComplete ajouterFormation(FormationComplete formationComplete) {
		Formation formation = mappeurFormations.formationCompleteEnFormation(formationComplete);
		
		Formation formationEnregistree =  this.entrepotDeFormation.save(formation);
		
		return mappeurFormations.formationEnFormationComplete(formationEnregistree);
		
	}

	@Override
	public List<FormationComplete> recupererFormations() {
		List<Formation> formations = (List<Formation>) this.entrepotDeFormation.findAll();
		
		return formations.stream()
			.map(mappeurFormations::formationEnFormationComplete)
			.collect(Collectors.toList());	
	}

	@Override
	public void supprimerFormation(String codeFormation) {
		Optional<Formation> formation = Optional.ofNullable(this.entrepotDeFormation.findByCodeFormation(codeFormation));
		
		Formation formationASupprimer = formation.orElseThrow(
				() -> new  EntiteeNonTrouveeException("Impossible de trouver l'entitee a  supprimer: " + codeFormation)
		);
		
		this.entrepotDeFormation.delete(formationASupprimer);
	}

	@Override
	public FormationComplete recupererFormationParLeCode(String codeFormation) {
		
		Formation formationTrouvee = this.entrepotDeFormation.findByCodeFormation(codeFormation);
		
		return mappeurFormations.formationEnFormationComplete(formationTrouvee);
	}
	
	
}
