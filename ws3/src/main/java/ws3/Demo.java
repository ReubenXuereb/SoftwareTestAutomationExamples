package ws3;

import ws3.Player.ROLE;

public class Demo {

	public static void main(String[] args) {
		
//		Player p1 = new Player(10, "Player 1 Surname", ROLE.GKP);
//		System.out.println(p1);
//		
//		Player p2 = new Player(11, "Player 2 Surname", ROLE.FWD);
//		System.out.println(p2);
		
//		Team team = new Team();
//		team.addPlayer(p1);
//		System.out.println(team);
		
		Team team = new Team();
		for (int i=1; i<=22; i++) {
			Player p = new Player(i, "Player Surname", ROLE.FWD);
			team.addPlayer(p);
			System.out.println(p);
		}
		

	}

}
