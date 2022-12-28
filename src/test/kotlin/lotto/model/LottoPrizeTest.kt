package lotto.model

import lotto.model.LottoPrize.FOURTH
import lotto.model.LottoPrize.SECOND
import lotto.model.LottoPrize.THIRD
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoPrizeTest {
    @Test
    internal fun `당첨결과 생성`() {
        // given, when
        val third = LottoPrize.of(5, false)
        val second = LottoPrize.of(5, true)
        val fourth1 = LottoPrize.of(4, true)
        val fourth2 = LottoPrize.of(4, false)

        // then
        assertThat(third).isSameAs(THIRD)
        assertThat(second).isSameAs(SECOND)
        assertThat(fourth1).isSameAs(FOURTH)
        assertThat(fourth2).isSameAs(FOURTH)
    }
}
