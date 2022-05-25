package lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class SellerTest : DescribeSpec({
    describe("sell") {
        it("로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 판매한다.") {
            val purchaseAmount = 14000
            val lottoPrice = 1000
            val lottoCount = purchaseAmount / lottoPrice
            val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
            val seller = Seller(StubRandomNumberGenerator(lottoNumbers))

            seller.sell(14000) shouldBe (1..lottoCount).map { lottoNumbers }
        }
    }
})

class StubRandomNumberGenerator(private val numbers: List<Int>) : LottoNumberFactory {
    override fun generate() = numbers
}
