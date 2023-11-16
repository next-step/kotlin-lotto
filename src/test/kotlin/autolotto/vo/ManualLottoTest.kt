package autolotto.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.vo.ManualLottos

class ManualLottoTest : FunSpec({
    test("수동으로 구매할 로또 수를 입력받는다") {
        // Given
        val price = 2000L
        val buyCount = 1L

        // When
        val manualLottos = ManualLottos(price, buyCount)

        // Then
        manualLottos.manualLotto.size shouldBe 1
    }
})
