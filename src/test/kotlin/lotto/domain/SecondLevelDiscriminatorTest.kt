package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class SecondLevelDiscriminatorTest {

    @Test
    fun `3등일때 남은 숫자가 보너스 넘버와 같은지 체크한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val lotteryPaper = LotteryPaper(lottoNumbers)
        val bonusNumber = LottoNumber(7)

        val actual = SecondLevelDiscriminator.checkPrizeLevelIsSecond(
            prizeLevel = PrizeLevel.THIRD,
            lotteryPaper = lotteryPaper,
            bonusNumber = bonusNumber
        )

        Assertions.assertThat(actual).isEqualTo(PrizeLevel.THIRD)
    }

    @ParameterizedTest
    @ValueSource(strings = ["NONE", "FIFTH", "FOURTH", "SECOND", "FIRST"])
    fun `3등이 아니면 체크하지않는다`(prizeLevel: PrizeLevel) {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }
        val lotteryPaper = LotteryPaper(lottoNumbers)
        val bonusNumber = LottoNumber(7)

        val actual = SecondLevelDiscriminator.checkPrizeLevelIsSecond(
            prizeLevel = prizeLevel,
            lotteryPaper = lotteryPaper,
            bonusNumber = bonusNumber
        )

        Assertions.assertThat(actual).isEqualTo(prizeLevel)
    }
}
