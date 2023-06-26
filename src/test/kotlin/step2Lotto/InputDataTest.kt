package step2Lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import step2Lotto.domain.dto.Lotto
import step2Lotto.view.InputIO

class InputDataTest {
    private val inputIO = InputIO()

    @Test
    fun `구입 금액을 입력받는다`() {
        val purchaseAmount = inputIO.inputPurchaseAmount("10000")
        purchaseAmount shouldBe 10000
    }

    @Test
    fun `당첨 번호를 입력받는다`() {
        val winningNumber = inputIO.inputWinningNumber("1, 9, 10, 30, 31, 41")
        winningNumber shouldBe Lotto(arrayOf(1, 9, 10, 30, 31, 41))
    }
}
