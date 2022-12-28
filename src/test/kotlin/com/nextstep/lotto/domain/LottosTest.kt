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

    @DisplayName("WinningLotto를 받아서 Lottos가 맞춘 통계를 LottoStat으로 리턴한다.")
    @MethodSource("winningNumberProvider")
    @ParameterizedTest
    fun match(numbers: IntArray, expected: LottoStat) {
        val lottos = Lottos(listOf(Lotto(1, 2, 3, 4, 5, 6), Lotto(10, 11, 12, 13, 14, 15)))
        val winningLotto = WinningLotto(*numbers)
        lottos.match(winningLotto) shouldBe expected
    }

    companion object {
        @JvmStatic
        fun winningNumberProvider(): Stream<Arguments> = Stream.of(
            arguments(intArrayOf(1, 2, 3, 4, 5, 6), LottoStat(listOf(6, 0))),
            arguments(intArrayOf(1, 2, 3, 4, 5, 7), LottoStat(listOf(5, 0))),
            arguments(intArrayOf(1, 2, 3, 4, 8, 7), LottoStat(listOf(4, 0))),
            arguments(intArrayOf(1, 2, 3, 9, 8, 7), LottoStat(listOf(3, 0))),
            arguments(intArrayOf(1, 2, 10, 9, 8, 7), LottoStat(listOf(2, 1))),
            arguments(intArrayOf(1, 11, 10, 9, 8, 7), LottoStat(listOf(1, 2))),
            arguments(intArrayOf(12, 11, 10, 9, 8, 7), LottoStat(listOf(0, 3))),
            arguments(intArrayOf(12, 11, 10, 13, 8, 7), LottoStat(listOf(0, 4))),
            arguments(intArrayOf(12, 11, 10, 13, 14, 7), LottoStat(listOf(0, 5))),
            arguments(intArrayOf(12, 11, 10, 13, 14, 15), LottoStat(listOf(0, 6)))
        )
    }
}
