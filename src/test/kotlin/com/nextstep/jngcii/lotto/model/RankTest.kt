package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class RankTest {
    @ParameterizedTest
    @MethodSource("notForBonus")
    fun `보너스볼과 관계없이, 6개-1등, 4개-4등, 3개-5등 에 대한 결과를 반환`(count: Int, expected: Rank) {
        assertThat(Rank.of(count, true)).isEqualTo(expected)
        assertThat(Rank.of(count, false)).isEqualTo(expected)
    }

    @ParameterizedTest
    @MethodSource("forBonus")
    fun `5개가 일치할 경우, 보너스볼에 따라 2등 혹은 3등을 반환한다`(count: Int, bonusMatch: Boolean, expected: Rank) {
        assertThat(Rank.of(count, bonusMatch)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [7, 8, 9])
    fun `입력받은 수가 7이상이면 예외 발생`(count: Int) {
        assertThrows<IllegalArgumentException>("7개 이상 일치할수는 없습니다.") { Rank.of(count, true) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `입력받은 수가 2 이하일 경우 NONE을 반환`(count: Int) {
        assertThat(Rank.of(count, true)).isEqualTo(Rank.NONE)
    }

    companion object {
        @JvmStatic
        fun notForBonus() = listOf(
            Arguments.of(3, Rank.FIFTH),
            Arguments.of(4, Rank.FOURTH),
            Arguments.of(6, Rank.FIRST),
        )

        @JvmStatic
        fun forBonus() = listOf(
            Arguments.of(5, true, Rank.SECOND),
            Arguments.of(5, false, Rank.THIRD),
        )
    }
}
