import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;
import ru.netology.DataGenerator;
import ru.netology.RegistrationInfo;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.*;


public class CardDeliveryTests {


    private static Faker faker;

    RegistrationInfo info = DataGenerator.Registration.generateInfo("ru");


    @Test
    void shouldFirstCardFormTest() {
        open("http://localhost:9999");
        Configuration.holdBrowserOpen = true;

        $("[data-test-id=city] input").setValue(info.getCity());
        $("[data-test-id=date]").click();
        $("[data-test-id=date] input").setValue("\b\b\b\b\b\b\b\b");
        $("[data-test-id=date] input").setValue(info.getDate());
        $("[data-test-id=name] input").setValue(info.getName());
        $("[data-test-id=phone] input").setValue(info.getPhone());
        $("[data-test-id=agreement]").click();
        $(".button__content").click();
        $("[data-test-id=success-notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $("[data-test-id=date]").click();
        $("[data-test-id=date] input").setValue("\b\b\b\b\b\b\b\b");
        $("[data-test-id=date] input").setValue(info.getAnotherDate());
        $(".button__content").click();
        $("[data-test-id=replan-notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));
        $x("//span[contains (text (), 'Перепланировать')]").click();
        $("[data-test-id=success-notification]").shouldBe(Condition.visible, Duration.ofSeconds(15));


    }
}