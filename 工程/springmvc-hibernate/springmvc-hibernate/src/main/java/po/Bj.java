package po;

import javax.persistence.*;

@Entity
@Table(name = "bj")
public class Bj {
	@Id
	private int id;

	private String bjname;

	public Bj() {
		super();
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getBjname() {
		return bjname;
	}
	public void setBjname(String bjname) {
		this.bjname = bjname;
	}
	public Bj(int id, String bjname) {
		super();
		this.id = id;
		this.bjname = bjname;
	}

	public Bj(int id) {
		super();
		this.id = id;
	}


}
