package bojo.teamedit.shared;

import java.io.Serializable;
import java.util.Vector;


public class Player implements Serializable{
	
	static final long serialVersionUID = 1L;
	
	public String _name;
	public PlayerType _playerType;
	public Vector<Skill> _additionalSkills;
	public int _additionalCost;

}
