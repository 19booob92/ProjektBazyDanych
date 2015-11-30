package WlodekSpeedTest.WlodekSpeedTest;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.mockito.Matchers;
import org.powermock.api.easymock.PowerMock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import WlodekSpeedTest.WlodekSpeedTest.model.Invoice;
import WlodekSpeedTest.WlodekSpeedTest.utils.Generator;

@RunWith(PowerMockRunner.class)
public class AppTest {

	@Before
	public void init() {
	}

	@Test
	public void shouldReturnProperObjects() {
		final Long AMOUNT = 2L;
		Generator generator = new Generator();
		List<Invoice> invoices = new ArrayList<Invoice>();

		generator.generateInvoices(invoices, AMOUNT, Invoice.SortEnum.SIGNATURE);

		Assert.assertEquals(new Long(AMOUNT * 8L), new Long(invoices.size()));
	}

	@Test
	public void resultShouldContainsProperObject() {
		final Long AMOUNT = 2L;
		List<Invoice> invoices = new ArrayList<Invoice>();
		Generator generator = new Generator();

		generator.generateInvoices(invoices, AMOUNT, Invoice.SortEnum.SIGNATURE);

		Invoice anyObject = invoices.get(0);

		Assert.assertEquals("DefaultName", anyObject.getName());
		Assert.assertEquals("DefualtSurname", anyObject.getSurname());
	}

}
