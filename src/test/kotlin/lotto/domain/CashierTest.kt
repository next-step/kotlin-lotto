package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.strategy.FirstRankLottoLottoNumberGenerator
import org.junit.jupiter.api.assertThrows

class CashierTest : DescribeSpec({
    describe("입력한 금액만큼 로또를 구매한다") {
        it("1000원 보다 적은 경우 throw exception") {
            val sut = Cashier(999, FirstRankLottoLottoNumberGenerator())
            assertThrows<IllegalArgumentException> {
                sut.purchaseLotto()
            }
        }

        it("1000원 짜리 로또를 구매한다") {
            val sut = Cashier(3000, FirstRankLottoLottoNumberGenerator())
            val actual = sut.purchaseLotto()
            actual.size shouldBe 3
        }

        it("100원 단위는 내림처리 한다.") {
            val sut = Cashier(3500, FirstRankLottoLottoNumberGenerator())
            val actual = sut.purchaseLotto()
            actual.size shouldBe 3
        }
    }
})
