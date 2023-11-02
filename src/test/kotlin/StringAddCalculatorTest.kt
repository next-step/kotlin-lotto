import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import org.assertj.core.api.Assertions
import java.lang.RuntimeException

class StringAddCalculatorTest : StringSpec({
    "empty formula" {
        StringAddCalculator.evaluate("").shouldBe(0)
    }

    "null formula" {
        StringAddCalculator.evaluate(null).shouldBe(0)
    }

    "single number" {
        val ans = 12
        StringAddCalculator.evaluate(ans.toString()).shouldBe(ans)
    }

    "only comma formula" {
        StringAddCalculator.evaluate("1,2,3,4,5").shouldBe(15)
    }

    "only colon formula" {
        StringAddCalculator.evaluate("1:2:3:4:5").shouldBe(15)
    }

    "only comma & colon formula" {
        StringAddCalculator.evaluate("1,2:3:4,5").shouldBe(15)
    }

    "only custom delimiter formula" {
        val customDelimiter = ";"
        StringAddCalculator.evaluate("//$customDelimiter\n1${customDelimiter}2${customDelimiter}3${customDelimiter}4${customDelimiter}5")
            .shouldBe(15)
    }

    "complex formula with custom delimiter" {
        val customDelimiter1 = ";"
        StringAddCalculator.evaluate("//${customDelimiter1}\n1,2${customDelimiter1}3:4${customDelimiter1}5")
            .shouldBe(15)
        val customDelimiter2 = "-"
        StringAddCalculator.evaluate("//${customDelimiter2}\n1,2${customDelimiter2}3:4${customDelimiter2}5")
            .shouldBe(15)
    }

    "throw exception on negative number" {
        Assertions.assertThatThrownBy {
            StringAddCalculator.evaluate("-1,2,-3,4,5")
        }.isInstanceOf(RuntimeException::class.java)

        Assertions.assertThatThrownBy {
            StringAddCalculator.evaluate("//-\n-1,2--3:4-5")
        }.isInstanceOf(RuntimeException::class.java)
    }
})
