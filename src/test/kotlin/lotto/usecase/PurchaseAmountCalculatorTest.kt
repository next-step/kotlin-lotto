package lotto.usecase

import lotto.domain.Lotto
import lotto.domain.model.LottoNumber
import lotto.domain.model.LottoNumbers
import lotto.domain.model.Lottos
import lotto.domain.model.Price
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PurchaseAmountCalculatorTest {

    private val calculator = PurchaseAmountCalculator()

    @Test
    fun `로또 10장 샀을 때 1만원`() {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )
        val lottos = listOf(
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
        )
        val actual = calculator.getTotalPurchaseAmount(
            Lottos(
                automaticLottos = lottos,
                passivityLottos = emptyList(),
            )
        )

        assertEquals(10000, actual)
    }

    @Test
    fun `로또 20장 샀을 때 2만원`() {
        val numbers = listOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(4),
            LottoNumber(5),
            LottoNumber(6),
        )

        val lottos = listOf(
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
            Lotto(LottoNumbers(numbers), Price(1000)),
        )
        val actual = calculator.getTotalPurchaseAmount(
            Lottos(
                automaticLottos = lottos,
                passivityLottos = emptyList(),
            )
        )

        assertEquals(20000, actual)
    }
}
