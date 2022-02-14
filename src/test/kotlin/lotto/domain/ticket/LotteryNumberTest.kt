package lotto.domain.ticket

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

@DisplayName("로또 복권 티켓의 번호를 담당하는 객체 `LotteryNumber` 테스트")
internal class LotteryNumberTest {
    @DisplayName("아무런 번호도 주어지지 않으면 1부터 45 사이의 값 중의 무작위로 `LotteryNumber` 객체 생성")
    @Test
    fun createALotteryNumberFromValueInTheRangeOneToFortyFiveIsSuccess_IfGivenNothing() {
        // Arrange
        // Act
        val lotteryNumber = LotteryNumber()

        // Assert
        assertThat(lotteryNumber.value).isBetween(START_RANGE, END_RAGE)
    }

    @DisplayName("1부터 45 사이의 값이 주어지면 해당 값으로 `LotteryNumber` 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 5, 10, 17, 28, 39, 43, 44, 45])
    fun createALotteryNumber_IfGivenValueInTheRangeOneToFortyFive(givenNumbers: Int) {
        // Arrange
        // Act
        val lotteryNumber = LotteryNumber(givenNumbers)

        // Assert
        assertThat(lotteryNumber.value).isEqualTo(givenNumbers)
    }

    @DisplayName("1보다 작거나 45보다 큰 값이 주어지면  `LotteryNumber` 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = [-200, -8 -1, 0, 46, 50, 101, 800, 1_000_000])
    fun createALotteryNumber_IfGivenValueThatIsSmallerThanOneOrGreaterThanFortyFive(givenNumbers: Int) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            val lotteryNumber = LotteryNumber(givenNumbers)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(FAILED_REQUIREMENT_ERROR_MESSAGE)
    }

    companion object {
        private const val START_RANGE = 1
        private const val END_RAGE = 45
        private const val FAILED_REQUIREMENT_ERROR_MESSAGE : String = "Failed requirement."
    }
}
