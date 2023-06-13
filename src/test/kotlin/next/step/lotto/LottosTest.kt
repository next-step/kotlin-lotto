package next.step.lotto

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottosTest : DescribeSpec({

    describe("Lottos 생성") {
        context("일정 금액으로 구매하면, 지불한 금액만큼 로또 제공") {
            data class BuyLottos(val payment: Int, val expected: Int)
            withData(
                BuyLottos(1000, 1),
                BuyLottos(14000, 14),
                BuyLottos(2500, 2)
            ) { (payment, expected) ->
                Lottos.buy(payment).size shouldBe expected
            }
        }
    }

})
