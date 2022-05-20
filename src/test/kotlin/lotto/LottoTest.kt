package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class LottoTest : FreeSpec({

    "issuance" - {

        "지불한 금액이 로또 금액에 나누어 떨어지지 않으면 IllegalArgumentException" {
            val payment = 1100
            val exception = shouldThrow<IllegalArgumentException> {
                Lotto(payment).issuanceCount()
            }
            exception.message shouldBe Lotto.CANNOT_ISSUANCE_LOTTO
        }

        "주어진 금액에 알맞게 로또 발행 수를 반환해야한다." {
            val payment = 1000
            Lotto(payment).issuanceCount() shouldBe 1
        }
    }
})
