package lotto

import lotto.domain.Prize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class PrizeTest {
    @Test
    fun `일치하는 번호가 3개인 경우 5등`() {
        assertThat(Prize.findPrize(3, false)).isEqualTo(Prize.FIFTH)
    }

    @Test
    fun `일치하는 번호가 4개인 경우 4등`() {
        assertThat(Prize.findPrize(4, false)).isEqualTo(Prize.FOURTH)
    }

    @Test
    fun `일치하는 번호가 5개인 경우 3등`() {
        assertThat(Prize.findPrize(5, false)).isEqualTo(Prize.THIRD)
    }

    @Test
    fun `일치하는 번호가 5개이고 보너스 숫자까지 맞춘 경우 2등`() {
        assertThat(Prize.findPrize(5, true)).isEqualTo(Prize.SECOND)
    }

    @Test
    fun `일치하는 번호가 6개인 경우 1등`() {
        assertThat(Prize.findPrize(6, false)).isEqualTo(Prize.FIRST)
    }
}
