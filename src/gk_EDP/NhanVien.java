package gk_EDP;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{
	private String maNV;
	private String hoNV;
	private String tenNV;
	private int tuoi;
	private boolean phai;
	private Double tienLuong;
	public String getMaNV() {
		return maNV;
	}
	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}
	public String getHoNV() {
		return hoNV;
	}
	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}
	public String getTenNV() {
		return tenNV;
	}
	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
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
	public NhanVien(String maNV, String hoNV, String tenNV, int tuoi, boolean phai, Double tienLuong) {
		super();
		this.maNV = maNV;
		this.hoNV = hoNV;
		this.tenNV = tenNV;
		this.tuoi = tuoi;
		this.phai = phai;
		this.tienLuong = tienLuong;
	}
	public NhanVien(String maNV) {
		super();
		this.maNV = maNV;
	}
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		return Objects.hash(maNV);
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
		return Objects.equals(maNV, other.maNV);
	}
	@Override
	public String toString() {
		return "NhanVien [maNV=" + maNV + ", hoNV=" + hoNV + ", tenNV=" + tenNV + ", tuoi=" + tuoi + ", phai=" + phai
				+ ", tienLuong=" + tienLuong + "]";
	}
}
