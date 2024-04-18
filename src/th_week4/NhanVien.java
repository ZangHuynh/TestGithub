package th_week4;

import java.io.Serializable;
import java.util.Objects;

public class NhanVien implements Serializable{
	private String maNV;
	private String tenNV;
	private String hoNV;
	private Boolean phai;
	private int tuoi;
	private double tienLuong;
	
	public NhanVien() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public NhanVien(String maNV, String tenNV, String hoNV, Boolean phai, int tuoi, double tienLuong) {
		super();
		this.maNV = maNV;
		this.tenNV = tenNV;
		this.hoNV = hoNV;
		this.phai = phai;
		this.tuoi = tuoi;
		this.tienLuong = tienLuong;
	}

	public String getMaNV() {
		return maNV;
	}

	public void setMaNV(String maNV) {
		this.maNV = maNV;
	}

	public String getTenNV() {
		return tenNV;
	}

	public void setTenNV(String tenNV) {
		this.tenNV = tenNV;
	}

	public String getHoNV() {
		return hoNV;
	}

	public void setHoNV(String hoNV) {
		this.hoNV = hoNV;
	}

	public Boolean getPhai() {
		return phai;
	}

	public void setPhai(Boolean phai) {
		this.phai = phai;
	}

	public int getTuoi() {
		return tuoi;
	}

	public void setTuoi(int tuoi) {
		this.tuoi = tuoi;
	}

	public double getTienLuong() {
		return tienLuong;
	}

	public void setTienLuong(double tienLuong) {
		this.tienLuong = tienLuong;
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
		return "NhanVien [maNV: " + maNV + ", hoNV: " + hoNV + ", tenNV: " + tenNV + ", phai: " + phai + ", tuoi: " + tuoi
				+ ", tienLuong: " + tienLuong + "]";
	}
	
}
