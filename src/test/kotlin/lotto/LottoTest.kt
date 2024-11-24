package lotto

import org.assertj.core.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottoTest {
    @ParameterizedTest
    @MethodSource("invalidCountLottoNumberProvider")
    fun `로또 번호가 6개가 아닌 경우 예외를 발생시킨다`(numbers: List<Int>) {
        assertThatThrownBy { Lotto(numbers) }
            .isExactlyInstanceOf(InvalidLottoNumberCountException::class.java)
    }

    @ParameterizedTest
    @MethodSource("invalidLottoNumberProvider")
    fun `로또 번호에 1미만인 숫자나 45 초과한 숫자가 있을 경우 예외를 발생시킨다`(numbers: List<Int>) {
        assertThatThrownBy { Lotto(numbers) }
            .isExactlyInstanceOf(InvalidLottoNumberException::class.java)
    }

    companion object {

        @JvmStatic
        fun invalidCountLottoNumberProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(emptyList<Int>()),
                Arguments.of(listOf(1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            )
        }

        @JvmStatic
        fun invalidLottoNumberProvider(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(listOf(0, 1, 2, 3, 4, 5)),
                Arguments.of(listOf(-1, 1, 2, 3, 4, 5)),
                Arguments.of(listOf(1, 2, 3, 4, 5, 46)),
            )
        }
    }
}