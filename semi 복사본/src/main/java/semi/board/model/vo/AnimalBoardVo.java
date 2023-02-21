package semi.board.model.vo;

import java.sql.Date;

public class AnimalBoardVo {
	
/*
 * CREATE TABLE ANIMAL(
		ANIMAL_NO NUMBER(2) NOT NULL PRIMARY KEY
	,	ANIMAL_DATE TIMESTAMP
	,	ANIMAL_KIND VARCHAR2(30 BYTE) 
	,	ANIMAL_GENDER VARCHAR2(10 BYTE)
	,	ANIMAL_PLACE VARCHAR2(50 BYTE)
	, 	ANIMAL_DETAIL VARCHAR2(4000 BYTE)
);
 */
	private int animalNo;
	private Date animalDate;
	private String animalKind;
	private String animalGender;
	private String animalPlace;
	private String animalDetail;
	
	
	public int getAnimalNo() {
		return animalNo;
	}
	
	public void setAnimalNo(int animalNo) {
		this.animalNo = animalNo;
	}
	
	public java.sql.Date getAnimalDate() {
		return animalDate;
	}

	public void setAnimalDate(Date date) {
		this.animalDate = date;
	}
	
	public String getAnimalKind() {
		return animalKind;
	}
	
	public void setAnimalKind(String animalKind) {
		this.animalKind = animalKind;
	}
	
	public String getAnimalGender() {
		return animalGender;
	}
	
	public void setAnimalGender(String animalGender) {
		this.animalGender = animalGender;
	}
	
	public String getAnimalPlace() {
		return animalPlace;
	}
	
	public void setAnimalPlace(String animalPlace) {
		this.animalPlace = animalPlace;
	}
	
	public String getAnimalDetail() {
		return animalDetail;
	}
	
	public void setAnimalDetail(String animalDetail) {
		this.animalDetail = animalDetail;
	}
	
	@Override
	public String toString() {
		return "AnimalBoardVo [animalNo=" + animalNo + ", animalDate=" + animalDate + ", animalKind=" + animalKind
				+ ", animalGender=" + animalGender + ", animalPlace=" + animalPlace + ", animalDetail=" + animalDetail
				+ "]";
	}
	
	public AnimalBoardVo(int animalNo, Date animalDate, String animalKind, String animalGender, String animalPlace,
			String animalDetail) {
		super();
		this.animalNo = animalNo;
		this.animalDate = animalDate;
		this.animalKind = animalKind;
		this.animalGender = animalGender;
		this.animalPlace = animalPlace;
		this.animalDetail = animalDetail;
	}
	
	public AnimalBoardVo() {
		super();
	}
	
	
	

}
