package lotto

import lotto.domain.LottoPrizes
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

class LottoPrizesTest {
    @ParameterizedTest
    @EnumSource(LottoPrizes::class)
    fun `로또 번호 당첨 개수로부터 상금을 알아낼 수 있다`(prizes: LottoPrizes) {
        assertThat(LottoPrizes.getMoney(prizes.equalCount)).isEqualTo(prizes.money)
    }
}
