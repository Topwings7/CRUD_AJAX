package dto;

import java.time.LocalDate;

public class StudentDto {
	private int id;
	private String name;
	private int age;
	private String address;
	private String phone;
	private LocalDate birth_date;
	private int grade;
	public StudentDto() {
		super();
	}
	public StudentDto(int id, String name, int age, String address, String phone, LocalDate birth_date, int grade) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
		this.phone = phone;
		this.birth_date = birth_date;
		this.grade = grade;
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public LocalDate getBirth_date() {
		return birth_date;
	}
	public void setBirth_date(LocalDate birth_date) {
		this.birth_date = birth_date;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	@Override
	public String toString() {
		return "StudentDto [id=" + id + ", name=" + name + ", age=" + age + ", address=" + address + ", phone=" + phone
				+ ", birth_date=" + birth_date + ", grade=" + grade + "]";
	}
	
}
