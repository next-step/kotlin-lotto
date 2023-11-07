@file:Suppress("NonAsciiCharacters")

package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PurchasedLottosTest {
    @Test
    fun `지난주 당첨 번호를 입력하면 당첨 통계를 반환한다`() {
        val purchaseAmount = Lotto.PRICE
        val lotto = Lotto(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6),
            )
        )
        val winningNumbers = WinningNumbers(
            listOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(7),
            )
        )
        val purchasedLottos = PurchasedLottos(listOf(lotto), purchaseAmount)

        val actual = purchasedLottos.draw(winningNumbers)

        assertThat(actual).usingRecursiveComparison()
            .isEqualTo(
                WinningStatistic(
                    prizes = listOf(Prize.valueOfOrNull(5)!!),
                    purchaseAmount = purchaseAmount,
                )
            )
    }
}
