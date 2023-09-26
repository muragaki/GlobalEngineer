package grobal.model;

import java.util.Date;

public class GlobalEngineer {
	Integer	id;				// 内定者番号
	Integer	rollnumber;		// 展開エンジニアコード
	String	name;			// 氏名
	String	nationality;	// 国籍
    Date 	birthday;		// 生年月日
    String	sex;			// 性別
    String	almamater;		// 出身学校
    Integer	salary;			// 給与
    String	employment;		// 雇用形態
    String	place;			// 配属先
    String	email;			// メールアドレス
    String	note;			// 備考
	public GlobalEngineer(Integer id, Integer rollnumber, String name, String nationality, Date birthday, String sex,
			String almamater, Integer salary, String employment, String place, String email, String note) {
		super();
		this.id = id;
		this.rollnumber = rollnumber;
		this.name = name;
		this.nationality = nationality;
		this.birthday = birthday;
		this.sex = sex;
		this.almamater = almamater;
		this.salary = salary;
		this.employment = employment;
		this.place = place;
		this.email = email;
		this.note = note;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getRollnumber() {
		return rollnumber;
	}
	public void setRollnumber(Integer rollnumber) {
		this.rollnumber = rollnumber;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getAlmamater() {
		return almamater;
	}
	public void setAlmamater(String almamater) {
		this.almamater = almamater;
	}
	public Integer getSalary() {
		return salary;
	}
	public void setSalary(Integer salary) {
		this.salary = salary;
	}
	public String getEmployment() {
		return employment;
	}
	public void setEmployment(String employment) {
		this.employment = employment;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getNote() {
		return note;
	}
	public void setNote(String note) {
		this.note = note;
	}
}