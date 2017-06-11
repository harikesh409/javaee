package jsf;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.event.ActionEvent;
import javax.servlet.http.Part;

@ManagedBean
@RequestScoped
public class FileBean {

	private Part file;
	private int count;

	public Part getFile() {
		return file;
	}

	public void setFile(Part file) {
		this.file = file;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public void upload(ActionEvent evt) {
		// read the contents of the file and count number of words
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(file.getInputStream()));
			String line = br.readLine();
			count = 0;
			while (line != null) {
				String words[] = line.split("[^A-Za-z0-9-_]+");
				count += words.length;
				line = br.readLine();
			}
			br.close();
		} catch (Exception ex) {
			System.out.println("Error -->" + ex.getMessage());
		}
	}
}