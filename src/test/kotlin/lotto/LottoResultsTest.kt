package lotto

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

    @Test
    fun `일치하는 로또가 없는 경우`() {
        // given
        val lottoResults = LottoResults(
            purchasedLottos = listOf(
                Lotto(listOf(1, 2, 3, 4, 5, 6)),
                Lotto(listOf(1, 5, 7, 10, 12, 17)),
                Lotto(listOf(1, 5, 7, 11, 12, 17)),
                Lotto(listOf(1, 5, 7, 10, 16, 20))
            )
        )
        val winningNumber = listOf(1, 2, 3, 4, 5, 6)

        // when
        val correspondLottoResult = lottoResults.result(winningNumber)

        // then
        correspondLottoResult.forEach {
            val count = it.prizeAndCountPair().second
            assertThat(count).isEqualTo(0)
        }
    }
}
