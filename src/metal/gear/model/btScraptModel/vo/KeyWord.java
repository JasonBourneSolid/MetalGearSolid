package metal.gear.model.btScraptModel.vo;

public class KeyWord {
	public KeyWord(){
		
	}
	
	public KeyWord(int id, String actor, String code) {
		super();
		this.id = id;
		this.actor = actor;
		this.code = code;
	}
	private int id;
	private String actor = "";
	private String code = "";
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
}
