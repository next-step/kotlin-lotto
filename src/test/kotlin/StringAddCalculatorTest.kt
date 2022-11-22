import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.lang.RuntimeException

internal class StringAddCalculatorTest{

    @Test
    fun `객체에 빈 문자열을 입력할 경우 0을 반환해야 한다` () {
        val calculator = StringAddCalculator("")
        calculator.result shouldBe 0
    }

    @Test
    fun `객체에 null을 입력할 경우 0을 반환해야 한다` () {
        val calculator = StringAddCalculator(null)
        calculator.result shouldBe 0
    }

    @Test
    fun `숫자 하나를 입력할 경우 해당 숫자를 반환한다` () {
        val calculator = StringAddCalculator("47")
        calculator.result shouldBe 47
    }

    @Test
    fun `문자열에서 컴마를 기준으로 숫자들의 덧셈을 반환한다` () {
        val calculator = StringAddCalculator("8,10")
        calculator.result shouldBe 18
    }

    @Test
    fun `문자열에서 콜론을 기준으로 숫자들의 덧셈을 반환한다` () {
        val calculator = StringAddCalculator("9:13")
        calculator.result shouldBe 22
    }

    @Test
    fun `이중 슬래쉬와 개행문자 문자 사이에 있는 문자를 커스텀 구분자로 지정한다` () {
        val calculator = StringAddCalculator("//;\n1;2;3")
        calculator.result shouldBe 6
    }

    @Test
    fun `음수를 전달할 시, 런타임 엑셉션 발생` () {
        shouldThrow<RuntimeException>{
            StringAddCalculator("-1")
        }
    }
}