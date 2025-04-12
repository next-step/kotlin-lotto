package lotto.domain

import io.kotest.assertions.assertSoftly
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.RawLottoNumbers

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

    context("create lotto according to amount and manual lottos") {
        withData(
            listOf(
                Triple(
                    Amount(2_000),
                    listOf(listOf(1, 2, 3, 4, 5, 6)),
                    2,
                ),
                Triple(
                    Amount(3_000),
                    listOf(listOf(1, 2, 3, 4, 5, 6)),
                    3,
                ),
                Triple(
                    Amount(10_000),
                    listOf(listOf(1, 2, 3, 4, 5, 6), listOf(2, 5, 8, 11, 25, 44)),
                    10,
                ),
            ),
        ) { (amount, manualLottoNumbers, expected) ->
            val actual = LottoMachine().createLottos(amount, RawLottoNumbers(manualLottoNumbers))

            assertSoftly {
                actual.size shouldBe expected
                actual.values.map { it.rawNumbers } shouldContainAll manualLottoNumbers
            }
        }
    }
})
