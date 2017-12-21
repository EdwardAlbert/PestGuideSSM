package bupt.zby.entity;

import java.util.List;

public class PageBean {

	private List<Pest> data; // 当前页数据
	private int firstPage; // 首页
	private int prePage; // 上一页
	private int nextPage; // 下一页
	private int totalPage; // 末页 总页数
	private int currentPage; // 当前页
	private int totalCount; // 总记录数
	private int pageSize; // 每页显示记录数
	private List<String> familyList;// 科目列表
	private List<String> categoryList;// 类别列表

	public List<Pest> getData() {
		return data;
	}

	public void setData(List<Pest> data) {
		this.data = data;
	}

	/**
	 * 首页
	 * 
	 * @return
	 */
	public int getFirstPage() {
		return 1;
	}

	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}

	/**
	 * 上一页 算法：如果当前页是首页，则为1，否则为（当前页-1）
	 * 
	 * @return
	 */
	public int getPrePage() {
		return getCurrentPage() == getFirstPage() ? 1 : getCurrentPage() - 1;
	}

	public void setPrePage(int prePage) {
		this.prePage = prePage;
	}

	/**
	 * 下一页 算法： 如果当前页是末页，则为末页，否则为（当前页+1）
	 * 
	 * @return
	 */
	public int getNextPage() {
		return getCurrentPage() == getTotalPage() ? getTotalPage() : getCurrentPage() + 1;
	}

	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}

	/**
	 * 总页数 算法： 如果 总记录数%每页显示记录数能够整除 ,则为（总记录数/每页显示记录数），否则 （总记录数/每页显示记录数+1）
	 * 
	 * @return
	 */
	public int getTotalPage() {
		return getTotalCount() % getPageSize() == 0 ? getTotalCount() / getPageSize()
				: getTotalCount() / getPageSize() + 1;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public List<String> getFamilyList() {
		return familyList;
	}

	public void setFamilyList(List<String> familyList) {
		this.familyList = familyList;
	}

	public List<String> getCategoryList() {
		return categoryList;
	}

	public void setCategoryList(List<String> categoryList) {
		this.categoryList = categoryList;
	}

	@Override
	public String toString() {
		return "PageBean [firstPage=" + getFirstPage() + ", prePage=" + getPrePage() + ", nextPage=" + getNextPage()
				+ ", totalPage=" + getTotalPage() + ", currentPage=" + getCurrentPage() + ", totalCount="
				+ getTotalCount() + ", pageSize=" + getPageSize() + ", familyList=" + getFamilyList()
				+ ", categoryList=" + getCategoryList() + "]";
	}

}
