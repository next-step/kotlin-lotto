package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : FunSpec({

    test("입력 받은 금액만큼 로또를 구입할 수 있다.") {
        val inputPrice = 1000
        val lottos = LottoStore.buyLottos(inputPrice)
        lottos.size shouldBe 1
    }

    test("입력받은 금액이 로또 가격보다 낮으면 구매할 수 없다.") {
        val inputPrice = 500
        val exception = shouldThrow<RuntimeException> {
            LottoStore.buyLottos(inputPrice)
        }
        exception.message shouldBe "로또를 구매할 수 없습니다."
    }
})
