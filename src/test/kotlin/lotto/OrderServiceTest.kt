package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.service.OrderService

class OrderServiceTest : StringSpec({
    "로또 금액을 입력받으면 해당 요청에 대한 주문을 생성해야한다." {
        val orderService = OrderService()
        val order = orderService.makeOrder(10000)

        assertSoftly {
            order.amount shouldBe 10000
            order.lottos.size shouldBe 10
        }
    }

    "주문 생성 시 전달된 금액이 1000원 단위가 아닐 경우 예외를 반환한다." {
        val orderService = OrderService()
        shouldThrow<IllegalArgumentException> { orderService.makeOrder(10001) }
    }

    //
    // "당첨 통계 결과를 제공해야 한다." {
    //     val lottoSystem = LottoSystem(FixedNumberGenerator())
    //     val order = lottoSystem.createOrder(1000)
    //     val winNumbers = lottoSystem.createWinNumbers(setOf(1, 2, 3, 8, 9, 10))
    //
    //     val result = lottoSystem.createWinningResult(order, winNumbers)
    //
    //     assertSoftly {
    //         result.revenue shouldBe 5_000
    //         result.winningMatchCounts[0].totalCount shouldBe 1
    //         result.rate shouldBe 5.0
    //     }
    // }
})
