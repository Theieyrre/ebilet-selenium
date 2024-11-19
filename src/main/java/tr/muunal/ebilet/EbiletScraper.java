package tr.muunal.ebilet;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class EbiletScraper {
    private static final Logger LOGGER = LoggerFactory.getLogger(EbiletScraper.class);
    private WebElement route;
    private WebElement stations;
    private WebElement dates;
    private WebElement passangers;
    private WebElement button;

    public EbiletScraper(String url) {
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        WebElement buyTicketArea = driver.findElement(By.id("buyTicket"));
        List<WebElement> elements = buyTicketArea.findElements(By.cssSelector("div.row"));
        this.route = elements.get(0);
        this.stations = elements.get(1);
        this.dates = elements.get(2);
        this.passangers = elements.get(3);
        this.button = elements.get(4);
        LOGGER.info(this.toString());
    }

    @Override
    public String toString() {
        String innerHTML = "innerHTML";
        return "EbiletScraper{" +
                "route=" + this.route.getAttribute(innerHTML) +
                ", stations=" + this.stations.getAttribute(innerHTML) +
                ", dates=" + this.dates.getAttribute(innerHTML) +
                ", passangers=" + this.passangers.getAttribute(innerHTML) +
                ", button=" + this.button.getAttribute(innerHTML) +
                '}';
    }
}
