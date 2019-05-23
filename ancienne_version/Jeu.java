import java.util.List;

/**
 * 
 * @author theo
 *Interface de Jeu, chaque jeu ayant ses propres règles
 */
public interface Jeu {
	/*
	 * Retourne les stats de bases du jeu
	 */
	List<Stat> getStats();
	List<Competence> getCompetences();
}
