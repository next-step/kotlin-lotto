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
            LottoController(inputPurchaseAmount).getValidatePurchaseAmount()
        }
    }

    @Test
    fun `생성한 로또 번호 검증`() {
        val lottoController = LottoController("14000")
        val generatedNumbers = lottoController.getRandomGeneratedNumbers()
        assertThat(generatedNumbers.toSet().size == LOTTO_NUMBER_COUNT)
    }

    @Test
    fun `구매한 금액만큼의 로또 개수`() {
        assertThat(LottoController("14000").getPaidLottoCount()).isEqualTo(14)
        assertThat(LottoController("1000").getPaidLottoCount()).isEqualTo(1)
    }
}
