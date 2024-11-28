package lotto.core

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningNumbersTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `생성자에 잘못된 값 전달 시 오류를 확인한다`(
        numberList: List<Int>,
        bonusNumber: Int,
    ) {
        shouldThrow<IllegalArgumentException> {
            WinningNumbers(numberList, bonusNumber)
        }
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1), 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7), 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), -1),
                Arguments.of(listOf(1, 2, 3, 4, 5, 46), 45),
                Arguments.of(listOf(-1, 2, 3, 4, 5, 40), 45),
            )
        }
    }
}
