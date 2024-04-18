package th_week5;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class LuuTru {
	private static final String FILENAME = "data/Sach.txt";
	
	public static void ghiFile(ArrayList<Sach> dsSach) {
		BufferedWriter bw;
		try {
			bw = new BufferedWriter(new FileWriter(FILENAME));
			bw.write("MaSach;TuaSach;TacGia;NamXuatBan;NhaXuatBan;SoTrang;DonGia;ISBN\n");
			for(Sach book : dsSach) {
				bw.write(book.toString() + "\n");
			}
			bw.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<Sach> docFile() {
		ArrayList<Sach> dsSach = new ArrayList<Sach>();
		BufferedReader br = null;
		try {
			if(new File(FILENAME).exists()) {
				br = new BufferedReader(new FileReader(FILENAME));
				br.readLine();
				while(br.ready()) {
					String line = br.readLine();
					if(line != null && !line.trim().equals("")) {
						String[] a = line.split(";");
						Sach book = new Sach(a[0], a[1], a[2], 
								Integer.parseInt(a[3]), a[4], Integer.parseInt(a[5]), 
								Double.parseDouble(a[6]), a[7]);
						dsSach.add(book);
					}
				}
				br.close();
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return dsSach;
	}
}	

	