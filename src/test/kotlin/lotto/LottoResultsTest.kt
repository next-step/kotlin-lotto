package lotto

import lotto.domain.Lotto
import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import lotto.domain.LottoPrize
import lotto.domain.LottoResults
import lotto.domain.Lottos
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoResultsTest {

    @Test
    fun `1등 상품과 일치하는 로또가 하나 있는지 테스트`() {
        // given
        val winningNumber = LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottoResults = LottoResults.matchingWinningNumber(
            purchasedLottos = Lottos.from(
                listOf(
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 5, 7, 10, 12, 17)))
                )
            ),
            winningLottoNumbers = winningNumber,
            bonusLottoNumber = LottoNumber(7)

        )

        // when
        val firstPrize = LottoPrize.FIRST.prize
        val correspondLottoResult = lottoResults.getResults().first() {
            val lottoPrize = it.prizeAndCountPair().first
            lottoPrize.prize == firstPrize
        }

        // then
        assertThat(correspondLottoResult.prizeAndCountPair().first.prize).isEqualTo(firstPrize)
    }

    @Test
    fun `2등 상품과 일치하는 로또가 하나 있는지 테스트`() {
        // given
        val winningNumber = LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6))
        val lottoResults = LottoResults.matchingWinningNumber(
            purchasedLottos = Lottos.from(
                listOf(
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 7))),
                    Lotto(LottoNumbers.generateLottoNumbers(listOf(1, 5, 7, 10, 12, 17)))
                )
            ),
            winningLottoNumbers = winningNumber,
            bonusLottoNumber = LottoNumber(6)
        )

        // when
        val firstPrize = LottoPrize.SECOND.prize
        val correspondLottoResult = lottoResults.getResults().first() {
            val lottoPrize = it.prizeAndCountPair().first
            lottoPrize.prize == firstPrize
        }

        // then
        assertThat(correspondLottoResult.prizeAndCountPair().first.prize).isEqualTo(firstPrize)
    }
}
