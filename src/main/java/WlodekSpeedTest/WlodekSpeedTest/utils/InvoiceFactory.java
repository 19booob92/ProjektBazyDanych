package WlodekSpeedTest.WlodekSpeedTest.utils;

import java.util.Date;

import WlodekSpeedTest.WlodekSpeedTest.model.Invoice;

public class InvoiceFactory {

	public static Invoice createDefaultInvoice(Invoice.SortEnum invoiceSortField, Date creationDate, Long id,
			String signature) {

		Invoice invoice = new Invoice(invoiceSortField);

		invoice.setId(id);

		invoice.setCreationDate(new Date());
		invoice.setSignature(signature);

		invoice.setDeathLine(creationDate);
		invoice.setName("DefaultName");
		invoice.setSurname("DefualtSurname");

		return invoice;
	}

}
