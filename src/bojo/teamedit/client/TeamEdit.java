package bojo.teamedit.client;

import bojo.teamedit.shared.FieldVerifier;
import bojo.teamedit.shared.SkillType;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyUpEvent;
import com.google.gwt.event.dom.client.KeyUpHandler;
import com.google.gwt.user.client.rpc.AsyncCallback;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTML;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.HasHorizontalAlignment;
import com.google.gwt.user.client.ui.HasVerticalAlignment;
import com.google.gwt.user.cellview.client.CellTable;
import com.google.gwt.user.cellview.client.Column;
import com.google.gwt.cell.client.NumberCell;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.cell.client.SelectionCell;
import java.util.ArrayList;
import java.util.Vector;

import com.google.gwt.cell.client.CheckboxCell;
import com.google.gwt.user.client.ui.TabPanel;
import com.google.gwt.user.client.ui.ListBox;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class TeamEdit implements EntryPoint {
	/**
	 * The message displayed to the user when the server cannot be reached or
	 * returns an error.
	 */
	private static final String SERVER_ERROR = "An error occurred while "
			+ "attempting to contact the server. Please check your network "
			+ "connection and try again.";

	/**
	 * Create a remote service proxy to talk to the server-side Greeting
	 * service.
	 */
	private final GreetingServiceAsync greetingService = GWT
			.create(GreetingService.class);

	private final SkillTypeEditAsync skillTypesEdit = GWT
			.create(SkillTypeEdit.class);

	private ListBox listSkillTypes = new ListBox();

	private Vector<SkillType> _skillTypes;
	private Label lblError = new Label("");

	private final DialogBox _dlgSkillList = new DialogBox();
	final Button btnRemoveSkillType = new Button("Retirer");;
	final Button btnEditSkillType=new Button("Editer");
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {

		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get();
		rootPanel.setSize("800", "600");

		DockPanel dockPanel_4 = new DockPanel();
		rootPanel.add(dockPanel_4);

		TabPanel tabPanel = new TabPanel();
		dockPanel_4.add(tabPanel, DockPanel.CENTER);
		tabPanel.setSize("800", "600");

		DockPanel dockPanel = new DockPanel();
		tabPanel.add(dockPanel, "Edition d'\u00E9quipe", false);
		dockPanel.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		dockPanel.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		dockPanel.setSize("5cm", "3cm");

		CellTable<String> cellTable = new CellTable<String>();
		dockPanel.add(cellTable, DockPanel.CENTER);

		Column<String, Number> cNumber = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cNumber.setHorizontalAlignment(HasHorizontalAlignment.ALIGN_CENTER);
		cNumber.setVerticalAlignment(HasVerticalAlignment.ALIGN_MIDDLE);
		cellTable.addColumn(cNumber, "#");
		cellTable.setColumnWidth(cNumber, "34px");

		TextColumn<String> cName = new TextColumn<String>() {
			@Override
			public String getValue(String object) {
				return object.toString();
			}
		};
		cellTable.addColumn(cName, "Nom");
		cellTable.setColumnWidth(cName, "111px");

		Column<String, String> cPosition = new Column<String, String>(
				new SelectionCell(new ArrayList<String>())) {
			@Override
			public String getValue(String object) {
				return (String) null;
			}
		};
		cellTable.addColumn(cPosition, "Position");
		cellTable.setColumnWidth(cPosition, "75px");

		Column<String, Number> cMovement = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cMovement, "M");
		cellTable.setColumnWidth(cMovement, "34px");

		Column<String, Number> cStrength = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cStrength, "F");

		Column<String, Number> cAgility = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cAgility, "Ag");

		Column<String, Number> cArmor = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cArmor, "Ar");

		TextColumn<String> cSkills = new TextColumn<String>() {
			@Override
			public String getValue(String object) {
				return object.toString();
			}
		};
		cellTable.addColumn(cSkills, "Comp\u00E9tences");

		Column<String, Boolean> cMNG = new Column<String, Boolean>(
				new CheckboxCell()) {
			@Override
			public Boolean getValue(String object) {
				return (Boolean) null;
			}
		};
		cellTable.addColumn(cMNG, "Bless");

		Column<String, Number> cCompletions = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cCompletions, "R\u00E9u");

		Column<String, Number> cInterceptions = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cInterceptions, "Int");

		Column<String, Number> cInjuries = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cInjuries, "Sor");

		Column<String, Number> cTouchdowns = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(cTouchdowns, "Td");

		Column<String, Number> sMVP = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(sMVP, "JPV");

		Column<String, Number> sXP = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(sXP, "XP");

		Column<String, Number> sValue = new Column<String, Number>(
				new NumberCell()) {
			@Override
			public Number getValue(String object) {
				return (Number) null;
			}
		};
		cellTable.addColumn(sValue, "Prix");

		DockPanel dockPanel_1 = new DockPanel();
		tabPanel.add(dockPanel_1, "Edition de comp\u00E9tences", false);
		dockPanel_1.setSize("568px", "413px");

		DockPanel dockPanel_2 = new DockPanel();
		dockPanel_2.setSpacing(5);
		dockPanel_1.add(dockPanel_2, DockPanel.WEST);
		dockPanel_2.setSize("256px", "176px");

		Label lblNewLabel = new Label("Type de comp\u00E9tences");
		dockPanel_2.add(lblNewLabel, DockPanel.NORTH);

		VerticalPanel verticalPanel = new VerticalPanel();
		dockPanel_2.add(verticalPanel, DockPanel.WEST);

		Button btnAddSkillType = new Button("Ajouter");
		btnAddSkillType.addClickHandler(new addSkillTypeHandler());
		verticalPanel.add(btnAddSkillType);
		
		btnRemoveSkillType.setEnabled(false);
		btnRemoveSkillType.addClickHandler(new delSkillTypeHandler());
		verticalPanel.add(btnRemoveSkillType);
		btnEditSkillType.addClickHandler(new editSkillTypeHandler());

		btnEditSkillType.setEnabled(false);
		verticalPanel.add(btnEditSkillType);
		listSkillTypes.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				if (listSkillTypes.getSelectedIndex()>0)
				{
					btnRemoveSkillType.setEnabled(true);
					btnEditSkillType.setEnabled(true);
				}
				else
				{
					btnRemoveSkillType.setEnabled(false);
					btnEditSkillType.setEnabled(false);
				}
			}
		});

		dockPanel_2.add(listSkillTypes, DockPanel.CENTER);
		listSkillTypes.setSize("154px", "174px");
		listSkillTypes.setVisibleItemCount(5);

		DockPanel dockPanel_3 = new DockPanel();
		dockPanel_3.setSpacing(5);
		dockPanel_1.add(dockPanel_3, DockPanel.EAST);
		dockPanel_3.setSize("250px", "207px");

		ListBox listSkills = new ListBox();
		listSkills.setVisibleItemCount(5);
		dockPanel_3.add(listSkills, DockPanel.CENTER);
		listSkills.setSize("150px", "173px");

		Label lblNewLabel_1 = new Label("Com\u00E9ptences");
		dockPanel_3.add(lblNewLabel_1, DockPanel.NORTH);

		VerticalPanel verticalPanel_1 = new VerticalPanel();
		dockPanel_3.add(verticalPanel_1, DockPanel.WEST);

		Button btnAddSkill = new Button("Ajouter");
		verticalPanel_1.add(btnAddSkill);

		Button btnRemoveSkill = new Button("Retirer");
		verticalPanel_1.add(btnRemoveSkill);

		Button btnEditSkill = new Button("Editer");
		verticalPanel_1.add(btnEditSkill);

		dockPanel_4.add(lblError, DockPanel.NORTH);
		lblError.setVisible(false);

		// Create the popup dialog box
		final DialogBox dialogBox = new DialogBox();
		dialogBox.setText("Remote Procedure Call");
		dialogBox.setAnimationEnabled(true);
		final Button closeButton = new Button("Close");
		// We can set the id of a widget by accessing its Element
		closeButton.getElement().setId("closeButton");
		final Label textToServerLabel = new Label();
		final HTML serverResponseLabel = new HTML();
		VerticalPanel dialogVPanel = new VerticalPanel();
		dialogVPanel.addStyleName("dialogVPanel");
		dialogVPanel.add(new HTML("<b>Sending name to the server:</b>"));
		dialogVPanel.add(textToServerLabel);
		dialogVPanel.add(new HTML("<br><b>Server replies:</b>"));
		dialogVPanel.add(serverResponseLabel);
		dialogVPanel.setHorizontalAlignment(VerticalPanel.ALIGN_RIGHT);
		dialogVPanel.add(closeButton);
		dialogBox.setWidget(dialogVPanel);

		// Add a handler to close the DialogBox
		closeButton.addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				dialogBox.hide();
				// sendButton.setEnabled(true);
				// sendButton.setFocus(true);
			}
		});

		// Create a handler for the sendButton and nameField
		class MyHandler implements ClickHandler, KeyUpHandler {
			/**
			 * Fired when the user clicks on the sendButton.
			 */
			public void onClick(ClickEvent event) {
				sendNameToServer();
			}

			/**
			 * Fired when the user types in the nameField.
			 */
			public void onKeyUp(KeyUpEvent event) {
				if (event.getNativeKeyCode() == KeyCodes.KEY_ENTER) {
					sendNameToServer();
				}
			}

			/**
			 * Send the name from the nameField to the server and wait for a
			 * response.
			 */
			private void sendNameToServer() {
				// First, we validate the input.
				/*
				 * errorLabel.setText(""); String textToServer =
				 * nameField.getText(); if
				 * (!FieldVerifier.isValidName(textToServer)) {
				 * errorLabel.setText("Please enter at least four characters");
				 * return; }
				 * 
				 * // Then, we send the input to the server.
				 * sendButton.setEnabled(false);
				 * textToServerLabel.setText(textToServer);
				 * serverResponseLabel.setText("");
				 * greetingService.greetServer(textToServer, new
				 * AsyncCallback<String>() { public void onFailure(Throwable
				 * caught) { // Show the RPC error message to the user dialogBox
				 * .setText("Remote Procedure Call - Failure");
				 * serverResponseLabel
				 * .addStyleName("serverResponseLabelError");
				 * serverResponseLabel.setHTML(SERVER_ERROR);
				 * dialogBox.center(); closeButton.setFocus(true); }
				 * 
				 * public void onSuccess(String result) {
				 * dialogBox.setText("Remote Procedure Call");
				 * serverResponseLabel
				 * .removeStyleName("serverResponseLabelError");
				 * serverResponseLabel.setHTML(result); dialogBox.center();
				 * closeButton.setFocus(true); } });
				 */
			}
		}

		// Add a handler to send the name to the server
		// MyHandler handler = new MyHandler();

		loadSkillTypes();
		update();
	}

	void update() {
		listSkillTypes.clear();
		if (_skillTypes != null) {
			for (int i = 0; i < _skillTypes.size(); i++) {
				listSkillTypes.addItem(_skillTypes.get(i)._name);
			}
		}		
	}

	void loadSkillTypes() {
		listSkillTypes.clear();
		AsyncCallback<Vector<SkillType>> callback = new AsyncCallback<Vector<SkillType>>() {
			public void onFailure(Throwable caught) {
				lblError.setText("Error loading SkillTypes: "
						+ caught.getMessage());
				lblError.setVisible(true);
			}

			public void onSuccess(Vector<SkillType> result) {

				_skillTypes = result;
				update();
			}
		};
		skillTypesEdit.getSkillTypes(callback);
	}

	private class addSkillTypeHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			final String Name = "Undefined";
			final String Accronym = "U";

			_dlgSkillList.setModal(true);
			_dlgSkillList.setText("Entrer un nom et un accronyme");

			DockPanel panel = new DockPanel();

			Label lblName = new Label("Nom: ");
			final TextBox txtName = new TextBox();
			txtName.setText(Name);

			Label lblAccronym = new Label("Accronyme: ");
			final TextBox txtAccronym = new TextBox();
			txtAccronym.setText(Accronym);

			FlowPanel npanel = new FlowPanel();

			npanel.add(lblName);
			npanel.add(txtName);
			panel.add(npanel, DockPanel.NORTH);

			FlowPanel cpanel = new FlowPanel();

			cpanel.add(lblAccronym);
			cpanel.add(txtAccronym);
			panel.add(cpanel, DockPanel.NORTH);

			Button ok = new Button("OK");
			ok.addClickHandler(new ClickHandler() {

				@Override
				public void onClick(ClickEvent event) {
					AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
						public void onFailure(Throwable caught) {
							lblError.setText("Error adding SkillType: "
									+ caught.getMessage());
							lblError.setVisible(true);
						}

						public void onSuccess(Integer result) {
							loadSkillTypes();
							update();
						}
					};

					skillTypesEdit.addSkillType(txtName.getText(),
							txtAccronym.getText(), callback);
					_dlgSkillList.hide();
				}
			});
			/*
			 * FlowPanel spanel=new FlowPanel(); spanel.set spanel.add(ok);
			 */

			panel.add(ok, DockPanel.SOUTH);

			_dlgSkillList.setWidget(panel);
			_dlgSkillList.center();
			_dlgSkillList.show();
		}
	}

	private class editSkillTypeHandler implements ClickHandler {
		public void onClick(ClickEvent event) {

			int index = listSkillTypes.getSelectedIndex();

			if (index > 0) {
				final String Name = _skillTypes.get(index)._name;
				final String Accronym = _skillTypes.get(index)._accronym;

				_dlgSkillList.setModal(true);
				_dlgSkillList.setText("Editer le nom et l'accronyme");

				DockPanel panel = new DockPanel();

				Label lblName = new Label("Nom: ");
				final TextBox txtName = new TextBox();
				txtName.setText(Name);

				Label lblAccronym = new Label("Accronyme: ");
				final TextBox txtAccronym = new TextBox();
				txtAccronym.setText(Accronym);

				FlowPanel npanel = new FlowPanel();

				npanel.add(lblName);
				npanel.add(txtName);
				panel.add(npanel, DockPanel.NORTH);

				FlowPanel cpanel = new FlowPanel();

				cpanel.add(lblAccronym);
				cpanel.add(txtAccronym);
				panel.add(cpanel, DockPanel.NORTH);

				Button ok = new Button("OK");
				ok.addClickHandler(new ClickHandler() {

					@Override
					public void onClick(ClickEvent event) {
						AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
							public void onFailure(Throwable caught) {
								lblError.setText("Error editing SkillType: "
										+ caught.getMessage());
								lblError.setVisible(true);
							}

							public void onSuccess(Integer result) {
								loadSkillTypes();
								update();
							}
						};

						skillTypesEdit.editSkillType(Name, txtName.getText(),
								txtAccronym.getText(), callback);
						_dlgSkillList.hide();
					}
				});
				/*
				 * FlowPanel spanel=new FlowPanel(); spanel.set spanel.add(ok);
				 */

				panel.add(ok, DockPanel.SOUTH);

				_dlgSkillList.setWidget(panel);
				_dlgSkillList.center();
				_dlgSkillList.show();
			}
		}
	}

	private class delSkillTypeHandler implements ClickHandler {
		public void onClick(ClickEvent event) {
			AsyncCallback<Integer> callback = new AsyncCallback<Integer>() {
				public void onFailure(Throwable caught) {
					lblError.setText("Error removing SkillType: "
							+ caught.getMessage());
					lblError.setVisible(true);
				}

				public void onSuccess(Integer result) {
					loadSkillTypes();
					update();
				}
			};
			int index = listSkillTypes.getSelectedIndex();
			if (index > 0) {
				skillTypesEdit.removeSkillType(
						listSkillTypes.getItemText(index), callback);
				_dlgSkillList.hide();
			}

		}

	}
}
