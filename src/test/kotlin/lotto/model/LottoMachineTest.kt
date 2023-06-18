package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({

    "로또 최소 금액은 1000이다" {
        shouldThrow<IllegalArgumentException> {
            LottoMachine(100)
        }
    }

    "로또 구매 갯수는 구매 금액 나누기 1000 이다" {
        val list = LottoMachine(5000).buyLotto()
        list.size shouldBe 5
    }
})
