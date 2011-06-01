package bojo.teamedit.shared;

import java.io.Serializable;
import java.util.Vector;

public class TeamType implements Serializable{
	
	public int _name;
	public Vector<PlayerType> _playerTypes;
	public int _rerollPrice;
	
	public boolean _apothecary;
	public boolean _igor;
	
	public int _bribePrice;
	public int _chefPrice;

}
