package lotto

import lotto.domain.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun `일치하는 번호가 3개인 경우 4등`() {
        assertThat(Prize.findPrize(3)).isEqualTo(Prize.FOURTH)
    }

    @Test
    fun `일치하는 번호가 4개인 경우 3등`() {
        assertThat(Prize.findPrize(4)).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `일치하는 번호가 5개인 경우 2등`() {
        assertThat(Prize.findPrize(5)).isEqualTo(Prize.SECOND)
    }

    @Test
    fun `일치하는 번호가 6개인 경우 1등`() {
        assertThat(Prize.findPrize(6)).isEqualTo(Prize.FIRST)
    }
}
