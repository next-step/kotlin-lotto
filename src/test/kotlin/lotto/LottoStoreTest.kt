package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.domain.LottoStore

class LottoStoreTest : FunSpec({
    test("입력 받은 금액만큼 로또를 구입할 수 있다.") {
        val inputPrice = 1000
        val lottos = LottoStore.buyLottos(inputPrice)
        lottos.size shouldBe 1
    }
})
