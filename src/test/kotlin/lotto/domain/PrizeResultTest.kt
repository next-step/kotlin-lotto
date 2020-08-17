package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class PrizeResultTest {

    @Test
    fun `로또 번호 3개가 일치하면 5_000원이다`() {
        val prize = PrizeResult.FIFTH.prize
        assertThat(prize).isEqualTo(5000)
    }

    @Test
    fun `로또 번호 4개가 일치하면 50_000원이다`() {
        val prize = PrizeResult.FORTH.prize
        assertThat(prize).isEqualTo(50_000)
    }

    @Test
    fun `로또 번호 5개가 일치하면 1_500_000원이다`() {
        val prize = PrizeResult.THIRD.prize
        assertThat(prize).isEqualTo(1_500_000)
    }

    @Test
    fun `로또 번호 6개가 일치하면 2_000_000_000이다`() {
        val prize = PrizeResult.FIRST.prize
        assertThat(prize).isEqualTo(2_000_000_000)
    }

    @Test
    fun `로또 번호 5개와 보너스번호가 일치하면 30_000_000이다`() {
        val prize = PrizeResult.SECOND_WITH_BONUS.prize
        assertThat(prize).isEqualTo(30_000_000)
    }

    @ParameterizedTest
    @MethodSource("generateTestData")
    fun `번호 매칭 개수와 보너스 번호 당첨 여부가 주어지면 당첨 결과를 알려준다`(
        matchedCount: Int,
        isBonusNumberMatched: Boolean,
        prizeResult: PrizeResult
    ) {
        assertThat(PrizeResult.findByMatch(matchedCount, isBonusNumberMatched)).isEqualTo(prizeResult)
    }

    @Test
    fun `사용자가 당첨된 결과가 3개, 5개 일치 일 때 총 당첨금은 1_505_000 이다`() {
        result[PrizeResult.THIRD] = 1
        result[PrizeResult.FIFTH] = 1
        assertThat(PrizeResult.winningPrize()).isEqualTo(1_505_000)
    }

    companion object {
        @JvmStatic
        fun generateTestData(): List<Arguments> {
            return listOf(
                Arguments.of(5, true, PrizeResult.SECOND_WITH_BONUS),
                Arguments.of(5, false, PrizeResult.THIRD)
            )
        }
    }
}
