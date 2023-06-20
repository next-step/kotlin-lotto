package next.step.lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoStoreTest : DescribeSpec({

    describe("LottoStore method") {
        context("lotto 가격만큼 지불하면, 남은 금액을 제공") {
            data class BuyLotto(val payment: Int, val expected: Int)
            withData(
                BuyLotto(1000, 0),
                BuyLotto(1500, 500),
                BuyLotto(2500, 1500)
            ) { (payment, expected) ->
                LottoStore.buy(payment) shouldBe expected
            }
        }

        context("lotto 가격보다 낮게 지불하면") {
            it("예외 발생") {
                shouldThrow<IllegalArgumentException> {
                    LottoStore.buy(LottoStore.LOTTO_PRICE - 1)
                }
            }
        }

        context("미리보기 요청하면") {
            it("로또 생성 방식에 따라 결과 제공") {
                LottoStore.preview { setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }.toSet() } shouldBe Lotto.from(
                    setOf(1, 2, 3, 4, 5, 6)
                )
            }
        }

        context("lotto 가격보다 낮게 넣으면") {
            it("살 수 없다고 알려줌") {
                LottoStore.canBuy(LottoStore.LOTTO_PRICE - 1) shouldBe false
            }
        }

        context("lotto 가격 이상으로 넣으면") {
            it("살 수 있다고 알려줌") {
                LottoStore.canBuy(LottoStore.LOTTO_PRICE) shouldBe true
            }
        }
    }
})
