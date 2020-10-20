
public class Question {
	
	private Integer accepted_answer_id;
	private String[] tags;
	private Boolean is_answered;
	private ShallowUser owner;
	private String title;
	private String link;
	public Integer getAccepted_answer_id() {
		return accepted_answer_id;
	}
	public void setAccepted_answer_id(Integer accepted_answer_id) {
		this.accepted_answer_id = accepted_answer_id;
	}
	public String[] getTags() {
		return tags;
	}
	public void setTags(String[] tags) {
		this.tags = tags;
	}	
	public Boolean getIs_answered() {
		return is_answered;
	}
	public void setIs_answered(Boolean is_answered) {
		this.is_answered = is_answered;
	}
	public ShallowUser getOwner() {
		return owner;
	}
	public void setOwner(ShallowUser owner) {
		this.owner = owner;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getLink() {
		return link;
	}
	public void setLink(String link) {
		this.link = link;
	}
}
