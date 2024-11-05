package utilities;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class Helper {

	// Method to take screenshot when the test cases fail
		public static void captureScreenshot(WebDriver driver, String screenshotname) {
			// Get the next incremented number for the screenshot
			int screenshotNumber = getScreenshotNumber("./ScreenShots");

			// Create the file name with the incremented number
			Path dest = Paths.get("./ScreenShots", screenshotname + "_" + screenshotNumber + ".png");

			try {
				Files.createDirectories(dest.getParent());
				FileOutputStream out = new FileOutputStream(dest.toString());
				out.write(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
				out.close();
			} catch (IOException e) {
				System.out.println("Exception while taking screenshot: " + e.getMessage());
			}
		}

		// Helper method to get the next incremented number based on existing screenshots
		private static int getScreenshotNumber(String folderPath) {
			try (Stream<Path> files = Files.list(Paths.get(folderPath))) {
				Optional<Integer> lastNumber = files
						.filter(f -> f.getFileName().toString().endsWith(".png"))
						.map(f -> f.getFileName().toString().replaceAll("\\D+", "")) // Extract numbers
						.filter(s -> !s.isEmpty())
						.map(Integer::parseInt)
						.max(Comparator.naturalOrder());  // Get the largest number

				return lastNumber.orElse(0) + 1;  // Increment by 1
			} catch (IOException e) {
				System.out.println("Exception while retrieving screenshot number: " + e.getMessage());
				return 1;  // Default to 1 if no files exist or an error occurs
			}
		}
}
