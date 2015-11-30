package WlodekSpeedTest.WlodekSpeedTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import javax.naming.spi.DirStateFactory.Result;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import WlodekSpeedTest.WlodekSpeedTest.model.Document;
import WlodekSpeedTest.WlodekSpeedTest.speedTest.DocumentSpeedTest;
import WlodekSpeedTest.WlodekSpeedTest.speedTest.SpeedTest;
import WlodekSpeedTest.WlodekSpeedTest.utils.Generator;

public class AppTestWithMock {

	private Generator generator = Mockito.mock(Generator.class);

	@Test
	public void shouldReturnMapWithElements() {
		List<Document> docs = new ArrayList<Document>();

		final List<Document> toReturn = Arrays.asList(new Document[] { new Document(Document.SortEnum.EXT) });

		Mockito.doAnswer(new Answer<Void>() {

			public Void answer(InvocationOnMock invocation) throws Throwable {
				List<Document> docs = (List<Document>) invocation.getArguments()[0];
				docs = toReturn;
				return null;
			}
		}).when(generator).generateDocuments(docs, 2L, Document.SortEnum.EXT);

		Map<SpeedTest, Long> result = DocumentSpeedTest.test();

		Assert.assertTrue(!result.isEmpty());
	}

	@Test
	public void should() {
		List<Document> docs = new ArrayList<Document>();

		final List<Document> toReturn = Arrays.asList(new Document[] { new Document(Document.SortEnum.EXT) });

		Mockito.doAnswer(new Answer<Void>() {

			public Void answer(InvocationOnMock invocation) throws Throwable {
				List<Document> docs = (List<Document>) invocation.getArguments()[0];
				docs = toReturn;
				return null;
			}
		}).when(generator).generateDocuments(docs, 2L, Document.SortEnum.EXT);

		Map<SpeedTest, Long> result = DocumentSpeedTest.test();

		Assert.assertTrue(result.values().iterator().next() > 100);
	}

}
