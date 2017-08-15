package metal.gear.vo;

public class Torrent {

	private int id;
	private String label;
	private String src;
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getSrc() {
		return src;
	}
	public void setSrc(String src) {
		this.src = src;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Torrent(String label, String src) {
		super();
		this.label = label;
		this.src = src;
	}
	@Override
	public String toString() {
		return "Torrent [id=" + id + ", label=" + label + ", src=" + src + "]";
	}
}
