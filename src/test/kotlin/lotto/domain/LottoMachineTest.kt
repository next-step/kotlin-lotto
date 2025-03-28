package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    context("create lottos according to amount") {
        withData(
            Amount(1_000) to 1,
            Amount(2_000) to 2,
            Amount(5_500) to 5,
            Amount(10_000) to 10,
        ) { (amount, expected) ->
            val actual = LottoMachine().createLottos(amount)

            actual.size shouldBe expected
        }
    }
})
