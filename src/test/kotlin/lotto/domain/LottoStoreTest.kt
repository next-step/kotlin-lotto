package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import java.lang.IllegalArgumentException

class LottoStoreTest : FunSpec({

    test("입력 받은 금액만큼 로또를 구입할 수 있다.") {
        val inputPrice = 1000
        val lottos = LottoStore.buyLottos(inputPrice, emptyList())
        lottos.lottos.size shouldBe 1
    }

    test("입력받은 금액이 로또 가격보다 낮으면 구매할 수 없다.") {
        val inputPrice = 500
        val exception = shouldThrow<RuntimeException> {
            LottoStore.buyLottos(inputPrice, emptyList())
        }
        exception.message shouldBe "로또를 구매할 수 없습니다."
    }

    test("입력받은 금액 1000원일때,수동갯수가 2개면 구매할 수 없다.") {
        val inputPrice = 1000
        val manualLottoNumbers = List(2) { LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }) }

        val exception = shouldThrow<IllegalArgumentException> {
            LottoStore.buyLottos(inputPrice, manualLottoNumbers)
        }
        exception.message shouldBe "로또를 구매할 수 없습니다."
    }
})
