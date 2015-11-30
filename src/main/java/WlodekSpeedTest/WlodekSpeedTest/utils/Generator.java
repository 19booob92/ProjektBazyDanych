package WlodekSpeedTest.WlodekSpeedTest.utils;

import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Collection;
import java.util.Date;
import java.util.Random;

import WlodekSpeedTest.WlodekSpeedTest.model.Document;
import WlodekSpeedTest.WlodekSpeedTest.model.Invoice;
import static WlodekSpeedTest.WlodekSpeedTest.model.Invoice.SortEnum;

public class Generator {

	private static Random random = new Random();
	private static SecureRandom stringGenerator = new SecureRandom();

	public void generateInvoices(Collection<Invoice> collection, Long amount, SortEnum invoiceSortField) {
		for (long i = 0; i < amount; i++) {

			Invoice invoice = new Invoice(invoiceSortField);

			invoice.setCreationDate(new Date(random.nextLong()));
			invoice.setDeathLine(new Date(random.nextLong()));
			invoice.setId(random.nextLong());

			invoice.setName(new BigInteger(130, stringGenerator).toString(32));
			invoice.setSignature(new BigInteger(145, stringGenerator).toString(32));
			invoice.setSurname(new BigInteger(111, stringGenerator).toString(32));

			collection.add(invoice);

			collection.add(InvoiceFactory.createDefaultInvoice(SortEnum.CREATED_AT, new Date(), 1L, "123"));
			collection.add(InvoiceFactory.createDefaultInvoice(SortEnum.CREATED_AT, new Date(), 2L, "123"));
			collection.add(InvoiceFactory.createDefaultInvoice(SortEnum.CREATED_AT, new Date(), 3L, "123"));

			collection.add(InvoiceFactory.createDefaultInvoice(SortEnum.SIGNATURE, new Date(15), 6L, "321"));
			collection.add(InvoiceFactory.createDefaultInvoice(SortEnum.SIGNATURE, new Date(15), 6L, "321"));

			collection.add(InvoiceFactory.createDefaultInvoice(SortEnum.SIGNATURE, new Date(123), 5L, "3211"));
			collection.add(InvoiceFactory.createDefaultInvoice(SortEnum.SIGNATURE, new Date(123), 5L, "3211"));
		}
	}

	public void generateDocuments(Collection<Document> collection, Long amount,
			WlodekSpeedTest.WlodekSpeedTest.model.Document.SortEnum sortEnum) {

		for (long i = 0; i < amount; i++) {

			Document docuemnt = new Document(sortEnum);

			docuemnt.setCreatedAt(new Date(random.nextLong()));
			docuemnt.setId(random.nextLong());
			docuemnt.setContent(new BigInteger(130, stringGenerator).toString(32));
			docuemnt.setExt(new BigInteger(798, stringGenerator).toString(32));
			docuemnt.setName(new BigInteger(130, stringGenerator).toString(32));

			collection.add(docuemnt);

			collection.add(DocumentFactory.createDefaultInvoice(sortEnum, new Date(), 15L, "test", "test", "test"));
			collection.add(DocumentFactory.createDefaultInvoice(sortEnum, new Date(), 15L, "test", "test", "test"));
			collection.add(DocumentFactory.createDefaultInvoice(sortEnum, new Date(), 15L, "test", "test", "test"));

			collection.add(
					DocumentFactory.createDefaultInvoice(sortEnum, new Date(123), 125L, "test1", "test1", "test1"));
			collection.add(DocumentFactory.createDefaultInvoice(sortEnum, new Date(), 125L, "test1", "test1", "test1"));

			collection.add(
					DocumentFactory.createDefaultInvoice(sortEnum, new Date(321), 1251L, "test2", "test2", "test2"));
			collection.add(
					DocumentFactory.createDefaultInvoice(sortEnum, new Date(321), 1251L, "test2", "test2", "test2"));
		}
	}
}
