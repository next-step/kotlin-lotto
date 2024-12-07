package lotto.domain

import io.kotest.matchers.equals.shouldBeEqual
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class LottoWinnerRankTest {
    @MethodSource("번호 매칭 카운트, 보너스 매칭 여부, 등수 제공")
    @ParameterizedTest
    fun `번호 매칭 카운트와 보너스 번호 매칭 여부를 토대로 등수를 확인할 수 있다`(
        countOfMatch: Int,
        bonusCheck: Boolean,
        lottoWinnerRank: LottoWinnerRank,
    ) {
        LottoWinnerRank.valueOf(countOfMatch = countOfMatch, bonusCheck = bonusCheck) shouldBeEqual lottoWinnerRank
    }

    fun `번호 매칭 카운트, 보너스 매칭 여부, 등수 제공`(): Stream<Arguments> {
        return Stream.of(
            Arguments.of(6, false, LottoWinnerRank.FIRST),
            Arguments.of(5, true, LottoWinnerRank.SECOND),
            Arguments.of(5, false, LottoWinnerRank.THIRD),
            Arguments.of(4, false, LottoWinnerRank.FOURTH),
            Arguments.of(4, true, LottoWinnerRank.FOURTH),
            Arguments.of(3, false, LottoWinnerRank.FIFTH),
            Arguments.of(3, true, LottoWinnerRank.FIFTH),
        )
    }
}
