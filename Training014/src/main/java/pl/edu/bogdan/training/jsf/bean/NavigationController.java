package pl.edu.bogdan.training.jsf.bean;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

@SuppressWarnings("serial")
@ManagedBean(name = "navigationController", eager = true)
@RequestScoped
public class NavigationController implements Serializable {
	
	@ManagedProperty(value = "#{param.pageId}")
	private String pageId;

	public String moveToPage1() {
		return "example_page_1";
	}

	public String showPage() {
		if (pageId == null) {
			return "navigation2";
		}

		if (pageId.equals("1")) {
			return "example_page_1";
		} else if (pageId.equals("2")) {
			return "example_page_2";
		} else {
			return "navigation2";
		}
	}

	public String getPageId() {
		return pageId;
	}

	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	
	
}
