package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    @Test
    fun `{given} 로또 초기화 {when} LottoNumber 7개 일떄 {then} IllegalArgumentException 발생`() {
        assertThrows<IllegalArgumentException> {
            Lotto(listOf(1, 2, 3, 4, 5, 6, 7).map { LottoNumber(it) })
        }
        assertDoesNotThrow {
            Lotto(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) })
        }
    }

    @ParameterizedTest
    @MethodSource("provideDataForCountMatchesOf")
    fun `{given} Lotto {when} countMatchesOf(Lotto) {then} 일치하는 로또 개수 반환`(
        lotto1: List<Int>,
        lotto2: List<Int>,
        expectedMatches: Int
    ) {
        val lotto = Lotto(lotto1.map { LottoNumber(it) })
        val otherLotto = Lotto(lotto2.map { LottoNumber(it) })
        val result = lotto.countMatchesOf(otherLotto)
        assertThat(result).isEqualTo(expectedMatches)
    }

    @ParameterizedTest
    @MethodSource("provideDataForContainsAny")
    fun `{given} Lotto {when} containsAny(LottoNumber) {then} 일치하는 로또 번호가 있다면 true 아니라면 false 반환`(
        lottoNumbers: List<Int>,
        numberToCheck: Int,
        expectedResult: Boolean
    ) {
        val lotto = Lotto(lottoNumbers.map { LottoNumber(it) })
        val result = lotto.containsAny(LottoNumber(numberToCheck))
        assertThat(result).isEqualTo(expectedResult)
    }

    companion object {
        @JvmStatic
        fun provideDataForCountMatchesOf(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(10, 11, 12, 13, 14, 15), 0),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), 6)
            )
        }

        @JvmStatic
        fun provideDataForContainsAny(): List<Arguments> {
            return listOf(
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 3, true),
                Arguments.of(listOf(1, 2, 3, 4, 5, 6), 7, false),
                Arguments.of(listOf(10, 11, 12, 13, 14, 15), 10, true)
            )
        }
    }
}