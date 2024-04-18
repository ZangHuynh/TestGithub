package gk_Sach;

import java.util.ArrayList;

public class Sach_Collection {
	private ArrayList<Sach> dsSach;

	public Sach_Collection() {
		this.dsSach = new ArrayList<Sach>();
	}
	
	public boolean themSach(Sach sach) {
		if(dsSach.contains(sach)) {
			dsSach.add(sach);
			return true;
		}
		return false;
	}
	
	public boolean xoaSach(Sach sach) {
		if(!dsSach.contains(sach)) {
			dsSach.remove(sach);
			return true;
		}
		return false;
	}
	
	public Sach timkiem(String maSach) {
		for(Sach sach : dsSach) {
			if(sach.getMaSach().equals(maSach))
				return sach;
		}
		return null;
	}
	
	public void napDuLieuTuFile() {
		this.dsSach = LuuTru.docFile();
	}
	
	public ArrayList<Sach> getList() {
		return dsSach;
	}
	
	public int getSize() {
		return dsSach.size();
	}
	
	public Sach getElement(int index) {
		if(index < 0 || index >= getSize()) {
			return null;
		}
		return dsSach.get(index);
	}
	
	public boolean updateSach(String ma, Sach newSach) {
		Sach s = new Sach(ma);
		if(dsSach.contains(s)) {
			s = dsSach.get(dsSach.indexOf(s));
			s.setTuaSach(newSach.getTuaSach());
			s.setTacGia(newSach.getTacGia());
			s.setNamXuatBan(newSach.getNamXuatBan());
			s.setNhaXuatBan(newSach.getNhaXuatBan());
			s.setSoTrang(newSach.getSoTrang());
			s.setDonGia(newSach.getDonGia());
			s.setiSBN(newSach.getiSBN());
			return true;
		}
		return false;
	}
}
