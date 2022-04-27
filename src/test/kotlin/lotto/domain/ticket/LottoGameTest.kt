package lotto.domain.ticket

import lotto.domain.ticket.lottery.LotteryNumber.Companion.ENDING_VALUE
import lotto.domain.ticket.lottery.LotteryNumber.Companion.STARTING_VALUE
import lotto.domain.ticket.lottery.LotteryNumbers
import lotto.domain.ticket.lottery.LotteryNumbers.Companion.LOTTERY_NUMBERS_SIZE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@DisplayName("로또 복권 티켓의 한 게임을 의미하는 객체 `LottoGame` 테스트")
internal class LottoGameTest {

    @DisplayName("로또 복권 티켓의 한 게임을 자동 생성 시 중복된 값을 갖지 않는 `LottoGame` 객체 생성")
    @Test
    fun `auto-generated LottoGame`() {
        // Arrange
        // Act
        val lottoGame = LottoGame.quickPick()

        val valueSet = lottoGame.value.toSet()

        // Assert
        assertThat(valueSet.size).isEqualTo(LOTTERY_NUMBERS_SIZE)
    }

    @DisplayName("`LottoGame` 객체의 `value` 함수는 ${STARTING_VALUE}부터 $ENDING_VALUE 사이의 값을 가진 숫자 리스트를 반환")
    @Test
    fun `value-function return value that is included in the range one to forty five if auto create LottoGame`() {
        // Arrange
        // Act
        val lottoGame = LottoGame.quickPick()

        val lotteryNumbers = lottoGame.value

        // Assert
        lotteryNumbers.forEach { lotteryNumberValue ->
            assertThat(lotteryNumberValue).isBetween(STARTING_VALUE, ENDING_VALUE)
        }
    }

    @DisplayName("`LotteryNumbers`가 주어지면 해당 값을 가진 `LottoGame` 객체 생성")
    @ParameterizedTest
    @MethodSource("lotteryNumberList")
    fun `create LottoGame with given LotteryNumbers`(lotteryNumberList: List<Int>) {
        // Arrange
        val lotteryNumbers = LotteryNumbers.of(lotteryNumberList)

        // Act
        val lottoGame = LottoGame.of(lotteryNumbers)

        // Assert
        assertThat(lottoGame.value).hasSameElementsAs(lotteryNumbers.values)
    }

    companion object {
        @JvmStatic
        fun lotteryNumberList(): Stream<Arguments> =
            Stream.of(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
                Arguments.of(listOf(20, 12, 33, 14, 35, 42)),
                Arguments.of(listOf(11, 17, 20, 34, 39, 45)),
                Arguments.of(listOf(2, 3, 4, 19, 40, 43)),
                Arguments.of(listOf(8, 9, 10, 24, 26, 38)),
                Arguments.of(listOf(3, 9, 12, 28, 33, 37)),
            )
    }
}
