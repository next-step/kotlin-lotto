package next.step.lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoStoreTest : DescribeSpec({

    describe("LottoStore method") {
        context("일정 금액으로 구매하면, 지불한 금액만큼 로또 제공") {
            data class BuyLottos(val payment: Int, val expected: Int)
            withData(
                BuyLottos(1000, 1),
                BuyLottos(14000, 14),
                BuyLottos(2500, 2)
            ) { (payment, expected) ->
                LottoStore.buy(payment, LottoNumberGenerator.random()).size() shouldBe expected
            }
        }

        context("미리보기 요청하면") {
            it("로또 생성 방식에 따라 결과 제공") {
                Lotto.of(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.of(it) }.toSet()) shouldBe Lotto.from(
                    setOf(1, 2, 3, 4, 5, 6)
                )
            }
        }


    }
})
