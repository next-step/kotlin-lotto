package step2Lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import step2Lotto.view.InputIO
import java.lang.IllegalArgumentException

class InputDataTest {
    private val inputIO = InputIO()

    @Test
    fun `구입 금액을 입력받는다`() {
        val purchaseAmount = inputIO.inputPurchaseAmount("10000")
        purchaseAmount shouldBe 10000
    }

    @Test
    fun `구입 금액이 1000원 미만일 시 예외를 리턴한다`() {
        shouldThrow<IllegalArgumentException> {
            inputIO.inputPurchaseAmount("999")
        }
    }
}
