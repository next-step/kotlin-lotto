package lotto.model

import lotto.model.LottoPrize.SECOND
import lotto.model.LottoPrize.THIRD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPrizeTest {
    @Test
    internal fun `당첨결과 생성`() {
        val third = LottoPrize.of(5, false)
        val second = LottoPrize.of(5, true)
        assertThat(third).isSameAs(THIRD)
        assertThat(second).isSameAs(SECOND)
    }
}
