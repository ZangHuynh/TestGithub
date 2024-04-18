package th_week5;

import java.util.ArrayList;

public class Sach_Collection {
	private ArrayList<Sach> dsSach;

	public Sach_Collection() {
		this.dsSach = new ArrayList<Sach>();
	}
	
	public boolean themSach(Sach book) {
		if(dsSach.contains(book))
			return false;
		dsSach.add(book);
		return true;
	}
	
	public boolean xoaSach(Sach book) {
		if(!dsSach.contains(book))
			return false;
		dsSach.remove(book);
		return true;
	}
	
	public Sach timKiem(String maSach) {
		for(Sach book : dsSach) {
			if(book.getMaSach().equalsIgnoreCase(maSach))
				return book;
		}
		return null;
	}
	
	public boolean capNhatSach(String maSachOld, Sach sachNew) {
		Sach oldBook = new Sach(maSachOld);
		if(dsSach.contains(oldBook)) {
			oldBook = dsSach.get(dsSach.indexOf(oldBook));
			oldBook.setTuaSach(sachNew.getTuaSach());
			oldBook.setTacGia(sachNew.getTacGia());
			oldBook.setNamXuatBan(sachNew.getNamXuatBan());
			oldBook.setNhaXuatBan(sachNew.getNhaXuatBan());
			oldBook.setSoTrang(sachNew.getSoTrang());
			oldBook.setDonGia(sachNew.getDonGia());
			oldBook.setiSBN(sachNew.getiSBN());
			return true;
		}
		return false;
	}
	
	public Sach getElement(int index) {
		if(index < 0 || index >= getSize())
			return null;
		return dsSach.get(index);
	}
	
	public ArrayList<Sach> getList() {
		return dsSach;
	}
	
	public int getSize() {
		return dsSach.size();
	}
	
	public void napDuLieuTuFile() {
		dsSach = LuuTru.docFile();
	}
}
