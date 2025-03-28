package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    test("create lottos with amount") {
        val amount = Amount(1_000)
        val actual = LottoMachine().createLottos(amount)

        actual.size shouldBe 1
    }
})
