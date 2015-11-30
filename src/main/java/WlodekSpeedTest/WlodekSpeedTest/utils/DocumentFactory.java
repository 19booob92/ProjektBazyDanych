package WlodekSpeedTest.WlodekSpeedTest.utils;

import java.util.Date;

import WlodekSpeedTest.WlodekSpeedTest.model.Document;

public class DocumentFactory {

	public static Document createDefaultInvoice(Document.SortEnum sortField, Date createdAt, Long id, String contend,
			String ext, String name) {

		Document document = new Document(sortField);

		document.setCreatedAt(createdAt);
		document.setId(id);
		document.setContent(contend);
		document.setExt(ext);
		document.setName(name);

		return document;
	}

}
