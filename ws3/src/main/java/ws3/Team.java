package ws3;

import java.util.ArrayList;
import java.util.List;

import ws3.Player.ROLE;

public class Team {

	private List<Player> players;
	public static final int MAX_PLAYERS = 21;
	
	public Team() {
		this.players = new ArrayList<>();
	}

	public void addPlayer(Player p) {
		if (isTeamFull())
			throw new TeamFullException("Cannot add this because team is full");
		
		if (findPlayer(p.getNumber()) == null)
			this.players.add(p);
	}

	private Player findPlayer(int num) {
		for (Player player : players) {
			if (player.getNumber() == num)
				return player;
		}
		return null;
	}

	public void removePlayer(int num) {
		Player toRemove = findPlayer(num);
		if (toRemove != null) {
			players.remove(toRemove);
		}
	}
	
	public int getNumberOfPlayers() {
		return this.players.size();
	}
	
	public boolean canPlayGame() {
		int keepers = 0;
		int others = 0;
		
		for (Player p : players) {
			if (p.getRole() == ROLE.GKP)
				keepers++;
			else
				others++;
		}
		
		if (keepers >= 1 && others >= 10)
			return true;
		
		return false;
	}
	
	public boolean isTeamFull() {
		return players.size() >= MAX_PLAYERS;
	}


	@Override
	public String toString() {
		return "Team [players=" + players + "]";
	}	
}
