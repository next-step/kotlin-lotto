package lotto

import lotto.domain.LottoPrizes
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoPrizesTest {
    @Test
    fun `당첨 개수가 5라면 보너스 당첨 여부로 상금이 달라진다`() {
        val matchFive = LottoPrizes.MATCH_FIVE_PRIZES
        val catchBonus = true

        val matchFiveWithBonus = LottoPrizes.MATCH_FIVE_PRIZES_WITH_BONUS
        val failBonus = false

        assertAll({
            assertThat(LottoPrizes.getMoney(matchFiveWithBonus.equalCount, catchBonus)).isEqualTo(matchFiveWithBonus.money)
            assertThat(LottoPrizes.getMoney(matchFive.equalCount, failBonus)).isEqualTo(matchFive.money)
        })
    }
}
