package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class ManualLottoGeneratorTest : FunSpec({

    test("generate") {
        val manualLottoGenerator = ManualLottoGenerator()

        val lotto = manualLottoGenerator.generate(listOf(1, 2, 3, 4, 5, 6))

        lotto shouldBe Lotto(1, 2, 3, 4, 5, 6)
    }
})
