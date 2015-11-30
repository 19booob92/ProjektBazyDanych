package WlodekSpeedTest.WlodekSpeedTest.speedTest;

public class SpeedTest implements Comparable<SpeedTest>{

	private CollectionType collectionType;
	private OperationEnum speedTestOperation;
	private String sortField;

	public String getSortField() {
		return sortField;
	}

	public void setSortField(String sortField) {
		this.sortField = sortField;
	}

	public CollectionType getCollectionType() {
		return collectionType;
	}

	public void setCollectionType(CollectionType collectionType) {
		this.collectionType = collectionType;
	}

	public OperationEnum getSpeedTestOperation() {
		return speedTestOperation;
	}

	public void setSpeedTestOperation(OperationEnum speedTestOperation) {
		this.speedTestOperation = speedTestOperation;
	}

	public SpeedTest(CollectionType collectionType, OperationEnum speedTestOperation, String sortField) {
		this.collectionType = collectionType;
		this.speedTestOperation = speedTestOperation;
		this.sortField = sortField;
	}

	public enum CollectionType{
		ARRAY_LIST, LINKED_LIST, HASH_SET, LINKED_HASH_SET, TREE_SET;
	}

	public enum OperationEnum {
		ADD, DELETE, GET, SORT
	}

	public int compareTo(SpeedTest o) {
		return collectionType.name().compareTo(o.getCollectionType().name());
	}
}
