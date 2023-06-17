package lotto

import io.kotest.assertions.throwables.shouldThrow
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoNumberTest {

    @ParameterizedTest
    @MethodSource("makeLottoNumber")
    fun `로또 번호가 1~45 사이에 중복없는 숫자 6개가 아닌 경우 IllegalArgumentException 을 발생`(lottoNumber: List<Int>) {
        shouldThrow<IllegalArgumentException> {
            LottoNumber(lottoNumber)
        }
    }

    companion object {

        @JvmStatic
        fun makeLottoNumber(): List<Arguments> = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
            Arguments.of(listOf(1, 2, 3, 3, 2, 1)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 46)),
            Arguments.of(listOf(111, 22, 33, 44, 45, 1)),
        )
    }
}
