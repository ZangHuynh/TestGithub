package gk_EDP;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class LuuTru {
	private static final String FILEPATH = "data/NhanVien_gk.txt";
	
	public boolean ghiFile(Object obj) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILEPATH));
		oos.writeObject(obj);
		oos.flush();
		oos.close();
		return true;
	}
	
	public Object docFile() throws Exception {
		ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILEPATH));
		Object obj = ois.readObject();
		ois.close();
		return obj;
	}
}
