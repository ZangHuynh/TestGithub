package entity;

import java.util.Objects;

public class NhanVien {
	private String manNV;
	private String ho;
	private String ten;
	private int tuoi;
	private boolean phai;
	private Double tienLuong;
	private PhongBan pBan;
	
	public NhanVien(String manNV, String ho, String ten, int tuoi, boolean phai, Double tienLuong, PhongBan pBan) {
		super();
		this.manNV = manNV;
		this.ho = ho;
		this.ten = ten;
		this.tuoi = tuoi;
		this.phai = phai;
		this.tienLuong = tienLuong;
		this.pBan = pBan;
	}

	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NhanVien(String manNV) {
		super();
		this.manNV = manNV;
	}

	public String getManNV() {
		return manNV;
	}

	public void setManNV(String manNV) {
		this.manNV = manNV;
	}

	public String getHo() {
		return ho;
	}

	public void setHo(String ho) {
		this.ho = ho;
	}

	public String getTen() {
		return ten;
	}

	public void setTen(String ten) {
		this.ten = ten;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public boolean isPhai() {
		return phai;
	}

	public void setPhai(boolean phai) {
		this.phai = phai;
	}

	public Double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(Double tienLuong) {
		this.tienLuong = tienLuong;
	}

	public PhongBan getpBan() {
		return pBan;
	}

	public void setpBan(PhongBan pBan) {
		this.pBan = pBan;
	}

	@Override
	public int hashCode() {
		return Objects.hash(manNV);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NhanVien other = (NhanVien) obj;
		return Objects.equals(manNV, other.manNV);
	}

	@Override
	public String toString() {
		return "NhanVien [manNV=" + manNV + ", ho=" + ho + ", ten=" + ten + ", tuoi=" + tuoi + ", phai=" + phai
				+ ", tienLuong=" + tienLuong + ", pBan=" + pBan + "]";
	}
}
