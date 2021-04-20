package ws3;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import ws3.Player.ROLE;

public class TeamTest {

	private Team team;

	@BeforeEach
	public void freshNewTeam() {
		team = new Team();
	}

	@Test
	public void addPlayer() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		assertEquals(1, team.getNumberOfPlayers(), "one player added");
	}

	@Test
	public void removePlayer() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		team.removePlayer(44);
		assertEquals(0, team.getNumberOfPlayers(), "removed the only player");
	}

	@Test
	public void removeInexistantPlayer() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		team.removePlayer(11);
		assertEquals(1, team.getNumberOfPlayers(), "removed player with invalid number");
	}

	@Test
	public void addPlayerTwice() {
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		team.addPlayer(new Player(44, "Baggio", ROLE.FWD));
		assertEquals(1, team.getNumberOfPlayers(), "duplicate player not added");
	}

	@Test
	public void fivePlayers() {
		team.addPlayer(new Player(1, "Baggio1", ROLE.GKP));
		team.addPlayer(new Player(2, "Baggio2", ROLE.DEF));
		team.addPlayer(new Player(3, "Baggio3", ROLE.DEF));
		team.addPlayer(new Player(4, "Baggio4", ROLE.FWD));
		team.addPlayer(new Player(5, "Baggio5", ROLE.FWD));
		assertEquals(5, team.getNumberOfPlayers(), "added 5 playes to team");
	}
}