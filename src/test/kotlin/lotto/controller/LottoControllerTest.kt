package lotto.controller

import lotto.controller.LottoController.Companion.LOTTO_NUMBER_COUNT
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoControllerTest {

    @ParameterizedTest
    @ValueSource(strings = ["140", "-100", "abcde"])
    fun `로또 구매 금액 검증`(inputPurchaseAmount: String) {
        Assertions.assertThrows(IllegalArgumentException::class.java) {
            LottoController().getValidatePurchaseAmount(inputPurchaseAmount)
        }
    }

    @Test
    fun `생성한 로또 번호 검증`() {
        val lottoController = LottoController()
        val generatedNumbers = lottoController.getRandomGeneratedNumbers()
        assertThat(generatedNumbers.toSet().size == LOTTO_NUMBER_COUNT)
    }
}
