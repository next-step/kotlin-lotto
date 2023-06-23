package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.view.toNumbers

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

    "로또 수동 10000원에 수동 3 구매" {
        val number = "7,11,16,35,36,44".toNumbers()
        val self = List(3) {
            number
        }

        val list = LottoMachine(10000, self).buyLotto()
        list.size shouldBe 10
    }
})
