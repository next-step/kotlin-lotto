import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class StringAdditionCalculator(private val str: String?) {
    fun add(): Int {
        if (str.isNullOrBlank()) return 0
        val matchResult = Regex("//(.)\n(.*)").find(str)
        val separator = matchResult?.groupValues?.get(1)
        val numbers = matchResult?.groupValues?.get(2)?.split(",|:|${separator?.let { Regex.escape(it) }}".toRegex()) ?: str.split(",|:".toRegex())
        if (numbers.any { it.matches(NOT_NUMBER_REGEX) }) throw RuntimeException(NOT_NUMBER_MESSAGE)
        return if (numbers.size == 1 && separator == null) str.toInt() else numbers.sumOf { it.toInt() }
    }

    companion object {
        private val NOT_NUMBER_REGEX = Regex("[^0-9]")
        private const val NOT_NUMBER_MESSAGE = "숫자 이외의 값을 입력할 수 없습니다."
    }
}

class StringAdditionCalculatorTest : StringSpec ({
    "빈 문자열 또는 null을 입력할 경우 0을 반환해야 한다." {
        StringAdditionCalculator("").add() shouldBe 0
        StringAdditionCalculator(null).add() shouldBe 0
    }

    "숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다." {
        StringAdditionCalculator("1").add() shouldBe 1
    }

    "숫자 두개를 컴마(,) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        StringAdditionCalculator("1,2").add() shouldBe 3
        StringAdditionCalculator("2,3").add() shouldBe 5
    }

    "숫자 두개를 콜론(:) 구분자로 입력할 경우 두 숫자의 합을 반환한다." {
        StringAdditionCalculator("1:2").add() shouldBe 3
        StringAdditionCalculator("2:3").add() shouldBe 5
    }

    "구분자를 컴마(,) 이외에 콜론(:)을 사용할 수 있다." {
        StringAdditionCalculator("1,2:3").add() shouldBe 6
        StringAdditionCalculator("1:2,3").add() shouldBe 6
    }

    "\"//\"와 \"\\n\" 문자 사이에 커스텀 구분자를 지정할 수 있다." {
        StringAdditionCalculator("//;\n1;2;3").add() shouldBe 6
        StringAdditionCalculator("//-\n1-2-3").add() shouldBe 6
    }

    "숫자 이외의 값을 전달할 경우 RuntimeException 예외가 발생해야 한다." {
        val exception = shouldThrow<RuntimeException> {
            StringAdditionCalculator("1,2,a").add()
        }
        exception.message shouldBe "숫자 이외의 값을 입력할 수 없습니다."
    }
})