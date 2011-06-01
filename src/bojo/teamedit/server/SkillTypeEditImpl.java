package bojo.teamedit.server;

import java.util.List;
import java.util.Vector;

import bojo.teamedit.client.SkillTypeEdit;
import bojo.teamedit.shared.SkillType;

import com.google.appengine.api.datastore.DatastoreService;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.FetchOptions;
import com.google.appengine.api.datastore.Key;
import com.google.appengine.api.datastore.KeyFactory;
import com.google.appengine.api.datastore.Query;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;

public class SkillTypeEditImpl extends RemoteServiceServlet implements
		SkillTypeEdit {

	static final long serialVersionUID = 1L;

	DatastoreService datastore = DatastoreServiceFactory.getDatastoreService();

	// Key SkillTypeKey = KeyFactory.createKey("SkillType", "Default");

	@Override
	public int addSkillType(String Name, String Accronym)
			throws IllegalArgumentException {

		Entity skillType = new Entity("SkillType");
		skillType.setProperty("Name", Name);
		skillType.setProperty("Accronym", Accronym);

		Vector<SkillType> collection = getSkillTypes();

		/* Check unicity */
		boolean found = false;
		for (int i = 0; i < collection.size(); i++) {
			if (collection.get(i)._name.equals(Name)) {
				found = true;
				break;
			}
		}
		if (!found)
			datastore.put(skillType);

		collection = getSkillTypes();
		return collection.size();
	}

	public int removeSkillType(String Name) throws IllegalArgumentException {

		Query query = new Query("SkillType");
		Vector<SkillType> datas = new Vector<SkillType>();
		List<Entity> entities = datastore.prepare(query).asList(
				FetchOptions.Builder.withDefaults());

		for (Entity entity : entities) {

			if (Name.equals((String) entity.getProperty("Name"))) {
				Key key = entity.getKey();
				datastore.delete(key);
				break;
			}
		}

		Vector<SkillType> collection = getSkillTypes();
		return collection.size();
	}

	public int editSkillType(String Name, String Newname, String Accronym)
			throws IllegalArgumentException {

		if (!Name.equals("") && !Newname.equals("")) {
			Query query = new Query("SkillType");
			Vector<SkillType> datas = new Vector<SkillType>();
			List<Entity> entities = datastore.prepare(query).asList(
					FetchOptions.Builder.withDefaults());

			for (Entity entity : entities) {

				if (Name.equals((String) entity.getProperty("Name"))) {
					Key key=entity.getKey();
					entity.setProperty("Name", Newname);
					entity.setProperty("Accronym", Accronym);
					datastore.delete(key);
					datastore.put(entity);
					break;
				}
			}
		}
		Vector<SkillType> collection = getSkillTypes();
		return collection.size();
	}

	public Vector<SkillType> getSkillTypes() throws IllegalArgumentException {
		Query query = new Query("SkillType");
		Vector<SkillType> datas = new Vector<SkillType>();
		List<Entity> entities = datastore.prepare(query).asList(
				FetchOptions.Builder.withDefaults());
		for (Entity entity : entities) {
			SkillType data = new SkillType();
			data.set_name((String) entity.getProperty("Name"));
			data.set_accronym((String) entity.getProperty("Accronym"));
			if (!data._name.equals("")) {
				datas.add(data);
			}
		}
		return datas;
	}

}
