package WlodekSpeedTest.WlodekSpeedTest.speedTest;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import WlodekSpeedTest.WlodekSpeedTest.model.Document;
import WlodekSpeedTest.WlodekSpeedTest.utils.DocumentFactory;
import WlodekSpeedTest.WlodekSpeedTest.utils.Generator;

import WlodekSpeedTest.WlodekSpeedTest.speedTest.SpeedTest.*;

public class DocumentSpeedTest {

	private static final Long INSTANCES_AMOUNT = 10L;

	private static Map<SpeedTest, Long> timePerCollection = new HashMap<SpeedTest, Long>();

	public static Map<SpeedTest, Long> test() {

		testAddDocumentsToArrayList(Document.SortEnum.CREATED_AT);
		testAddDocumentsToArrayList(Document.SortEnum.EXT);

		testAddDocumentsToLinkedList(Document.SortEnum.CREATED_AT);
		testAddDocumentsToLinkedList(Document.SortEnum.EXT);

		return timePerCollection;
	}

	private static void testAddDocumentsToArrayList(Document.SortEnum sortField) {
		ArrayList<Document> docuemntsAL = new ArrayList<Document>();
		Generator generator = new Generator();

		generator.generateDocuments(docuemntsAL, INSTANCES_AMOUNT, sortField);

		Long startTime = System.nanoTime();
		docuemntsAL.add(
				DocumentFactory.createDefaultInvoice(sortField, new Date(), 456L, "bla bla bla", "txt", "default doc"));
		Long endTime = System.nanoTime();

		timePerCollection.put(new SpeedTest(CollectionType.ARRAY_LIST, OperationEnum.ADD, sortField.name()),
				endTime - startTime);
	}

	private static void testAddDocumentsToLinkedList(Document.SortEnum sortField) {
		LinkedList<Document> docuemntsAL = new LinkedList<Document>();
		Generator generator = new Generator();

		generator.generateDocuments(docuemntsAL, INSTANCES_AMOUNT, sortField);

		Long startTime = System.nanoTime();
		docuemntsAL.add(
				DocumentFactory.createDefaultInvoice(sortField, new Date(), 456L, "bla bla bla", "txt", "default doc"));
		Long endTime = System.nanoTime();

		timePerCollection.put(new SpeedTest(CollectionType.LINKED_LIST, OperationEnum.ADD, sortField.name()),
				endTime - startTime);
	}

}
