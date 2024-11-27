package additioncalculator

import additioncalculator.domain.NumberSplit
import additioncalculator.domain.NumberSplit.Companion.INVALID_NEGATIVE_MESSAGE
import additioncalculator.domain.NumberSplit.Companion.INVALID_NUMBER_TRANSFER
import additioncalculator.domain.Numbers
import io.kotest.assertions.throwables.shouldThrowWithMessage
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

class NumberSplitTest {
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
