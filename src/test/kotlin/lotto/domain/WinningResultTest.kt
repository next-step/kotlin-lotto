package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningResultTest {
    private lateinit var ranks: List<Rank>
    private lateinit var shouldBeResult: Map<Rank, Int>

    @DisplayName("로또 등수 결과를 2등, 5등, 5등, 당첨되지 않은 등수로 세팅한다")
    @BeforeEach
    fun `set up`() {
        // given
        ranks = listOf(
            Rank.SECOND,
            Rank.FIFTH,
            Rank.FIFTH,
            Rank.ELSE
        )

        shouldBeResult = mapOf(
            Rank.FIFTH to 2,
            Rank.FOURTH to 0,
            Rank.THIRD to 0,
            Rank.SECOND to 1,
            Rank.FIRST to 0
        )
    }

    @DisplayName("2, 5등이 각각 1,2씩 올라간 상태로 당첨 결과를 반환한다")
    @Test
    fun `result of ranks`() {
        // when
        val result = WinningResult.resultOfRanks(ranks)

        // then
        assertThat(result).isEqualTo(shouldBeResult)
    }

    @DisplayName("2등(1개), 5등(2개)의 총 수익(30_010_000원)을 계산하여 반환한다")
    @Test
    fun `profit ratio`() {
        // when
        val earnings = WinningResult.sumOfPrizeMoney()

        // then
        assertThat(earnings).isEqualTo(30010000)
    }
}
