package lotto.domain.ticket

import lotto.domain.ticket.lottery.LotteryNumber.Companion.ENDING_VALUE
import lotto.domain.ticket.lottery.LotteryNumber.Companion.STARTING_VALUE
import lotto.domain.ticket.lottery.LotteryNumbers.Companion.LOTTERY_NUMBERS_SIZE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@DisplayName("로또 복권 티켓의 한 게임을 의미하는 객체 `LottoGame` 테스트")
internal class LottoGameTest {

    @DisplayName("로또 복권 티켓의 한 게임을 자동 생성 시 중복된 값을 갖지 않는 `LottoGame` 객체 생성")
    @Test
    fun `auto create LottoGame`() {
        // Arrange
        // Act
        val lottoGame = LottoGame.auto()

        val valueSet = lottoGame.value.toSet()

        // Assert
        assertThat(valueSet.size).isEqualTo(LOTTERY_NUMBERS_SIZE)
    }

    @DisplayName("`LottoGame` 객체의 `value` 함수는 ${STARTING_VALUE}부터 $ENDING_VALUE 사이의 값을 가진 숫자 리스트를 반환")
    @Test
    fun `value-function return value that is included in the range one to forty five if auto create LottoGame`() {
        // Arrange
        // Act
        val lottoGame = LottoGame.auto()

        val lotteryNumbers = lottoGame.value

        // Assert
        lotteryNumbers.forEach { lotteryNumberValue ->
            assertThat(lotteryNumberValue).isBetween(STARTING_VALUE, ENDING_VALUE)
        }
    }
}
