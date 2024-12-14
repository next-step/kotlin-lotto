package lotto.domain

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.equals.shouldBeEqual
import io.kotest.matchers.shouldBe

class LottoStoreTest : FreeSpec({
    "입력된 금액에 따라 로또를 여러장 구매한다" {
        val amount = Amount(14000)

        val lottos = LottoStore.buy(ManualLottos(listOf()), amount)

        lottos.getPurchaseLottoCount() shouldBe 14
    }

    "수동과 자동을 섞어서 입력된 금액의 개수만큼 구매한다" {
        val amount = Amount(14000)
        val lottos =
            listOf(
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
            )
        val manualLottos = ManualLottos(lottos)

        val userLottos = LottoStore.buy(manualLottos, amount)

        userLottos.getPurchaseLottoCount() shouldBe 14
        userLottos.lottos shouldContainInOrder lottos
    }

    "수동을 입력 금액만큼 구매할 수 있다" {
        val amount = Amount(3000)
        val lottos =
            listOf(
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
                Lotto(LottoNumbers(1, 2, 3, 4, 5, 6)),
            )
        val manualLottos = ManualLottos(lottos)

        val userLottos = LottoStore.buy(manualLottos, amount)

        userLottos.getPurchaseLottoCount() shouldBe 3
        userLottos.lottos shouldBeEqual lottos
    }
})
