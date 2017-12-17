package bupt.zby.entity;

public class Pest {
	private int id;
	private String name;
	private String family;
	private String category;
	private String feature;
	private String habit;
	private String damage;
	private String distribution;
	private String prevention;
	private String pictureURL;
	private String classId;
	private int importance;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
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
	public String getFeature() {
		return feature;
	}
	public void setFeature(String feture) {
		this.feature = feture;
	}
	public String getHabit() {
		return habit;
	}
	public void setHabit(String habit) {
		this.habit = habit;
	}
	public String getDamage() {
		return damage;
	}
	public void setDamage(String damage) {
		this.damage = damage;
	}
	public String getDistribution() {
		return distribution;
	}
	public void setDistribution(String distribution) {
		this.distribution = distribution;
	}
	public String getPrevention() {
		return prevention;
	}
	public void setPrevention(String prevention) {
		this.prevention = prevention;
	}
	public String getPictureURL() {
		return pictureURL;
	}
	public void setPictureURL(String pictureURL) {
		this.pictureURL = pictureURL;
	}
	public String getClassId() {
		return classId;
	}
	public void setClassId(String classId) {
		this.classId = classId;
	}
	public int getImportance() {
		return importance;
	}
	public void setImportance(int importance) {
		this.importance = importance;
	}
	@Override
	public String toString() {
		return "Pest [id=" + id + ", name=" + name + ", family=" + family
				+ ", category=" + category + ", feature=" + feature + ", habit="
				+ habit + ", damage=" + damage + ", distribution="
				+ distribution + ", prevention=" + prevention + ", pictureURL="
				+ pictureURL + ", classId=" + classId + ", importance="
				+ importance + "]";
	}
	
	
}
