package th_week4;

import java.io.Serializable;
import java.util.ArrayList;

public class NhanVien_Collection implements Serializable{
	private ArrayList<NhanVien> dsNV;

	public NhanVien_Collection() {
		this.dsNV = new ArrayList<NhanVien>();
	}
	
	public boolean themNV(NhanVien nv) {
		if(dsNV.contains(nv))
			return false;
		dsNV.add(nv);
		return true;
	}
	
	public boolean xoaNV(NhanVien nv) {
		if(!dsNV.contains(nv))
			return false;
		dsNV.remove(nv);
		return true;
	}
	
	public NhanVien timKiem(String ma) {
		for(NhanVien nv : dsNV) {
			if(nv.getMaNV().equalsIgnoreCase(ma))
				return nv;
		}
		return null;
	}
	
	public ArrayList<NhanVien> getList() {
		return dsNV;
	}
	
	public void setList(ArrayList<NhanVien> dsNV) {
		this.dsNV = dsNV;
	}
	
	public NhanVien getElement(int index) {
		if(index < 0 || index >= getSize())
			return null;
		return dsNV.get(index);
	}
	
	public int getSize() {
		return dsNV.size();
	}
}
