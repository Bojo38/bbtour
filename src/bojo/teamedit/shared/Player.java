package bojo.teamedit.shared;

import java.io.Serializable;
import java.util.Vector;


public class Player implements Serializable{
	
	public String _name;
	public PlayerType _playerType;
	public Vector<Skill> _additionalSkills;
	public int _additionalCost;

}
