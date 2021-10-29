package lotto

import lotto.domain.Lotto
import lotto.domain.LottoPrize
import lotto.domain.LottoResults
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultsTest {

    @Test
    fun `1등 상품과 일치하는지 테스트`() {
        // given
        val lottoResults = LottoResults(
            purchasedLottos = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 5, 7, 10, 12, 17))
            )
        )

        val winningNumber = listOf(1, 2, 3, 4, 5, 6)

        // when
        val firstPrize = LottoPrize.FIRST.prize
        val correspondLottoResult = lottoResults.result(winningNumber).first() {
            it.prizeAndCountPair().first == firstPrize
        }

        // then
        assertThat(correspondLottoResult.prizeAndCountPair().first).isEqualTo(firstPrize)
    }
}
