package ws2;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

	private Team team;

	@BeforeEach
	public void freshNewTeam() {
		team = new Team();
	}

	@Test
	public void addPlayer() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		assertEquals(1, team.getNumberOfPlayers(), "one player added");
	}

	@Test
	public void removePlayer() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		team.removePlayer(44);
		assertEquals(0, team.getNumberOfPlayers(), "removed the only player");
	}

	@Test
	public void removeInexistantPlayer() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		team.removePlayer(11);
		assertEquals(1, team.getNumberOfPlayers(), "removed player with invalid number");
	}

	@Test
	public void addPlayerTwice() {
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		team.addPlayer(new Player(44, "Baggio", "FWD"));
		assertEquals(1, team.getNumberOfPlayers(), "duplicate player not added");
	}

	@Test
	public void fivePlayers() {
		team.addPlayer(new Player(1, "Baggio1", "GK"));
		team.addPlayer(new Player(2, "Baggio2", "DEF"));
		team.addPlayer(new Player(3, "Baggio3", "DEF"));
		team.addPlayer(new Player(4, "Baggio4", "FWD"));
		team.addPlayer(new Player(5, "Baggio5", "FWD"));
		assertEquals(5, team.getNumberOfPlayers(), "added 5 playes to team");
	}
}