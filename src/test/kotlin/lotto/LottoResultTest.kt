package lotto

import io.kotest.matchers.shouldBe
import lotto.enums.LottoReturn
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoResultTest {
    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `1등 테스트`(bonusMatch: Boolean) {
        LottoReturn.from(matchCount = 6, bonusMatch = bonusMatch) shouldBe LottoReturn.FIRST
    }

    @Test
    fun `2등 테스트`() {
        LottoReturn.from(matchCount = 5, bonusMatch = true) shouldBe LottoReturn.SECOND
    }

    @Test
    fun `3등 테스트`() {
        LottoReturn.from(matchCount = 5, bonusMatch = false) shouldBe LottoReturn.THIRD
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `4등 테스트`(bonusMatch: Boolean) {
        LottoReturn.from(matchCount = 4, bonusMatch = bonusMatch) shouldBe LottoReturn.FOURTH
    }

    @ParameterizedTest
    @ValueSource(booleans = [true, false])
    fun `5등 테스트`(bonusMatch: Boolean) {
        LottoReturn.from(matchCount = 3, bonusMatch = bonusMatch) shouldBe LottoReturn.FIFTH
    }

    @ParameterizedTest
    @CsvSource(
        "2, true",
        "2, false",
        "1, true",
        "1, false",
        "0, true",
        "0, false",
    )
    fun `꽝 테스트`(matchCount: Int, bonusMatch: Boolean) {
        LottoReturn.from(matchCount = matchCount, bonusMatch = bonusMatch) shouldBe LottoReturn.NONE
    }

    @Test
    fun `수익률 계산 테스트`() {
        val lastWeekNumber = ResultLottoNumber.from(listOf(1, 2, 3, 4, 5, 6), 7)
        val lottos = listOf(
            Lotto.from(listOf(8, 21, 23, 41, 42, 43)),
            Lotto.from(listOf(3, 5, 11, 16, 32, 38)),
            Lotto.from(listOf(8, 11, 16, 35, 36, 44)),
            Lotto.from(listOf(1, 8, 11, 31, 41, 42)),
            Lotto.from(listOf(13, 14, 16, 38, 42, 45)),
            Lotto.from(listOf(8, 11, 30, 40, 42, 43)),
            Lotto.from(listOf(2, 13, 22, 32, 38, 45)),
            Lotto.from(listOf(23, 25, 33, 36, 39, 41)),
            Lotto.from(listOf(1, 3, 5, 14, 22, 45)),
            Lotto.from(listOf(5, 9, 38, 41, 43, 44)),
            Lotto.from(listOf(2, 8, 9, 18, 19, 21)),
            Lotto.from(listOf(13, 14, 18, 21, 23, 35)),
            Lotto.from(listOf(17, 21, 29, 37, 42, 45)),
            Lotto.from(listOf(3, 8, 27, 30, 35, 44)),
        )
        val lottoResult = LottoResult.from(
            lottos = lottos,
            lastWeekResultLottoNumber = lastWeekNumber,
        )

        val returnPrice = listOf(LottoReturn.FIFTH).sumOf { it.returnPrice }
        val totalInput = lottos.size * LottoPrice.PRICE_PER_LOTTO

        lottoResult.returnRatio shouldBe returnPrice.toDouble() / totalInput
    }
}
