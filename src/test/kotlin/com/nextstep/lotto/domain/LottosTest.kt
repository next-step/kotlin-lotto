package com.nextstep.lotto.domain

import io.kotest.core.spec.style.AnnotationSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.Arguments.arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class LottosTest : AnnotationSpec() {

    @DisplayName("Lottos가 가지고 있는 Lotto 의 개수를 리턴한다.")
    @Test
    fun getCount() {
        val lottos = Lottos(listOf(Lotto(1, 2, 3, 4, 5, 6), Lotto(2, 3, 4, 5, 6, 7)))
        lottos.getCount() shouldBe 2
    }

    @DisplayName("WinningLotto를 받아서 Lottos가 숫자를 맞춘 현황을 map 타입으로 리턴한다.")
    @MethodSource("winningNumberProvider")
    @ParameterizedTest
    fun match(numbers: IntArray, expected: Map<Int, Int>) {
        val lottos = Lottos(listOf(Lotto(1, 2, 3, 4, 5, 6), Lotto(10, 11, 12, 13, 14, 15)))
        val winningLotto = WinningLotto(*numbers)
        lottos.match(winningLotto) shouldBe expected
    }

    companion object {
        @JvmStatic
        fun winningNumberProvider(): Stream<Arguments> = Stream.of(
            arguments(intArrayOf(1, 2, 3, 4, 5, 6), mapOf(6 to 1, 0 to 1)),
            arguments(intArrayOf(1, 2, 3, 4, 5, 7), mapOf(5 to 1, 0 to 1)),
            arguments(intArrayOf(1, 2, 3, 4, 8, 7), mapOf(4 to 1, 0 to 1)),
            arguments(intArrayOf(1, 2, 3, 9, 8, 7), mapOf(3 to 1, 0 to 1)),
            arguments(intArrayOf(1, 2, 10, 9, 8, 7), mapOf(2 to 1, 1 to 1)),
            arguments(intArrayOf(1, 11, 10, 9, 8, 7), mapOf(1 to 1, 2 to 1)),
            arguments(intArrayOf(12, 11, 10, 9, 8, 7), mapOf(0 to 1, 3 to 1)),
            arguments(intArrayOf(12, 11, 10, 13, 8, 7), mapOf(0 to 1, 4 to 1)),
            arguments(intArrayOf(12, 11, 10, 13, 14, 7), mapOf(0 to 1, 5 to 1)),
            arguments(intArrayOf(12, 11, 10, 13, 14, 15), mapOf(0 to 1, 6 to 1)),
        )
    }
}
