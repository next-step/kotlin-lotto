package additioncalculator.domain

import additioncalculator.domain.NumberSplit.Companion.INVALID_NEGATIVE_MESSAGE
import additioncalculator.domain.NumberSplit.Companion.INVALID_NUMBER_TRANSFER
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.NullAndEmptySource
import java.lang.IllegalArgumentException

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class NumberSplitTest {
    @ParameterizedTest
    @NullAndEmptySource
    fun `입력 문자열이 null 이거나 빈문자열일 경우 빈 리스트를 반환한다`(text: String?) {
        val numbers: Numbers = NumberSplit(text = text).splitNumberResult()
        numbers.numbers.isEmpty() shouldBe true
    }

    @Test
    fun `입력 받은 하나의 문자열을 숫자들로 반환한다`() {
        val numbers: Numbers = NumberSplit(text = "//t\n" + "1t2,3:4,12:34:56t78,9").splitNumberResult()
        numbers.numbers.containsAll(listOf(1, 2, 3, 4, 12, 34, 56, 78, 9)) shouldBe true
    }

    @Test
    fun `입력 받은 문자열 중 음수가 존재할 경우 RuntimeException이 발생한다`() {
        val numberSplit = NumberSplit(text = "//t\n" + "1t2,3:4,12:34:-56t78,9")
        shouldThrowWithMessage<RuntimeException>(message = INVALID_NEGATIVE_MESSAGE) { numberSplit.splitNumberResult() }
    }

    @Test
    fun `입력 받은 문자열 중 숫자로 변환이 불가한 값이 존재할 경우 IllegalArgumentException이 발생한다`() {
        val numberSplit = NumberSplit(text = "//t\n" + "1t2,3:4,12:34:김창민56t78,9")
        shouldThrowWithMessage<IllegalArgumentException>(message = INVALID_NUMBER_TRANSFER) {
            numberSplit.splitNumberResult()
        }
    }
}
