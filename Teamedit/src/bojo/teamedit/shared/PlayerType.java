package bojo.teamedit.shared;

import java.io.Serializable;
import java.util.Vector;


public class PlayerType implements Serializable{
	
	
	static final long serialVersionUID = 1L;
	
	public String _position;
	public int _movement;
	public int _strength;
	public int _agility;
	public int _armor;
	public Vector<Skill> _skills;
	public int _cost;
	public Vector<SkillType> _simpleRoll;
	public Vector<SkillType> _doubleRoll;
}
