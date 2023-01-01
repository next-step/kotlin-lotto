package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.ManualLottoStrings
import lotto.domain.ManualLottos

class ManualLottosTest : StringSpec({

    "수동 입력 개수와 입력받은 로또 숫자목록 개수는 같다" {
        val manualLottoCount = 2
        val manualLottoStrings = ManualLottoStrings(manualLottoCount, listOf("1,2,3,4,5,6", "1,2,3,4,5,6"))

        val manualLottos = ManualLottos(manualLottoStrings)

        manualLottos.manualLottos.size shouldBe manualLottoCount
    }

    "수동 입력 개수0" {
        val manualLottoCount = 0
        val manualLottoStrings = ManualLottoStrings(manualLottoCount, emptyList())

        val manualLottos = ManualLottos(manualLottoStrings)

        manualLottos.manualLottos.size shouldBe manualLottoCount
    }
})
