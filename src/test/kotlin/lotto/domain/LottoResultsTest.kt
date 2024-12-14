package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource

class LottoResultsTest {
    @ParameterizedTest
    @MethodSource("providedDuplicationNumbers")
    fun `로또 당첨 총 상금을 계산 할 수 있다`(
        lottoResult: LottoResult,
        totalPrize: Int,
    ) {
        val lottoResults = LottoResults(listOf(lottoResult))
        lottoResults.totalPrize() shouldBe totalPrize
    }

    companion object {
        @JvmStatic
        fun providedDuplicationNumbers() =
            listOf(
                Arguments.arguments(LottoResult(LottoRank.FIRST_PLACE, 1), 2_000_000_000),
                Arguments.arguments(LottoResult(LottoRank.SECOND_PLACE, 3), 4_500_000),
                Arguments.arguments(LottoResult(LottoRank.THIRD_PLACE, 4), 200_000),
            )
    }
}
