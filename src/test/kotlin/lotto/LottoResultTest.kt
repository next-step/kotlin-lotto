package lotto

import io.kotest.matchers.shouldBe
import lotto.enums.LottoReturn
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoResultTest {
    @Test
    fun `1등 테스트`() {
        LottoReturn.from(matchCount = 6) shouldBe LottoReturn.FIRST
    }

    @Test
    fun `2등 테스트`() {
        LottoReturn.from(matchCount = 5) shouldBe LottoReturn.SECOND
    }

    @Test
    fun `3등 테스트`() {
        LottoReturn.from(matchCount = 4) shouldBe LottoReturn.THIRD
    }

    @Test
    fun `4등 테스트`() {
        LottoReturn.from(matchCount = 3) shouldBe LottoReturn.FOURTH
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 1, 2])
    fun `꽝 테스트`(matchCount: Int) {
        LottoReturn.from(matchCount = matchCount) shouldBe LottoReturn.NONE
    }

    @Test
    fun `수익률 계산 테스트`() {
        val lastWeekNumber = LottoNumber.from(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers = listOf(
            LottoNumber.from(listOf(8, 21, 23, 41, 42, 43)),
            LottoNumber.from(listOf(3, 5, 11, 16, 32, 38)),
            LottoNumber.from(listOf(7, 11, 16, 35, 36, 44)),
            LottoNumber.from(listOf(1, 8, 11, 31, 41, 42)),
            LottoNumber.from(listOf(13, 14, 16, 38, 42, 45)),
            LottoNumber.from(listOf(7, 11, 30, 40, 42, 43)),
            LottoNumber.from(listOf(2, 13, 22, 32, 38, 45)),
            LottoNumber.from(listOf(23, 25, 33, 36, 39, 41)),
            LottoNumber.from(listOf(1, 3, 5, 14, 22, 45)),
            LottoNumber.from(listOf(5, 9, 38, 41, 43, 44)),
            LottoNumber.from(listOf(2, 8, 9, 18, 19, 21)),
            LottoNumber.from(listOf(13, 14, 18, 21, 23, 35)),
            LottoNumber.from(listOf(17, 21, 29, 37, 42, 45)),
            LottoNumber.from(listOf(3, 8, 27, 30, 35, 44)),
        )
        val lottoResult = LottoResult.from(
            lottoNumbers = lottoNumbers,
            lastWeekLottoNumber = lastWeekNumber,
        )

        val returnPrice = listOf(LottoReturn.FOURTH).sumOf { it.returnPrice }
        val totalInput = lottoNumbers.size * LottoPrice.PRICE_PER_LOTTO

        lottoResult.returnRatio shouldBe returnPrice.toDouble() / totalInput
    }
}
