package lotto

import lotto.domain.LottoPrizes
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertAll

class LottoPrizesTest {
    @Test
    fun `당첨 개수가 5라면 보너스 당첨 여부로 상금이 달라진다`() {
        val bonus = LottoPrizes.of(5, true)
        val noBonus = LottoPrizes.of(5, false)

        assertAll({
            assertThat(bonus.money).isEqualTo(LottoPrizes.MATCH_FIVE_PRIZES_WITH_BONUS.money)
            assertThat(noBonus.money).isEqualTo(LottoPrizes.MATCH_FIVE_PRIZES.money)
        })
    }
}
