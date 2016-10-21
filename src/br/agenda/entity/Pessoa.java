package br.agenda.entity;

public class Pessoa {

	String name;
	String dateOfBirth;
	String phone;
	String email;
	String registrationDate;

	public Pessoa() {
	}

	public Pessoa(final String name, final String dateOfBirth, final String phone, final String email) {
		super();
		this.name = name;
		this.dateOfBirth = dateOfBirth;
		this.phone = phone;
		this.email = email;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public String getEmail() {
		return email;
	}

	public String getName() {
		return name;
	}

	public String getPhone() {
		return phone;
	}

	public void setDateOfBirth(final String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public void setEmail(final String email) {
		this.email = email;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public void setPhone(final String phone) {
		this.phone = phone;
	}

}
