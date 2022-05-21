package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FreeSpec({

    "init" - {

        "주어진 금액이 1000원 미만일 경우 IllegalArgumentException" {
            val payment = 100
            val exception = shouldThrow<IllegalArgumentException> {
                LottoMachine(payment)
            }
            exception.message shouldBe LottoMachine.INVALID_PAYMENT
        }

        "주어진 금액이 로또 가격으로 나누어 떨어지지 않을 경우 IllegalArgumentException" {
            val payment = 1100
            val exception = shouldThrow<IllegalArgumentException> {
                LottoMachine(payment)
            }
            exception.message shouldBe LottoMachine.CANNOT_ISSUANCE_LOTTO
        }
    }
})
