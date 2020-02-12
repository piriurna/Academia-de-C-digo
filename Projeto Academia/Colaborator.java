package Default.BackEnd;

import java.io.FileInputStream;

public class Colaborator {
	
	private int id;
	private String name;
	private String adress;
	private String phone_number;
	private String email;
	private String age;
	private String identification_number;
	private FileInputStream photoStream;
	private FileInputStream cv;


	public Colaborator(String name, String adress, String phone_number, String email, String age,
			String identification_number, FileInputStream photoStream, FileInputStream cv) {
		super();
		this.name = name;
		this.adress = adress;
		this.phone_number = phone_number;
		this.email = email;
		this.age = age;
		this.identification_number = identification_number;
		this.photoStream = photoStream;
		this.cv = cv;
	}
	
	
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	public String getName() {
		return name;
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	
	
	public String getAdress() {
		return adress;
	}
	
	
	public void setAdress(String adress) {
		this.adress = adress;
	}
	
	
	public String getPhone_number() {
		return phone_number;
	}
	
	
	public void setPhone_number(String phone_number) {
		try {
			Double.parseDouble(phone_number);
		}catch(NumberFormatException e) {
			System.out.println("Wrong phone number. Use only numbers");
		}
		if(phone_number.length() != 9)
			System.out.println("Phone number must have 9 digits");
		this.phone_number = phone_number;
	}
	
	
	public String getEmail() {
		return email;
	}
	
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	public String getAge() {
		return age;
	}
	
	
	public void setAge(String age) {
		this.age = age;
	}
	
	
	public String getIdentification_number() {
		return identification_number;
	}
	
	
	public void setIdentification_number(String identification_number) {
		this.identification_number = identification_number;
	}


	public FileInputStream getPhotoStream() {
		return photoStream;
	}


	public void setPhotoStream(FileInputStream photoStream) {
		this.photoStream = photoStream;
	}


	public FileInputStream getCv() {
		return cv;
	}


	public void setCv(FileInputStream cv) {
		this.cv = cv;
	}
	
	
	
	

}
