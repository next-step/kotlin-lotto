package lotto.domain.ticket

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
    }
}
