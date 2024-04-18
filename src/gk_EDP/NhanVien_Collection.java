package gk_EDP;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien_Collection implements Serializable{
	ArrayList<NhanVien> dsNV;

	public NhanVien_Collection() {
		super();
		this.dsNV = new ArrayList<NhanVien>();
	}
	
	public boolean themNV(NhanVien nv) {
		if(!dsNV.contains(nv)) {
			dsNV.add(nv);
			return true;
		}
		return false;
	}
	
	public boolean removeNV(NhanVien nv) {
		if(dsNV.contains(nv)) {
			dsNV.remove(nv);
			return true;
		}
		return false;
	}
	
	public boolean updateNV(String maSach, NhanVien newNV) {
		NhanVien nv = new NhanVien(maSach);
		if(dsNV.contains(nv)) {
			nv = dsNV.get(dsNV.indexOf(nv));
			nv.setHoNV(newNV.getHoNV());
			nv.setTenNV(newNV.getTenNV());
			nv.setTuoi(newNV.getTuoi());
			nv.setPhai(newNV.isPhai());
			nv.setTienLuong(newNV.getTienLuong());
			return true;
		}
		return false;
	}
	
	public NhanVien timKiem(String ma) {
		for(NhanVien nv : dsNV) {
			if(nv.getMaNV().equalsIgnoreCase(ma))
				return nv;
		}
		return null;
	}
	
	public ArrayList<NhanVien> getAll() {
		return dsNV;
	}
	
	public void setList(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	
	public int getSize() {
		return dsNV.size();
	}
	
	public NhanVien getElement(int index) {
		if(index < 0 || index >= getSize())
			return null;
		return dsNV.get(index);
	}
}
