package runner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;
@RunWith(Cucumber.class)
@CucumberOptions(

        strict = true,
        plugin = {
                "pretty" //Steplerimizi console da gorebilmek

        },
        //path of feature file
        features = "src/test/resources",

        //glue path of step definitions

        glue = "trelloAPI",
        tags="@trelloApi",
        dryRun = false
)
public class Runner {

}