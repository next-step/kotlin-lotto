package lotto.domain

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoResultTest {

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
}
