package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoNumbersResultTest {

    @ParameterizedTest
    @CsvSource(
        "1, 0",
        "3, 1"
    )
    fun `로또 결과는 3개 일치부터 저장한다`(input: Int, expected: Int) {
        val lottoResult = LottoResult()
        lottoResult.setLottoResult(input)
        lottoResult.getLottoResult(input) shouldBe expected
    }

    @Test
    fun `로또 수익률을 계산한다`() {
        val lottoResult = LottoResult()
        val lottoPrice = 1000
        val userLottoCount = 14
        lottoResult.setLottoResult(3)
        val result = lottoResult.calcRate(lottoPrice, userLottoCount)

        result shouldBe 0.35714285714285715
    }
}
