package lotto.domain.ticket.lottery

import lotto.domain.ticket.lottery.LotteryNumber.Companion.ENDING_VALUE
import lotto.domain.ticket.lottery.LotteryNumber.Companion.STARTING_VALUE
import lotto.domain.ticket.lottery.LotteryNumbers.Companion.LOTTERY_NUMBERS_SIZE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("로또 복권 티켓의 한 게임 내의 번호 묶음을 담당하는 객체 `LotteryNumbers` 테스트")
internal class LotteryNumbersTest {

    @DisplayName("자동 생성 시 1부터 45 사이의 값으로 구성된 `LotteryNumbers` 객체 생성")
    @Test
    fun `create a LotteryNumbers that is included in the range one to forty five if auto-generated`() {
        // Arrange
        // Act
        val lotteryNumbers = LotteryNumbers.quickPick()

        // Assert
        lotteryNumbers.values
            .forEach { lotteryNumberValue ->
                assertThat(lotteryNumberValue).isBetween(STARTING_VALUE, ENDING_VALUE)
            }
    }

    @DisplayName("자동 생성 시 1부터 45 사이의 값 중 중복되지 않게 구성된 `LotteryNumbers` 객체 생성")
    @Test
    fun `create a LotteryNumbers that is not duplicate if auto-generated`() {
        // Arrange
        val lotteryNumbers = LotteryNumbers.quickPick()

        // Act
        val valueSet = lotteryNumbers.values.toSet()

        // Assert
        assertThat(lotteryNumbers.size).isEqualTo(valueSet.size)
    }

    @DisplayName("자동 생성 시 생성된 `LotteryNumbers` 객체 내 `LotteryNumbers` 의 개수는 6인 것을 확인")
    @Test
    fun `assert lotteryNumbers size is 6 in LotteryNumbers if create a LotteryNumbers`() {
        // Arrange
        // Act
        val lotteryNumberValuesSize = LotteryNumbers.quickPick().size

        // Assert
        assertThat(lotteryNumberValuesSize).isEqualTo(LOTTERY_NUMBERS_SIZE)
    }

    @DisplayName("주어진 `WinningNumber`들과 일치하는 `LotteryNumbers`의 개수 반환")
    @ParameterizedTest
    @MethodSource("lotteryNumbersAndWinningNumbersAndExpectedMatchingCount")
    fun `return number of matches if given winning numbers`(
        givenLotteryNumbers: List<Int>,
        givenWinningNumbers: List<Int>,
        expectedNumberOfMatches: Int
    ) {
        // Arrange
        val lotteryNumbers = LotteryNumbers.of(givenLotteryNumbers)
        val winningLotteryNumbers = LotteryNumbers.of(givenWinningNumbers)

        // Act
        val numberOfBingo = lotteryNumbers.numberOfMatchesWithWinningNumbers(winningLotteryNumbers)

        // Assert
        assertThat(numberOfBingo).isEqualTo(expectedNumberOfMatches)
    }

    companion object {
        @JvmStatic
        fun lotteryNumbersAndWinningNumbersAndExpectedMatchingCount(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(7, 8, 9, 10, 11, 12),
                    0
                ),
                Arguments.of(
                    listOf(11, 12, 23, 26, 35, 42),
                    listOf(18, 19, 30, 31, 43, 44),
                    0
                ),
                Arguments.of(
                    listOf(11, 42, 13, 37, 38, 4),
                    listOf(17, 29, 3, 45, 36, 18),
                    0
                ),
                Arguments.of(
                    listOf(12, 22, 33, 40, 41, 45),
                    listOf(11, 21, 32, 41, 43, 44),
                    1
                ),
                Arguments.of(
                    listOf(45, 22, 14, 13, 12, 27),
                    listOf(14, 8, 9, 36, 38, 20),
                    1
                ),
                Arguments.of(
                    listOf(21, 22, 23, 24, 25, 26),
                    listOf(21, 22, 30, 31, 32, 33),
                    2
                ),
                Arguments.of(
                    listOf(2, 22, 23, 26, 25, 19),
                    listOf(21, 40, 41, 24, 19, 2),
                    2
                ),
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(4, 5, 6, 7, 8, 9),
                    3
                ),
                Arguments.of(
                    listOf(41, 22, 13, 8, 15, 36),
                    listOf(41, 36, 22, 7, 19, 9),
                    3
                ),
                Arguments.of(
                    listOf(1, 2, 13, 24, 35, 36),
                    listOf(1, 2, 13, 23, 35, 37),
                    4
                ),
                Arguments.of(
                    listOf(36, 22, 23, 14, 35, 25),
                    listOf(21, 22, 23, 43, 35, 36),
                    4
                ),
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 7),
                    5
                ),
                Arguments.of(
                    listOf(31, 22, 13, 24, 35, 41),
                    listOf(31, 22, 13, 44, 35, 41),
                    5
                ),
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 6),
                    6
                ),
                Arguments.of(
                    listOf(22, 33, 18, 19, 20, 45),
                    listOf(45, 20, 18, 19, 33, 22),
                    6
                )
            )
    }
}
