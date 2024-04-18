package entity;

import java.util.Objects;

public class SinhVien {
	private String masv;
	private String ho;
	private String ten;
	private String phai;
	private String email;
	private String diaChi;
	private LopHoc lopHoc;
	
	public String getMasv() {
		return masv;
	}
	
	public void setMasv(String masv) {
		this.masv = masv;
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
	
	public String getPhai() {
		return phai;
	}
	
	public void setPhai(String phai) {
		this.phai = phai;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getDiaChi() {
		return diaChi;
	}
	
	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	public LopHoc getLopHoc() {
		return lopHoc;
	}
	
	public void setLopHoc(LopHoc lopHoc) {
		this.lopHoc = lopHoc;
	}

	public SinhVien(String masv, String ho, String ten, String phai, String email, String diaChi, LopHoc lopHoc) {
		super();
		this.masv = masv;
		this.ho = ho;
		this.ten = ten;
		this.phai = phai;
		this.email = email;
		this.diaChi = diaChi;
		this.lopHoc = lopHoc;
	}

	public SinhVien(String masv) {
		super();
		this.masv = masv;
	}

	public SinhVien() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public int hashCode() {
		return Objects.hash(masv);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SinhVien other = (SinhVien) obj;
		return Objects.equals(masv, other.masv);
	}

	@Override
	public String toString() {
		return "SinhVien [masv=" + masv + ", ho=" + ho + ", ten=" + ten + ", phai=" + phai + ", email=" + email
				+ ", diaChi=" + diaChi + ", lopHoc=" + lopHoc + "]";
	}
	
	
	
}
