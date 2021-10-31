package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoPrize
import lotto.domain.LottoResults
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultsTest {

    @Test
    fun `1등 상품과 일치하는지 테스트`() {
        // given
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)
        val lottoResults = LottoResults.matchingWinningNumber(
            purchasedLottos = listOf(
                Lotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6))),
                Lotto(LottoNumber(listOf(1, 5, 7, 10, 12, 17)))
            ),
            winningNumber = winningNumber
        )

        // when
        val firstPrize = LottoPrize.FIRST.prize
        val correspondLottoResult = lottoResults.toList().first() {
            val lottoPrize = it.prizeAndCountPair().first
            lottoPrize.prize == firstPrize
        }

        // then
        assertThat(correspondLottoResult.prizeAndCountPair().first.prize).isEqualTo(firstPrize)
    }
}
