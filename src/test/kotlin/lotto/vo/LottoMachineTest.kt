package lotto.vo

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    test("로또 구입금액을 입력받는다.") {
        // Given
        val input = 1000L

        // When
        val lottoMachine = LottoMachine(input)

        // Then
        lottoMachine.buyPrice shouldBe 1000L
    }

    test("수동 로또를 발급한다") {
        // Given
        val input = 1000L
        val lottoMachine = LottoMachine(input)

        // When
        val manualLotto = lottoMachine.createManualLotto(listOf("1, 2, 3, 4, 5, 6"))

        // Then
        manualLotto.size shouldBe 1
    }

    test("수동로또 개수를 통해 발급할 수 있는 자동로또 개수를 계산한다.") {
        // Given
        val input = 3000L
        val lottoMachine = LottoMachine(input)
        val manualLottoCount = 1L

        // When
        val autoLottoCount = lottoMachine.calculateAutoLottoCount(manualLottoCount)

        // Then
        autoLottoCount shouldBe 2L
    }

    test("자동 로또를 발급한다") {
        // Given
        val autoLottoCount = 2L
        val lottoMachine = LottoMachine(3000L)

        // When
        val autoLotto = lottoMachine.createAutoLotto(autoLottoCount)

        // Then
        autoLotto.size shouldBe 2
    }

    test("수동으로 구매하고 난 후 나머지금액은 자동으로 발급한다") {
        // Given
        val buyPrice = 5000L
        val manualLottoCount = 3L
        val manualLottoNumber = listOf("1,2,3,4,5,6", "1,2,3,4,5,6", "1,2,3,4,5,6")
        val lottoMachine = LottoMachine(buyPrice)

        // When
        val manualLotto = lottoMachine.createManualLotto(manualLottoNumber)
        val autoLottoCount = lottoMachine.calculateAutoLottoCount(manualLottoCount)
        val autoLotto = lottoMachine.createAutoLotto(autoLottoCount)

        manualLotto.size shouldBe 3L
        autoLotto.size shouldBe 2L
    }
})
