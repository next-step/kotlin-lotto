package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.LottoNumbers
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseAmountCalculatorTest {

    private val calculator = PurchaseAmountCalculator()

    @Test
    fun `로또 10장 샀을 때 1만원`() {
        val lottos = listOf(
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
        )
        val actual = calculator.getTotalPurchaseAmount(lottos)

        assertEquals(10000, actual)
    }

    @Test
    fun `로또 20장 샀을 때 2만원`() {
        val lottos = listOf(
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
            Lotto(LottoNumbers(listOf(1, 2, 3, 4, 5, 6)), 1000),
        )
        val actual = calculator.getTotalPurchaseAmount(lottos)

        assertEquals(20000, actual)
    }
}
