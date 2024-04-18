package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import connect.ConnectionDB;
import entity.PhongBan;

public class PhongBan_dao {
	
	public PhongBan_dao() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<PhongBan> getAllPhongBan() {
		ArrayList<PhongBan> dsPB = new ArrayList<PhongBan>();
		try {
			ConnectionDB.getInstance();
			Connection con = ConnectionDB.getConnection();
			
			String sql = "SELECT * FROM PhongBan";
			Statement sm = con.createStatement();
			ResultSet rs = sm.executeQuery(sql);
			while(rs.next()) {
				String maPhong = rs.getString("maPhong");
				String tenPhong = rs.getString("tenPhong");
				PhongBan pBan =  new PhongBan(maPhong, tenPhong);
				dsPB.add(pBan);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return dsPB;
	}
}
