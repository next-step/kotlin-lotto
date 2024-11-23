package lottery.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LotteryMachineTest : StringSpec({
    "원하는 갯수만큼 로또를 생성한다" {
        listOf(1000, 2000, 3000, 4000, 5000).forAll { moneyAmount ->
            LotteryMachine.buy(Money(moneyAmount)).size shouldBe moneyAmount / 1000
        }
    }

    "로또 구입를 1,000원단위로 하지 않을 시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            LotteryMachine.buy(Money(1500))
        }
    }

    "천원 미만 금액 투입 시 예외 발생한다" {
        shouldThrow<IllegalArgumentException> {
            LotteryMachine.buy(Money(900))
        }
    }
})
