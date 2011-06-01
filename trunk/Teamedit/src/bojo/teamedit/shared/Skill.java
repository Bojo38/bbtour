package bojo.teamedit.shared;

import java.io.Serializable;


public class Skill implements Serializable{
	
	
	static final long serialVersionUID = 1L;
	
	public String _name;
	public SkillType _skillType;
	
	protected Skill(String name, SkillType type)
	{
		_name=name;
		_skillType=type;
	}
	
	public static final Skill KickOffReturn=new Skill("Anticipation",SkillType.GeneralSkill);
	public static final Skill StripBall=new Skill("Arracher le ballon",SkillType.GeneralSkill);
	public static final Skill Block=new Skill("Blocage",SkillType.GeneralSkill);
	public static final Skill SureHands=new Skill("Dext�rit�",SkillType.GeneralSkill);
	public static final Skill Kick=new Skill("Frappe Pr�cise",SkillType.GeneralSkill);
	public static final Skill Frenzy=new Skill("Fr�n�sie",SkillType.GeneralSkill);
	public static final Skill Dauntless=new Skill("Intr�pidit�",SkillType.GeneralSkill);
	public static final Skill DirtyPlayer=new Skill("Joueur Vicieux",SkillType.GeneralSkill);
	public static final Skill Wrestle=new Skill("Lutte",SkillType.GeneralSkill);
	public static final Skill Fend=new Skill("Parade",SkillType.GeneralSkill);
	public static final Skill Shadowing=new Skill("Poursuite",SkillType.GeneralSkill);
	public static final Skill Pro=new Skill("Pro",SkillType.GeneralSkill);
	public static final Skill Tackle=new Skill("Tacle",SkillType.GeneralSkill);
	
	public static final Skill JumpUp=new Skill("Bond",SkillType.AgilitySkill);
	public static final Skill SureFeets=new Skill("Equilibre",SkillType.AgilitySkill);
	public static final Skill Dodge=new Skill("Esquive",SkillType.AgilitySkill);
	public static final Skill SideStep=new Skill("Glissade contr�l�e",SkillType.AgilitySkill);
	public static final Skill DivingCatch=new Skill("Plongeon",SkillType.AgilitySkill);
	public static final Skill Catch=new Skill("R�ception",SkillType.AgilitySkill);
	public static final Skill Leap=new Skill("Saut",SkillType.AgilitySkill);
	public static final Skill SeakyGits=new Skill("Sournois",SkillType.AgilitySkill);
	public static final Skill Sprint=new Skill("Sprint",SkillType.AgilitySkill);
	public static final Skill DivingTackle=new Skill("Tacle Plongeant",SkillType.AgilitySkill);
	
	public static final Skill Leader=new Skill("Chef",SkillType.PassSkill);
	public static final Skill HailMaryPass=new Skill("La Main de Dieu",SkillType.PassSkill);
	public static final Skill SafeThrow=new Skill("Lancer Pr�cis",SkillType.PassSkill);
	public static final Skill NervesOfSteel=new Skill("Nerfs d�Acier",SkillType.PassSkill);
	public static final Skill Pass=new Skill("Passe",SkillType.PassSkill);
	public static final Skill DumpOff=new Skill("Passe Rapide",SkillType.PassSkill);
	public static final Skill Accurate=new Skill("Pr�cision",SkillType.PassSkill);
	
	public static final Skill MultipleBlock=new Skill("Blocage Multiple",SkillType.StrengthSkill);
	public static final Skill MightyBlow=new Skill("Ch�taigne",SkillType.StrengthSkill);
	public static final Skill StrongArm=new Skill("Costaud",SkillType.StrengthSkill);
	public static final Skill ThickSkull=new Skill("Cr�ne Epais",SkillType.StrengthSkill);
	public static final Skill PilingOn=new Skill("Ecrasement",SkillType.StrengthSkill);
	public static final Skill BreakTackle=new Skill("Esquive en Force",SkillType.StrengthSkill);
	public static final Skill Guard=new Skill("Garde",SkillType.StrengthSkill);
	public static final Skill Juggernaut=new Skill("Juggernaut",SkillType.StrengthSkill);
	public static final Skill Grab=new Skill("Projection",SkillType.StrengthSkill);
	public static final Skill StandFirm=new Skill("Stabilit�",SkillType.StrengthSkill);
	
	public static final Skill ExtraArm=new Skill("Bras Suppl�mentaires",SkillType.Mutation);
	public static final Skill Horns=new Skill("Cornes",SkillType.Mutation);
	public static final Skill TwoHeads=new Skill("Deux T�tes",SkillType.Mutation);
	public static final Skill BigHand=new Skill("Main D�mesur�e",SkillType.Mutation);
	public static final Skill Claws=new Skill("Pince / Griffes",SkillType.Mutation);
	public static final Skill DisturbingPresence=new Skill("Pr�sence Perturbante",SkillType.Mutation);
	public static final Skill PrehensileTail=new Skill("Queue Pr�hensile",SkillType.Mutation);
	public static final Skill FoulAppearance=new Skill("R�pulsion",SkillType.Mutation);
	public static final Skill Tentacles=new Skill("Tentacules",SkillType.Mutation);
	public static final Skill VeryLongLegs=new Skill("Tr�s Longues Jambes",SkillType.Mutation);
	
	public static final Skill WildAnimal=new Skill("Animal Sauvage",SkillType.ExtraoridnarySkill);
	public static final Skill Animosity=new Skill("Animosit�",SkillType.ExtraoridnarySkill);
	public static final Skill SecreatWeapon=new Skill("Arme Secr�te",SkillType.ExtraoridnarySkill);
	public static final Skill Bomber=new Skill("Bombardier",SkillType.ExtraoridnarySkill);
	public static final Skill BoneHead=new Skill("Cerveau Lent",SkillType.ExtraoridnarySkill);
	public static final Skill BallAndChain=new Skill("Cha�ne & Boulet",SkillType.ExtraoridnarySkill);
	public static final Skill Decay=new Skill("D�composition",SkillType.ExtraoridnarySkill);
	public static final Skill ReallyStupid=new Skill("Gros D�bile",SkillType.ExtraoridnarySkill);
	public static final Skill FanFavorite=new Skill("Idole des Foules",SkillType.ExtraoridnarySkill);
	public static final Skill NoArm=new Skill("Manchot",SkillType.ExtraoridnarySkill);
	public static final Skill ThrowTeammate=new Skill("Lancer un Co�quipier",SkillType.ExtraoridnarySkill);
	public static final Skill Titchy=new Skill("Microbe",SkillType.ExtraoridnarySkill);
	public static final Skill Stunty=new Skill("Minus",SkillType.ExtraoridnarySkill);
	public static final Skill Stakes=new Skill("Pieux",SkillType.ExtraoridnarySkill);
	public static final Skill RightStuff=new Skill("Poids Plume",SkillType.ExtraoridnarySkill);
	public static final Skill Stab=new Skill("Poignard",SkillType.ExtraoridnarySkill);
	public static final Skill NurglesRot=new Skill("Pourriture de Nurgle",SkillType.ExtraoridnarySkill);
	public static final Skill TakeRoot=new Skill("Prendre Racine",SkillType.ExtraoridnarySkill);
	public static final Skill HypnoticGaze=new Skill("Regard Hypnotique",SkillType.ExtraoridnarySkill);
	public static final Skill Regeneration=new Skill("R�g�n�ration",SkillType.ExtraoridnarySkill);
	public static final Skill BloodLust=new Skill("Soif de Sang",SkillType.ExtraoridnarySkill);
	public static final Skill Loner=new Skill("Solitaire",SkillType.ExtraoridnarySkill);
	public static final Skill AlwaysHungry=new Skill("Toujours Affam�",SkillType.ExtraoridnarySkill);
	public static final Skill Chainsaw=new Skill("Tron�onneuse",SkillType.ExtraoridnarySkill);
	
	public static final Skill Movement=new Skill("+1 M",SkillType.Ehancements);
	public static final Skill Strength=new Skill("+1 S",SkillType.Ehancements);
	public static final Skill Agility=new Skill("+1 Ag",SkillType.Ehancements);
	public static final Skill Armor=new Skill("+1 Ar",SkillType.Ehancements);
}
