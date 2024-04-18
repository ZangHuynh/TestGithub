package entity;

import java.util.Objects;

public class LopHoc {
	private String maLop;
	private String tenLop;
	
	public String getMaLop() {
		return maLop;
	}
	
	public void setMaLop(String maLop) {
		this.maLop = maLop;
	}
	
	public String getTenLop() {
		return tenLop;
	}
	
	public void setTenLop(String tenLop) {
		this.tenLop = tenLop;
	}

	public LopHoc(String maLop, String tenLop) {
		super();
		this.maLop = maLop;
		this.tenLop = tenLop;
	}

	public LopHoc(String maLop) {
		super();
		this.maLop = maLop;
	}

	public LopHoc() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(maLop);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LopHoc other = (LopHoc) obj;
		return Objects.equals(maLop, other.maLop);
	}

	@Override
	public String toString() {
		return "LopHoc [maLop=" + maLop + ", tenLop=" + tenLop + "]";
	}
	
}
