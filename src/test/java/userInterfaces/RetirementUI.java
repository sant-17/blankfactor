package userInterfaces;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

public class RetirementUI extends PageObject {

    public static final Target LBL_SECTION = Target
            .the("{0} label")
            .locatedBy("//h2[normalize-space(.)='{0}']");

    public static final Target CARD_SECTION_RETIREMENT_SERVICES = Target
            .the("Card section on retirement services")
            .locatedBy("//div[@class='cards-grid-slider-wrapper']//div[@class='swiper-slide'][3]");

    public static final Target BACK_CARD_RETIREMENT_SERVICES = Target
            .the("Back card text")
            .locatedBy("(//div/div[@class='card-text small'])[3]");

    public static final Target BTN_GET_STARTED = Target
            .the("Button to redirect into contact form")
            .locatedBy("//a[@title=\"{0}\"]");
}
