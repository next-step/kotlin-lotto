@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PurchasedLottosTest {
    @Test
    fun `지난주 당첨 번호를 입력하면 당첨 통계를 반환한다`() {
        val purchaseAmount = Lotto.PRICE
        val lotto = Lotto(
            numbers = (1..6).map(::LottoNumber)
        )
        val winningNumbers = WinningNumbers(
            numbers = (2..7).map(::LottoNumber)
        )
        val purchasedLottos = PurchasedLottos(listOf(lotto), purchaseAmount)
        val bonusNumber = LottoNumber(1)

        val actual = purchasedLottos.draw(winningNumbers, bonusNumber)

        assertThat(actual).usingRecursiveComparison()
            .isEqualTo(
                WinningStatistic(
                    prizes = listOf(Prize.valueOfOrNull(5, true)!!),
                    purchaseAmount = purchaseAmount,
                )
            )
    }
}
