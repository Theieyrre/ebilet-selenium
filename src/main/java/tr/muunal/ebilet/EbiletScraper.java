package tr.muunal.ebilet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class EbiletScraper {
    private static final Logger LOGGER = LoggerFactory.getLogger(EbiletScraper.class);
    private WebElement trainDepartureStation;
    private WebElement trainArrivalStation;
    private WebElement departureDate;
    private WebElement arrivalDate;
    private WebElement button;

    public EbiletScraper(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement buyTicketArea = driver.findElement(By.id("buyTicket"));
        trainDepartureStation = buyTicketArea.findElement(By.cssSelector("input[name='Tren kalkış']"));
        trainArrivalStation = buyTicketArea.findElement(By.cssSelector("input[name='Tren varış']"));
        departureDate = buyTicketArea.findElement(By.cssSelector("input[placeholder='Gidiş Tarihi']"));
        WebElement arrivalEnableButton = buyTicketArea.findElement(By.cssSelector("button.btnAddReturn"));
        arrivalEnableButton.click();
        arrivalDate = buyTicketArea.findElement(By.cssSelector("input[placeholder='Dönüş Tarihi']"));
        button = buyTicketArea.findElement(By.cssSelector("button.btnSeferSearch"));
        assert trainArrivalStation != null;
        assert trainDepartureStation != null;
        assert departureDate != null;
        assert arrivalDate != null;
        assert button != null;
        LOGGER.info(this.toString());
    }

    @Override
    public String toString() {
        String outerHTML = "outerHTML";
        return "EbiletScraper{" +
                "trainDepartureStation=" + trainDepartureStation.getAttribute(outerHTML) +
                ", trainArrivalStation=" + trainArrivalStation.getAttribute(outerHTML) +
                ", departureDate=" + departureDate.getAttribute(outerHTML) +
                ", arrivalDate=" + arrivalDate.getAttribute(outerHTML) +
                ", button=" + button.getAttribute(outerHTML) +
                '}';
    }
}
