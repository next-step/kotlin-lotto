package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LotteryNumbersTest {
    @Test
    fun `6개의 로또 번호를 가진다`() {
        val lotteryNumbers = LotteryNumbers(listOf(1, 2, 3, 4, 5, 6))

        assertThat(lotteryNumbers.numbers).containsExactlyInAnyOrder(
            LotteryNumber.from(1),
            LotteryNumber.from(2),
            LotteryNumber.from(3),
            LotteryNumber.from(4),
            LotteryNumber.from(5),
            LotteryNumber.from(6)
        )
    }

    @ParameterizedTest
    @MethodSource("wrongSizeLotteryNumbers")
    fun `로또 번호의 개수가 6개가 아니면 생성되지 않는다`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            LotteryNumbers(numbers)
        }
    }

    companion object {
        @JvmStatic
        fun wrongSizeLotteryNumbers(): Stream<Arguments> =
            Stream.of(
                Arguments.of(1, 2, 3, 3, 5, 6, 7),
                Arguments.of(4, 10, 25, 34),
                Arguments.of(4),
                Arguments.of()
            )
    }
}
