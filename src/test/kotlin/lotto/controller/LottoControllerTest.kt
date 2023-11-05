package lotto.controller

import org.junit.jupiter.api.Assertions
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
}