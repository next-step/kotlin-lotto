package lotto.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class WinningRankTest {
    @ParameterizedTest
    @MethodSource("provideParameters")
    fun `WinningCount로 WinningRank를 정상적으로 얻어지는 것을 확인한다`(
        count: Int,
        rank: WinningRank,
    ) {
        WinningRank.getRank(count) shouldBe rank
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, WinningRank.NOTHING),
                Arguments.of(1, WinningRank.NOTHING),
                Arguments.of(2, WinningRank.NOTHING),
                Arguments.of(3, WinningRank.FORTH),
                Arguments.of(4, WinningRank.THIRD),
                Arguments.of(5, WinningRank.SECOND),
                Arguments.of(6, WinningRank.FIRST),
            )
        }
    }
}
