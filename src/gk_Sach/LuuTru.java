package gk_Sach;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LuuTru {
	private static final String FILEPATH = "data/Sach.txt";
	
	public static void ghiFile(ArrayList<Sach> dsSach) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILEPATH));
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for(Sach s : dsSach) {
				bw.write(s.toString() + "\n");
			}
			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Sach> docFile() {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		BufferedReader br;
		try {
			if(new File(FILEPATH).exists()) {
				br = new BufferedReader(new FileReader(FILEPATH));
				br.readLine();
				while(br.ready()) {
					String line = br.readLine();
					if(line != null) {
						String[] a = line.split(";");
						dsSach.add(new Sach(a[0], a[1], a[2], Integer.parseInt(a[3])
								, a[4], Integer.parseInt(a[5]), Double.parseDouble(a[6]), a[7]));
					}
				}
				br.close();
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return dsSach;
	}
}
