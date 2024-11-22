package lotto

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoSystemTest : StringSpec({
    "로또 금액을 입력받으면 해당 요청에 대한 주문을 생성해야한다." {
        val lottoSystem = LottoSystem(FixedNumberGenerator())
        val order = lottoSystem.createOrder(10000)

        assertSoftly {
            order.amount shouldBe 10000
            order.lottos.size shouldBe 10
        }
    }

    "당첨 번호를 입력받을 경우 당첨 번호 객체를 생성해야 한다." {
        val lottoSystem = LottoSystem(FixedNumberGenerator())

        val winNumbers = lottoSystem.createWinNumbers(setOf(1, 2, 3, 4, 5, 6))

        winNumbers shouldBe WinNumbers(FixedNumberGenerator().generate())
    }

    "당첨 통계 결과를 제공해야 한다." {
        val lottoSystem = LottoSystem(FixedNumberGenerator())
        val order = lottoSystem.createOrder(1000)
        val winNumbers = lottoSystem.createWinNumbers(setOf(1, 2, 3, 8, 9, 10))

        val result = lottoSystem.createWinningResult(order, winNumbers)

        assertSoftly {
            result.revenue shouldBe 5_000
            result.winningMatchCounts[0].count shouldBe 1
            result.rate shouldBe 5.0
        }
    }
})
