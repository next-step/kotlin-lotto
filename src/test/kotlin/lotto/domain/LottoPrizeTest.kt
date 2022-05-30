package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoPrizeTest {

    @Test
    fun `보너스 번호를 포함한 Enum 값을 추가한다`() {
        assertThat(LottoPrize.values().contains(LottoPrize.FIFTH_BONUS)).isEqualTo(true)
    }

    @Test
    fun `보너스 규칙(숫자 5 + 보너스 1개)에 부합하는 경우 보너스 Prize을 반환한다`() {
        assertThat(LottoPrize.of(matchCount = 5, matchBonus = true)).isEqualTo(LottoPrize.FIFTH_BONUS)
    }
}
