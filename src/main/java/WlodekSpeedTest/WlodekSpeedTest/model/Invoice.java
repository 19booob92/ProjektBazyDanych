package WlodekSpeedTest.WlodekSpeedTest.model;

import java.io.Serializable;
import java.util.Date;

public class Invoice implements Serializable, Comparable<Invoice> {

	private static final long serialVersionUID = 45179856321L;

	private Long id;

	private String name;

	private String surname;

	private String signature;

	private Date creationDate;

	private Date deathLine;

	private SortEnum sortField;

	public Invoice(SortEnum sortField) {
		this.sortField = sortField;
	}

	public String getSignature() {
		return signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(Date creationDate) {
		this.creationDate = creationDate;
	}

	public Date getDeathLine() {
		return deathLine;
	}

	public void setDeathLine(Date deathLine) {
		this.deathLine = deathLine;
	}

	public int compareTo(Invoice o) {
		if (sortField.equals(SortEnum.SIGNATURE)) {
			return o.getCreationDate().compareTo(getCreationDate());
		} else if (sortField.equals(SortEnum.CREATED_AT)) {
			return o.getSignature().compareTo(getSignature());
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((creationDate == null) ? 0 : creationDate.hashCode());
		result = prime * result + ((deathLine == null) ? 0 : deathLine.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((surname == null) ? 0 : surname.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Invoice other = (Invoice) obj;
		if (getSignature() == null) {
			if (other.getSignature() != null)
				return false;
		} else if (!getSignature().equals(other.getSignature()))
			return false;
		if (getId() == null) {
			if (other.getId() != null)
				return false;
		} else if (!getId().equals(other.getId()))
			return false;
		return true;
	}

	public enum SortEnum {
		CREATED_AT, SIGNATURE;
	}
}
