package bupt.zby.entity;

public class PestQuery {

	private String name;
	private String family;
	private String category;
	private String pestId;
	private String currentPage;
	private String pageSize;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getFamily() {
		return family;
	}

	public void setFamily(String family) {
		this.family = family;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getPestId() {
		return pestId;
	}

	public void setPestId(String pestId) {
		this.pestId = pestId;
	}

	public String getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(String currentPage) {
		this.currentPage = currentPage;
	}

	public String getPageSize() {
		return pageSize;
	}

	public void setPageSize(String pageSize) {
		this.pageSize = pageSize;
	}

	@Override
	public String toString() {
		return "PestQuery [name=" + name + ", family=" + family + ", category=" + category + ", pestId=" + pestId
				+ ", currentPage=" + currentPage + ", pageSize=" + pageSize + "]";
	}

}
