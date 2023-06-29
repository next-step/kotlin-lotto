package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class SecondLevelDiscriminatorTest {

    @Test
    fun `3등일때 남은 숫자가 보너스 볼의 숫자와 같은지 체크한다`() {
        val lottoNumber = listOf(1, 2, 3, 4, 5, 6)
        val lotteryPaper = LotteryPaper(lottoNumber)
        val bonusBall = BonusBall(7, lotteryPaper)

        val actual = SecondLevelDiscriminator.checkPrizeLevelIsSecond(
            prizeLevel = PrizeLevel.THIRD,
            lotteryPaper = lotteryPaper,
            bonusBall = bonusBall
        )

        Assertions.assertThat(actual).isEqualTo(PrizeLevel.THIRD)
    }
}
