package lotto.domain.ticket.lottery

import lotto.domain.ticket.lottery.LotteryNumber.Companion.ENDING_VALUE
import lotto.domain.ticket.lottery.LotteryNumber.Companion.STARTING_VALUE
import lotto.domain.ticket.lottery.LotteryNumbers.Companion.LOTTERY_NUMBERS_SIZE
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

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
}
