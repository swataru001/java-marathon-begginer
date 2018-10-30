package jp.co.rakus.domain;

/**
 * ユーザー情報を表すドメイン
 * @author wataru.saito
 *
 */
public class User {

	/**
	 * ユーザーID
	 */
	private Integer id;
	/**
	 * 名前
	 */
	private String name;
	/**
	 * 年齢
	 */
	private Integer age;
	/**
	 * 住所
	 */
	private String address;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
}
