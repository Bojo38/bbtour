package bojo.teamedit.client;

import java.util.Vector;

import bojo.teamedit.shared.SkillType;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("skillType")
public interface SkillTypeEdit extends RemoteService{

	public int addSkillType(String Name, String Accronym);
	public int removeSkillType(String Name);
	public int editSkillType(String Name, String Newname, String Accronym);
	public Vector<SkillType> getSkillTypes();
}
