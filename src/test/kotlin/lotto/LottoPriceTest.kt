package lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoPriceTest {
    @ParameterizedTest
    @CsvSource(
        "14000, 14",
        "1300, 1",
        "500, 0",
    )
    fun `로또 개수 계산 테스트`(money: Int, lottoCount: Int) {
        LottoPrice.getCountFrom(money) shouldBe lottoCount
    }
}
