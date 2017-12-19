package pl.edu.bogdan.training.jsf.bean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

@ManagedBean(name="editableMessage", eager=true)
@SessionScoped
public class EditableMessage {
	private String message="Hello, world!!!";
	private boolean canEdit = false;
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isCanEdit() {
		return canEdit;
	}
	public void setCanEdit(boolean canEdit) {
		this.canEdit = canEdit;
	}
	public String startEditing() {
		canEdit = true;
		return "edit";
	}
	
	public String stopEditing() {
		canEdit = false;
		return "edit";
	}
	
	
}
