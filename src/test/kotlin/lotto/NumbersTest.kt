package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class NumbersTest {

    @ParameterizedTest
    @MethodSource("successNumbers")
    fun `1~45사이 6개의 숫자 객체 생성(성공)`(successNumbers: List<Int>) {
        val lottoNumber = LottoNumber(successNumbers)
        assertThat(lottoNumber.numbers).contains(*successNumbers.toTypedArray())
    }

    @ParameterizedTest
    @MethodSource("failNumbers")
    fun `예외 케이스 `(failNumbers: List<Int>) {
        assertThrows<IllegalArgumentException> {
            val lottoNumber = LottoNumber(failNumbers)
        }
    }

    @ParameterizedTest
    @MethodSource("compareNumbers")
    fun `리스트의 동일 숫자 개수 계산`(baseNumbers: List<Int>, compareNumbers: List<Int>) {
        val bases = LottoNumber(baseNumbers)
        val compares = LottoNumber(compareNumbers)

        val count = bases.equalsCount(compares)

        assertThat(count).isEqualTo(2)
    }

    companion object {
        @JvmStatic
        fun successNumbers() = listOf<Arguments>(
            Arguments.of(
                listOf(1, 12, 43, 23, 39, 37),
                listOf(15, 16, 18, 23, 39, 42)
            )
        )
        @JvmStatic
        /*
            1~45 이외의 값, 0 이하 혹은 45 초과 , 6개의 숫자가 아닌 리스트
         */
        fun failNumbers() = listOf<Arguments>(
            Arguments.of(
                listOf(0, 12, 43, 24, 44, 14),
                listOf(23, 12, 43, 24, 44, 46),
                listOf(1, 12, 43, 24, 44),
                listOf(15, 16, 18, 23, 39, 42, 11),
                listOf(15, 1, 1, 23, 39, 42, 11)
            )
        )
        @JvmStatic
        fun compareNumbers() = listOf<Arguments>(
            Arguments.of(listOf(1, 12, 43, 23, 39, 37), listOf(15, 16, 18, 23, 39, 42))
        )
    }
}
