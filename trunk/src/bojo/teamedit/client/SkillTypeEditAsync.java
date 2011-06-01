package bojo.teamedit.client;

import java.util.Vector;

import bojo.teamedit.shared.SkillType;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface SkillTypeEditAsync {

	void addSkillType(String Name, String Accronym,
			AsyncCallback<Integer> callback);

	void removeSkillType(String Name, AsyncCallback<Integer> callback);

	void editSkillType(String Name, String Newname, String Accronym,
			AsyncCallback<Integer> callback);

	void getSkillTypes(AsyncCallback<Vector<SkillType>> callback);
}
