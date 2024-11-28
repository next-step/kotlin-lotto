package lotto.core

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream


class LottoTest {

    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `잘못된 값으로 로또를 만들때 발생하는 Exception을 확인한다`(numbers: List<Int>) {
        shouldThrow<IllegalArgumentException> { Lotto(numbers) }
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(1)),
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 46)),
                Arguments.of(listOf(-1, 2, 3, 4, 5, 45)),
                )
        }
    }
}