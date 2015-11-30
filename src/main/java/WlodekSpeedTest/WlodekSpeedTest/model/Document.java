package WlodekSpeedTest.WlodekSpeedTest.model;

import java.io.Serializable;
import java.util.Date;

public class Document implements Serializable, Comparable<Document> {

	private static final long serialVersionUID = 4898594822386360786L;

	private Long id;

	private String name;

	private String ext;

	private String content;

	private Date createdAt;

	private SortEnum sortField;

	public Document(SortEnum sortField) {
		this.sortField = sortField;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((content == null) ? 0 : content.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((ext == null) ? 0 : ext.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
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
		Document other = (Document) obj;
		if (ext == null) {
			if (other.ext != null)
				return false;
		} else if (!ext.equals(other.ext))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
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

	public String getExt() {
		return ext;
	}

	public void setExt(String ext) {
		this.ext = ext;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public SortEnum getSortField() {
		return sortField;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public int compareTo(Document o) {
		if (sortField.equals(SortEnum.CREATED_AT)) {
			return getCreatedAt().compareTo(o.getCreatedAt());
		} else if (sortField.equals(SortEnum.EXT)) {
			return getSortField().compareTo(o.getSortField());
		}
		return 0;
	}

	public enum SortEnum {
		EXT, CREATED_AT;
	}

}
