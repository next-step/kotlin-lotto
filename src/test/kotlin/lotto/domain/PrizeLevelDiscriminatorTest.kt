package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class PrizeLevelDiscriminatorTest {

    private lateinit var prizeLevelDiscriminator: PrizeLevelDiscriminator

    @BeforeEach
    fun setUp() {
        prizeLevelDiscriminator = PrizeLevelDiscriminator()
    }

    @Test
    fun `3등일때 남은 숫자가 보너스 넘버와 다르면 3등을 리턴한다`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val lotteryPaper = LotteryPaper(lottoNumbers)
        val bonusNumber = LottoNumber(7)

        // when
        val actual = prizeLevelDiscriminator.checkIsThirdLevel(
            PrizeLevel.THIRD,
            Pair(lotteryPaper, bonusNumber)
        )

        // then
        Assertions.assertThat(actual).isEqualTo(PrizeLevel.THIRD)
    }

    @Test
    fun `3등일때 남은 숫자가 보너스 넘버와 같으면 2등을 리턴한다`() {
        // given
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 7).map { LottoNumber(it) }
        val lotteryPaper = LotteryPaper(lottoNumbers)
        val bonusNumber = LottoNumber(7)

        // when
        val actual = prizeLevelDiscriminator.checkIsThirdLevel(
            PrizeLevel.THIRD,
            Pair(lotteryPaper, bonusNumber)
        )

        // then
        Assertions.assertThat(actual).isEqualTo(PrizeLevel.SECOND)
    }
}
