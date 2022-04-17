package lotto.domain.ticket

import lotto.domain.matching.LottoMatching
import lotto.domain.matching.LottoMatching.FIRST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.FOURTH_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.LAST_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.SECOND_PLACE_MATCHING
import lotto.domain.matching.LottoMatching.THIRD_PLACE_MATCHING
import lotto.domain.ticket.lottery.LotteryNumbers
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("로또 복권 당첨 번호를 의미하는 객체 `WinningLottoNumbers` 테스트")
internal class WinningLottoNumbersTest {

    @DisplayName("로또 복권의 당첨 번호 `LotteryNumbers`가 주어지면 `WinningLottoNumbers` 객체 생성")
    @ParameterizedTest
    @MethodSource("winningNumbers")
    fun `create WinningLottoNumbers if given LotteryNumbers`(winningNumbers: List<Int>) {
        // Arrange
        // Act
        val winningLottoNumbers = WinningLottoNumbers(LotteryNumbers.of(winningNumbers))

        // Assert
        assertThat(winningLottoNumbers.values).hasSameElementsAs(winningNumbers)
    }

    @DisplayName("`LottoGame`이 주어지면 `WinningLottoNumbers`와 비교해 당첨된 수를 `LottoMatching`으로 반환")
    @ParameterizedTest
    @MethodSource("winningNumbersAndLotteryNumbersAndExpectedLottoMatching")
    fun `return number of matches winning number if given LottoGame`(
        winningNumbers: List<Int>,
        lotteryNumbers: List<Int>,
        expectedLottoMatching: LottoMatching
    ) {
        // Arrange
        val lottoGame = LottoGame.of(LotteryNumbers.of(lotteryNumbers))
        val winningLottoNumbers = WinningLottoNumbers(LotteryNumbers.of(winningNumbers))

        // Act
        val matching = winningLottoNumbers.numberOfMatchesWithWinningNumbers(lottoGame)

        // Assert
        assertThat(matching).isEqualTo(expectedLottoMatching)
    }

    companion object {
        @JvmStatic
        fun winningNumbers(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(21, 12, 43, 44, 15, 16)),
                Arguments.of(listOf(7, 17, 23, 34, 35, 36)),
                Arguments.of(listOf(11, 20, 30, 14, 15, 45)),
                Arguments.of(listOf(45, 7, 8, 9, 25, 22)),
                Arguments.of(listOf(31, 32, 13, 4, 45, 26)),
            )

        @JvmStatic
        fun winningNumbersAndLotteryNumbersAndExpectedLottoMatching(): Stream<Arguments> =
            Stream.of(
                Arguments.of(
                    listOf(1, 2, 3, 4, 5, 6),
                    listOf(1, 2, 3, 4, 5, 6),
                    FIRST_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(11, 32, 23, 14, 45, 6),
                    listOf(11, 32, 23, 14, 45, 6),
                    FIRST_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(1, 5, 7, 19, 20, 39),
                    listOf(39, 20, 19, 7, 5, 1),
                    FIRST_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(21, 12, 43, 44, 15, 16),
                    listOf(21, 12, 43, 44, 1, 15),
                    SECOND_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(8, 9, 10, 14, 22, 36),
                    listOf(36, 22, 14, 10, 9, 7),
                    SECOND_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(1, 12, 43, 44, 15, 16),
                    listOf(21, 12, 43, 44, 1, 15),
                    SECOND_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(7, 17, 23, 34, 40, 42),
                    listOf(1, 16, 23, 34, 40, 42),
                    THIRD_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(4, 5, 10, 34, 38, 42),
                    listOf(42, 38, 33, 9, 5, 4),
                    THIRD_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(2, 3, 29, 33, 44, 45),
                    listOf(2, 3, 30, 33, 43, 45),
                    THIRD_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(11, 20, 30, 14, 15, 45),
                    listOf(10, 20, 29, 14, 16, 45),
                    FOURTH_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(2, 8, 9, 14, 35, 45),
                    listOf(2, 8, 9, 13, 34, 44),
                    FOURTH_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(7, 9, 20, 22, 33, 41),
                    listOf(41, 33, 21, 19, 8, 7),
                    FOURTH_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(45, 7, 8, 9, 25, 22),
                    listOf(45, 6, 2, 3, 24, 29),
                    LAST_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(31, 32, 13, 4, 45, 26),
                    listOf(31, 32, 12, 14, 44, 25),
                    LAST_PLACE_MATCHING
                ),
                Arguments.of(
                    listOf(2, 4, 19, 22, 38, 39),
                    listOf(3, 6, 8, 15, 43, 25),
                    LAST_PLACE_MATCHING
                ),
            )
    }
}
