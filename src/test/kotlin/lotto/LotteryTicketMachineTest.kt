package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec

class LotteryTicketMachineTest : StringSpec({
    "로또 티켓 머신은 티켓 구매 가격(1000원) 미만의 돈을 받으면 예외를 던진다" {
        shouldThrow<IllegalArgumentException> {
            LotteryTicketMachine(999)
        }
    }
})
