package bojo.teamedit.shared;

import java.io.Serializable;


public class SkillType implements Serializable{
	
	public String _name;
	public String _accronym;
	
	static final long serialVersionUID = 1L;
	
	public SkillType()
	{
		_name="Undefined";
		_accronym="U";
	}
	
	public SkillType(String Name, String Accronym)
	{
		_name=Name;
		_accronym=Accronym;
	}
	
	public void set_name(String name)
	{
		_name=name;
	}
	
	public String get_name()
	{
		return _name;
	}
	
	public void set_accronym(String accronym)
	{
		_accronym=accronym;
	}
	
	public String get_accronym()
	{
		return _accronym;
	}
	
	public static final SkillType GeneralSkill=new SkillType("General","G");
	public static final SkillType StrengthSkill=new SkillType("Force","F");
	public static final SkillType AgilitySkill=new SkillType("Agilité","A");
	public static final SkillType PassSkill=new SkillType("Passe","P");
	public static final SkillType Mutation=new SkillType("Mutation","M");
	public static final SkillType ExtraoridnarySkill=new SkillType("Extraordinaire","E");
	public static final SkillType Ehancements=new SkillType("Augmentations","C");

}
