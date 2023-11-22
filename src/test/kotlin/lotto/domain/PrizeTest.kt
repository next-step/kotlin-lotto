package lotto.domain

import lotto.domain.Prize.*
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class PrizeTest {
    @ParameterizedTest
    @MethodSource("arrangeOfTest")
    fun `Prize 객체 생성`(amountOfNumberMatched: Int, expected: Prize) {
        assertThat(Prize.of(amountOfNumberMatched)).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun arrangeOfTest(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(6, FIRST_PRIZE),
                Arguments.of(5, SECOND_PRIZE),
                Arguments.of(4, THIRD_PRIZE),
                Arguments.of(3, FOURTH_PRIZE),
                Arguments.of(2, NONE),
                Arguments.of(1, NONE),
                Arguments.of(0, NONE),
            )
        }
    }
}
