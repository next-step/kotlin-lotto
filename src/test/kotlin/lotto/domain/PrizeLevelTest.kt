package lotto.domain

import lotto.dto.LottoMatchResult
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class PrizeLevelTest {

    @Test
    fun `로또 번호가 맞은 갯수를 가지고 등수를 계산한다`() {
        val listOfNumberOfHit = listOf(1, 3, 1, 6)
        val lotteryPaper = LotteryPaper(
            listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        )
        val bonusNumber = LottoNumber(7)

        val actual = listOfNumberOfHit.map { PrizeLevel.fromNumberOfHit(it, lotteryPaper, bonusNumber) }

        val answer = listOf(
            PrizeLevel.NONE,
            PrizeLevel.FIFTH,
            PrizeLevel.NONE,
            PrizeLevel.FIRST
        )
        Assertions.assertThat(actual).isEqualTo(answer)
    }

    @Test
    fun `로또 등수 리스트를 입력받아서 통계를 낸다`() {
        val listOfPrizeLevel = listOf(
            PrizeLevel.NONE,
            PrizeLevel.FOURTH,
            PrizeLevel.NONE,
            PrizeLevel.FIRST,
            PrizeLevel.FIRST,
            PrizeLevel.SECOND
        )

        val actual = LottoMatchResult.countPrizeLevels(listOfPrizeLevel)
        val answer = mapOf(
            PrizeLevel.FIRST to 2,
            PrizeLevel.SECOND to 1,
            PrizeLevel.FOURTH to 1
        )

        Assertions.assertThat(actual).isEqualTo(answer)
    }

    @Test
    fun `3등일때 남은 숫자가 보너스 넘버와 같으면 2등을 리턴한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }
        val lotteryPaper = LotteryPaper(lottoNumbers)
        val bonusNumber = LottoNumber(7)

        val actual = PrizeLevel.fromNumberOfHit(
            5,
            lotteryPaper,
            bonusNumber = bonusNumber
        )

        Assertions.assertThat(actual).isEqualTo(PrizeLevel.SECOND)
    }

    @Test
    fun `3등일때 남은 숫자가 보너스 넘버와 다르면 3등을 리턴한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val lotteryPaper = LotteryPaper(lottoNumbers)
        val bonusNumber = LottoNumber(7)

        val actual = PrizeLevel.fromNumberOfHit(
            5,
            lotteryPaper,
            bonusNumber = bonusNumber
        )

        Assertions.assertThat(actual).isEqualTo(PrizeLevel.THIRD)
    }
}
