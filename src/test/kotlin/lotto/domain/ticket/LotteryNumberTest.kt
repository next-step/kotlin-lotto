package lotto.domain.ticket

import lotto.domain.ticket.LotteryNumber.Companion.ENDING_VALUE
import lotto.domain.ticket.LotteryNumber.Companion.ERR_INVALID_VALUE
import lotto.domain.ticket.LotteryNumber.Companion.STARTING_VALUE
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
    fun `create a LotteryNumber that is included in the range one to forty five if given nothing`() {
        // Arrange
        // Act
        val lotteryNumber = LotteryNumber()

        // Assert
        assertThat(lotteryNumber.value).isBetween(STARTING_VALUE, ENDING_VALUE)
    }

    @DisplayName("1부터 45 사이의 값이 주어지면 해당 값으로 `LotteryNumber` 객체 생성")
    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 5, 10, 17, 28, 39, 43, 44, 45])
    fun `create a LotteryNumber that is same given value if given value in the range one to forty five`(givenNumbers: Int) {
        // Arrange
        // Act
        val lotteryNumber = LotteryNumber(givenNumbers)

        // Assert
        assertThat(lotteryNumber.value).isEqualTo(givenNumbers)
    }

    @DisplayName("1보다 작거나 45보다 큰 값이 주어지면 `LotteryNumber` 객체 생성 실패")
    @ParameterizedTest
    @ValueSource(ints = [-200, -8, -1, 0, 46, 50, 101, 800, 1_000_000])
    fun `create a LotteryNumber if given value that is smaller than one or greater than forty five`(givenNumbers: Int) {
        // Arrange
        // Act
        // Assert
        assertThatThrownBy() {
            LotteryNumber(givenNumbers)
        }.isInstanceOf(IllegalArgumentException::class.java)
            .hasMessageContaining(ERR_INVALID_VALUE)
    }
}
