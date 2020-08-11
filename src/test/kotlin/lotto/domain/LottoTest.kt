package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    @BeforeEach
    fun before() {
        PrizeGenerator.THREE_MATCH.count = 0
        PrizeGenerator.FOUR_MATCH.count = 0
        PrizeGenerator.FIVE_MATCH.count = 0
        PrizeGenerator.BONUS_MATCH.count = 0
        PrizeGenerator.SIX_MATCH.count = 0
    }

    @Test
    fun `생성한 로또 번호가 1-45 범위 안에 있는지 확인`() {
        assertThat(IntRange(1, 45).toList().containsAll(Lotto.of().numbers)).isTrue()
    }

    @Test
    fun `생성한 로또 번호는 중복이 될 수 없다`() {
        assertThat(Lotto.of().numbers.distinct().size).isEqualTo(6)
    }

    @ParameterizedTest
    @MethodSource("generateSecondsTestData")
    fun `로또 번호, 당첨 번호와 보너스 번호가 주어질 때 2등 당첨인 경우, 2등 로또 카운트는 1이다`(
        lotto: Set<Int>,
        winningLotto: WinningLotto,
        expected: Int
    ) {
        Lotto(lotto).countWinningNumber(winningLotto)

        assertThat(PrizeGenerator.BONUS_MATCH.count).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun generateSecondsTestData(): List<Arguments> {
            return listOf(
                Arguments.of(setOf(1, 2, 3, 4, 5, 6), WinningLotto(setOf(1, 2, 3, 4, 5, 7), 6), 1)
            )
        }
    }
}
