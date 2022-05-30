package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

@DisplayName("당첨 여부 확인")
internal class WinningNumbersTest {

    @Test
    fun `당첨 번호 정상 생성`() {
        val numbers = listOf(1, 2, 3, 4, 5, 6)
        val winningNumbers = WinningNumbers(numbers, 7)
        assertThat(winningNumbers.compare(listOf(LottoTicket(numbers)))).containsKey(LottoPrize.FIRST)
    }

    @Test
    fun `당첨 번호의 갯수가 6개가 아닌 경우`() {
        assertThrows<IllegalArgumentException> { WinningNumbers(listOf(1, 2, 3, 4, 5), 6) }
    }

    @Test
    fun `당첨 번호와 보너스 번호가 중복되는 경우`() {
        assertThrows<IllegalArgumentException> { WinningNumbers(listOf(1, 2, 3, 4, 5, 6), 6) }
    }

    @ParameterizedTest(name = "등수: {3}, 로또: {0}, 당첨: {1},({2})")
    @MethodSource("테스트 번호")
    fun `1 ~ 5등 당첨에 따른 정보가 맵에 담긴다`(numbers: List<Int>, winning: List<Int>, bonus: Int, prize: LottoPrize) {

        val winningNumbers = WinningNumbers(winning, bonus)

        // when
        val result = winningNumbers.compare(listOf(LottoTicket(numbers)))

        // then
        assertThat(result).containsKey(prize)
    }

    companion object {
        @JvmStatic
        fun `테스트 번호`() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 7, LottoPrize.FIRST),
            Arguments.of(listOf(1, 2, 3, 4, 5, 7), listOf(1, 2, 3, 4, 5, 6), 7, LottoPrize.SECOND),
            Arguments.of(listOf(1, 2, 3, 4, 5, 45), listOf(1, 2, 3, 4, 5, 6), 7, LottoPrize.THIRD),
            Arguments.of(listOf(1, 2, 3, 4, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, LottoPrize.FOURTH),
            Arguments.of(listOf(1, 2, 3, 43, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, LottoPrize.FIFTH),
            Arguments.of(listOf(1, 2, 42, 43, 44, 45), listOf(1, 2, 3, 4, 5, 6), 7, LottoPrize.MISS),
        )
    }
}
