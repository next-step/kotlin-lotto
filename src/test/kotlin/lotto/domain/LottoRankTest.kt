package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LottoRankTest {

    private lateinit var winningLottoNumber: List<Int>

    @BeforeEach
    fun setup() {
        winningLottoNumber = listOf(1, 2, 3, 4, 5, 6)
    }

    @Test
    fun `로또의 4등이 되는 경우`() {
        assertThat(LottoRank.matchRank(3)).isEqualTo(LottoRank.FOURTH)
    }

    @Test
    fun `로또의 3등이 되는 경우`() {
        assertThat(LottoRank.matchRank(4)).isEqualTo(LottoRank.THIRD)
    }

    @Test
    fun `로또의 2등이 되는 경우`() {
        assertThat(LottoRank.matchRank(5)).isEqualTo(LottoRank.SECOND)
    }

    @Test
    fun `로또의 1등이 되는 경우`() {
        assertThat(LottoRank.matchRank(6)).isEqualTo(LottoRank.FIRST)
    }
}
