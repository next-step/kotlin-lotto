package camp.nextstep.edu.step.step2.generator

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName

@DisplayName("번호 생성기는")
class NumberGeneratorTest : BehaviorSpec({

    Given("각 생성전략이 주어지고") {
        val generatorStrategy = NumberGenerator.LOTTO_RANDOM

        When("생성기에 전략을 주입하면") {
            val numberGenerator = NumberGenerator.generate(generatorStrategy)

            Then("각 전략에 맞는 번호들이 생성된다.") {
                numberGenerator.size shouldBe 6
            }
        }
    }

})
