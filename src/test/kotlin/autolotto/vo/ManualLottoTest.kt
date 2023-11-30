package autolotto.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldHaveSize
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

    test("수동으로 구매할 수량만큼 로또번호를 입력받는다") {
        // Given
        val buyCount = 2L
        val manualLottos = ManualLottos(2000L, buyCount)

        // When
        for (i in 0 until buyCount.toInt()) {
            manualLottos.manualLotto[i].initLottoNumbers("1, 2, 3, 4, 5, 6")
        }

        // Then
        manualLottos.manualLotto[1].numbers shouldHaveSize 6
    }

//    test("수동으로 구매하고 난 후 자동으로 구매할 로또 수를 계산한다") {
//        // Given
//        val price = 2000L
//        val buyCount = 1L
//        val manualLottos = ManualLottos(price, buyCount)
//
//        // When
//        val autoLottoCount = manualLottos.calculateAutoLottoCount()
//
//        // Then
//        autoLottoCount shouldBe 1L
//    }
})
