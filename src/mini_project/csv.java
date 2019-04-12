package mini_project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

class Contact {
	private String name;
	private String email;
	private String phone;

	public Contact(String name, String email, String phone) {
		this.name = name;
		this.email = email;
		this.phone = phone;
	}

	public Contact() {

	}

	public String getName() {
		return this.name;
	}

	public String getEmail() {
		return this.email;
	}

	public String getPhone() {
		return this.phone;
	}
}

public class csv {

	private static void writeToCsv(ArrayList<Contact> list, String filename) {
		try {
			FileOutputStream fos = new FileOutputStream(filename);
			OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");

			BufferedWriter bw = new BufferedWriter(osw);

			for (Contact contact : list) {
				StringBuffer oneLine = new StringBuffer();

				String name = contact.getName();
				String email = contact.getEmail();
				String phone = contact.getPhone();

				oneLine.append(name);
				oneLine.append(",");

				oneLine.append(email);
				oneLine.append(",");

				oneLine.append(phone);
				oneLine.append(",");

				bw.write(oneLine.toString());
				bw.newLine();
			}
			bw.flush();
			bw.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private static ArrayList<Contact> readCSV(String filename) throws IOException {
		ArrayList<Contact> contacts = new ArrayList<Contact>();
		int count = 0;
		int max = 0;
		int min = 0;

		Contact max_ct = new Contact();
		Contact min_ct = new Contact();

		FileReader fr;
		try {
			fr = new FileReader(filename);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			while ((line = br.readLine()) != null) {
				System.out.println("Line::");
				System.out.println(line);
				String[] items = line.split(",");
				Contact ct = new Contact(items[0], items[1], items[2]);
				String phone = ct.getPhone();
				String[] numbers = phone.split("");
				int sum = 0;
				for (String number : numbers) {
					int n = Integer.parseInt(number);
					sum += n;
				}
				System.out.printf("sum of %s is %d", phone, sum);
				if (count == 0) {
					max = sum;
					min = sum;
					max_ct = ct;
					min_ct = ct;
				} else {

					if (sum > max) {
						max = sum;
						max_ct = ct;
					}
					if (sum < min) {
						min = sum;
						min_ct = ct;
					}

				}
				count++;
			}

			System.out.printf("\n Max number %s is with %s \n", max_ct.getPhone(), max_ct.getName());
			System.out.printf("Min number %s is with %s", min_ct.getPhone(), min_ct.getName());
		} catch (FileNotFoundException e) {
			e.printStackTrace();

		}

		return contacts;
	}

	public static void main(String[] args) {
		try {
			readCSV("contact.csv");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<Contact> contactList = new ArrayList<Contact>();
		// Contact ct1=new Contact("ram", "rajandangi649@gmail.com",
		// "981082656");
		// contactList.add(ct1);

		contactList.add(new Contact("ram", "rajandangi649@gmail.com", "981082656"));
		contactList.add(new Contact("Hari", "rajandangi649@gmail.com", "981454553"));
		contactList.add(new Contact("Geeta", "andangi649@gmail.com", "24252345"));
		contactList.add(new Contact("Seeta", "rajan@gmail.com", "24224"));
		writeToCsv(contactList, "contact.csv");

	}

}
