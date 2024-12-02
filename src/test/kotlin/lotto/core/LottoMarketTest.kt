package lotto.core

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.ValueSource

class LottoMarketTest {
    @ParameterizedTest
    @CsvSource(
        "'500', 0",
        "'1500', 1",
        "'2000', 2",
    )
    fun `로또 구매를 테스트한다`(
        amount: String,
        count: Int,
    ) {
        val list = List(0) { List(6) { LottoNumber(it) } }

        val purchaseAmount = LottoPurchaseCount(amount, list.size)
        LottoMarket.purchase(purchaseAmount, list).size shouldBe count
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "ㅈㄷㄹ"])
    fun `숫자가 아닌 문자열 입력 시 Exception을 테스트한다`(amount: String) {
        val list = List(0) { List(6) { LottoNumber(it) } }

        val purchaseAmount = LottoPurchaseCount(amount, list.size)

        shouldThrow<NumberFormatException> { LottoMarket.purchase(purchaseAmount, list) }
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1000"])
    fun `잘못된 숫자 입력 시 Exception을 테스트한다`(amount: String) {
        val list = List(0) { List(6) { LottoNumber(it) } }
        shouldThrow<IllegalArgumentException> {
            val purchaseAmount = LottoPurchaseCount(amount, list.size)
            LottoMarket.purchase(purchaseAmount, list) }
    }
}
