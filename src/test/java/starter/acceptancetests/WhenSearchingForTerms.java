package starter.acceptancetests;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.junit5.SerenityJUnit5Extension;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.annotations.CastMember;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.serenitybdd.screenplay.questions.page.TheWebPage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import starter.actions.navigation.NavigateTo;
import starter.actions.search.LookForInformation;
import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SerenityJUnit5Extension.class)
class WhenSearchingForTerms {

    @CastMember
    Actor actor;

    @Test
    @DisplayName("Should be able to search for Microsoft things")
    void searchForRedThings() {
        actor.attemptsTo(
                NavigateTo.theSearchHomePage(),
                LookForInformation.about("Microsoft"),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("Microsoft")
        );
        System.out.println("------------------------------------------------------------------------------------------------------------------");
        if (TheWebPage.title().answeredBy(actor).contains("Microsoft")) {
            System.out.println("The title of the page matches with the search query");
        } else {
            System.out.println("The title of the page does not match with the search query");
        }
    }
/*
    @Test
    @DisplayName("Should be able to search for green things")
    void searchForGreenThings() {
        actor.attemptsTo(
                NavigateTo.theSearchHomePage(),
                LookForInformation.about("green"),
                Ensure.that(TheWebPage.title()).containsIgnoringCase("green")
        );
    }*/
}
