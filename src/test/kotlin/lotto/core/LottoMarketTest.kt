package lotto.core

import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMarketTest {
    @ParameterizedTest
    @CsvSource(
        "1, 1",
        "3, 3",
    )
    fun `로또 구매를 테스트한다`(
        totalCount: Int,
        manualCount: Int,
    ) {
        val list = List(manualCount) { (1..6).map(::LottoNumber) }

        val purchaseAmount = LottoPurchaseCount(totalCount, manualCount)
        LottoMarket.purchase(purchaseAmount, list).size shouldBe totalCount
    }
}
