package vo;

public class RecordVo {
	private String id;
	private int zero;
	private int one;
	private int two;
	public RecordVo() {
		// TODO Auto-generated constructor stub
	}
	public RecordVo(String id, int zero, int one, int two) {
		super();
		this.id = id;
		this.zero = zero;
		this.one = one;
		this.two = two;
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getZero() {
		return zero;
	}
	public void setZero(int zero) {
		this.zero = zero;
	}
	public int getOne() {
		return one;
	}
	public void setOne(int one) {
		this.one = one;
	}
	public int getTwo() {
		return two;
	}
	public void setTwo(int two) {
		this.two = two;
	}
	
}
