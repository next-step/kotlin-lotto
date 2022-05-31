package com.nextstep.jngcii.lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource

class RankTest {
    @ParameterizedTest
    @MethodSource("validCount")
    fun `입력받은 수가 3~6이면 Rank를 반환`(count: Int, expected: Rank) {
        assertThat(Rank.of(count)).isEqualTo(expected)
    }

    @ParameterizedTest
    @ValueSource(ints = [7, 8, 9])
    fun `입력받은 수가 7이상이면 예외 발생`(count: Int) {
        assertThrows<IllegalArgumentException>("7개 이상 일치할수는 없습니다.") { Rank.of(count) }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `입력받은 수가 2 이하일 경우 null을 반환`(count: Int) {
        assertThat(Rank.of(count)).isNull()
    }

    companion object {
        @JvmStatic
        fun validCount() = listOf(
            Arguments.of(3, Rank.FOURTH),
            Arguments.of(4, Rank.THIRD),
            Arguments.of(5, Rank.SECOND),
            Arguments.of(6, Rank.FIRST),
        )
    }
}
