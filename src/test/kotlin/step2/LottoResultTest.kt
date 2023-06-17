package step2

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import step2.enums.LottoReturn

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
    @ValueSource(ints = [1, 2])
    fun `꽝 테스트`(matchCount: Int) {
        LottoReturn.from(matchCount = matchCount) shouldBe LottoReturn.NONE
    }

    @Test
    fun `수익률 계산 테스트`() {
        val lastWeekNumber = LottoNumber.from(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers = listOf(
            LottoNumber.from(listOf(1, 2, 3, 4, 5, 6)), // 1등
            LottoNumber.from(listOf(1, 2, 3, 4, 5, 7)), // 2등
            LottoNumber.from(listOf(1, 2, 3, 4, 8, 9)), // 3등
            LottoNumber.from(listOf(1, 2, 3, 10, 11, 12)), // 4등
            LottoNumber.from(listOf(1, 2, 13, 14, 15, 16)), // 5등
        )
        val lottoResult = LottoResult.from(
            lottoNumbers = lottoNumbers,
            lastWeekLottoNumber = lastWeekNumber,
        )

        val returnPrice = listOf(
            LottoReturn.FIRST,
            LottoReturn.SECOND,
            LottoReturn.THIRD,
            LottoReturn.FOURTH,
            LottoReturn.NONE,
        ).sumOf {
            it.returnPrice
        }
        val totalInput = lottoNumbers.size * LottoPrice.PRICE_PER_LOTTO

        lottoResult.returnRatio shouldBe returnPrice.toDouble() / totalInput
    }
}
