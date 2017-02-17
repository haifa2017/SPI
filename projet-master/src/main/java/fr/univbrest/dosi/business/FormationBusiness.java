package fr.univbrest.dosi.business;

import java.util.List;

import fr.univbrest.dosi.bean.Formation;
import fr.univbrest.dosi.model.FormationComplete;

public interface FormationBusiness {

	FormationComplete ajouterFormation(FormationComplete formation);
	
	List<FormationComplete> recupererFormations();
	
	void supprimerFormation(String codeFormation);

	FormationComplete recupererFormationParLeCode(String codeFormation);
}
