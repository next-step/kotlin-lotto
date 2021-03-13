package domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource
import java.util.*

class LotteryNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [-1, 46, 90, -10])
    fun `0부터 45가 아닌 숫자가 들어왔을 때 예외를 처리한다`(wrongNumber: Int) {
        val mockLotteryNumber = makeMockNumberByInt(wrongNumber)

        assertThrows<IllegalArgumentException> {
            LotteryNumber.from(mockLotteryNumber)
        }
    }

    @ParameterizedTest
    @CsvSource("4, 4", "25, 25", "9, 9")
    fun `입력한 값에 대한 로또 번호를 가져온다`(number: Int, expectedNumber: Int) {
        val mockLotteryNumber = makeMockNumberByInt(number)

        val lotteryNumber = LotteryNumber.from(mockLotteryNumber)

        assertThat(lotteryNumber).isEqualTo(makeMockNumberByInt(expectedNumber).retrieveNumber())
    }

    private fun makeMockNumberByInt(number: Int) = MockNumbers(LinkedList(listOf(number)))
}
