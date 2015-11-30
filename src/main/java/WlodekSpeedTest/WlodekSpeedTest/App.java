package WlodekSpeedTest.WlodekSpeedTest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import WlodekSpeedTest.WlodekSpeedTest.speedTest.DocumentSpeedTest;
import WlodekSpeedTest.WlodekSpeedTest.speedTest.SpeedTest;

public class App {
	public static void main(String[] args) {
		Map<SpeedTest, Long> docuemntsTests = DocumentSpeedTest.test();

		List<SpeedTest> tests = new ArrayList<SpeedTest>(docuemntsTests.keySet());
		Collections.sort(tests);
		
		for (SpeedTest result : tests) {
			System.out.println(result.getCollectionType() + " " + result.getSpeedTestOperation() + " : "
					+ docuemntsTests.get(result));
		}
	}
}
