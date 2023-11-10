package lottoTest

import lotto.domain.LottoStatResult
import lotto.domain.Rank
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoStatResultTest {
    @ParameterizedTest
    @CsvSource(
        value = [
            "0,0,0,0,0,2,0",
            "1,1,1,1,1,22,75242.78",
            "0,0,0,0,2,10,0.83"
        ]
    )
    fun `수익률 계산`(
        firstCount: Int,
        secondCount: Int,
        thirdCount: Int,
        fourthCount: Int,
        fifthCount: Int,
        missedCount: Int,
        expected: Double,
    ) {

        val lottoStatResult =
            LottoStatResult(
                mapOf(
                    Pair(Rank.FIRST, firstCount),
                    Pair(Rank.SECOND, secondCount),
                    Pair(Rank.THIRD, thirdCount),
                    Pair(Rank.FOURTH, fourthCount),
                    Pair(Rank.FIFTH, fifthCount),
                    Pair(Rank.MISS, missedCount),
                )
            )

        assertEquals(expected, lottoStatResult.getReturnRate())
    }
}
