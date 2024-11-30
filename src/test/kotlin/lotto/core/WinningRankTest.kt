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
        matchBonusNumber: Boolean,
        rank: WinningRank,
    ) {
        WinningRank.getRank(count, matchBonusNumber) shouldBe rank
    }

    companion object {
        @JvmStatic
        fun provideParameters(): Stream<Arguments> {
            return Stream.of(
                Arguments.of(0, false, WinningRank.NOTHING),
                Arguments.of(1, false, WinningRank.NOTHING),
                Arguments.of(2, false, WinningRank.NOTHING),
                Arguments.of(3, false, WinningRank.FIFTH),
                Arguments.of(4, false, WinningRank.FORTH),
                Arguments.of(5, false, WinningRank.THIRD),
                Arguments.of(5, true, WinningRank.SECOND),
                Arguments.of(6, false, WinningRank.FIRST),
            )
        }
    }
}
