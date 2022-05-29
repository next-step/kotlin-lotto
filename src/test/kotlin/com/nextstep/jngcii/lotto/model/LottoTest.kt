package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoTest {
    @ParameterizedTest
    @MethodSource("invalidCountNumbers")
    fun `Lotto 생성시 6개의 숫자가 오지 않으면 예외를 발생`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException>("6개의 숫자가 아닙니다.") { Lotto(numbers) }
    }

    @Test
    fun `Lotto 생성시 내부에 같은 숫자가 있다면 예외를 발생`() {
        val numbers: List<Int> = listOf(1, 2, 3, 4, 5, 5)
        assertThrows<IllegalArgumentException>("각기 다른 6개의 숫자가 아닙니다.") { Lotto(numbers) }
    }

    @ParameterizedTest
    @MethodSource("invalidElementNumbers")
    fun `Lotto 생성시 리스트에 1~45 가 아닌 숫자가 있다면 예외를 발생`(numbers: List<Int>) {
        assertThrows<IllegalArgumentException>("1~45에 해당하는 숫자로 이루어진 리스여야합니다.") { Lotto(numbers) }
    }

    @ParameterizedTest
    @MethodSource("validNumbers")
    fun `Lotto 생성시 전달받은 리스트 정렬`(numbers: List<Int>) {
        val lotto: Lotto = Lotto(numbers)

        val expected = setOf(1, 2, 3, 4, 5, 6)
        assertThat(lotto.numbers).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("comparisons")
    fun `인자로 전달받은 comparison(lotto)와 자신을 비교해 일치하는 갯수를 반환`(comparison: List<Int>, expected: Int) {
        val lotto: Lotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val target: Lotto = Lotto(comparison)
        val actual: Int = lotto.getSameCount(target)

        assertThat(actual).isEqualTo(expected)
    }

    companion object {
        @JvmStatic
        fun invalidCountNumbers() = listOf(
            Arguments.of(listOf(1)),
            Arguments.of(listOf(1, 2, 3)),
            Arguments.of(listOf(1, 2, 3, 4, 5, 6, 7)),
        )

        @JvmStatic
        fun invalidElementNumbers() = listOf(
            Arguments.of(listOf(0, 1, 2, 3, 4, 5)),
            Arguments.of(listOf(-1, 0, 1, 2, 3, 4)),
            Arguments.of(listOf(41, 42, 43, 44, 45, 46)),
        )

        @JvmStatic
        fun validNumbers() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6)),
            Arguments.of(listOf(6, 5, 4, 3, 2, 1))
        )

        @JvmStatic
        fun comparisons() = listOf(
            Arguments.of(listOf(1, 2, 3, 4, 5, 6), 6),
            Arguments.of(listOf(1, 2, 3, 4, 5, 7), 5),
            Arguments.of(listOf(6, 7, 8, 9, 10, 11), 1),
            Arguments.of(listOf(7, 8, 9, 10, 11, 12), 0),
        )
    }
}
