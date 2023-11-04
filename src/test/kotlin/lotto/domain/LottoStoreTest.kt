package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class LottoStoreTest : BehaviorSpec({

    given("입력 받은 금액이 1000이면") {
        val inputPrice = 1000
        `when`("로또를 구매하면") {
            val lottos = LottoStore.buyLottos(inputPrice, emptyList())
            then("로또 1개를 반환한다.") {
                lottos.lottos.size shouldBe 1
            }
        }
    }

    given("입력 받은 금액이 로또 가격보다 낮으면") {
        val inputPrice = 500
        `when`("로또를 구매하면") {
            val exception = shouldThrow<RuntimeException> {
                LottoStore.buyLottos(inputPrice, emptyList())
            }
            then("예외가 발생한다.") {
                exception.message shouldBe "로또를 구매할 수 없습니다."
            }
        }
    }

    given("입력받은 금액이 1000원이고") {
        val inputPrice = 1000
        `when`("수동으로 1개를 구매하면") {
            val manualLottoNumbers = List(1) { LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }) }
            val lottos = LottoStore.buyLottos(inputPrice, manualLottoNumbers)
            then("자동으로 0개를 구매한다.") {
                lottos.autoLottos.size shouldBe 0
            }
        }
    }

    given("입력받은 금액이 2000원이고") {
        val inputPrice = 2000
        `when`("수동으로 1개를 구매하면") {
            val manualLottoNumbers = List(1) { LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }) }
            val lottos = LottoStore.buyLottos(inputPrice, manualLottoNumbers)
            then("자동으로 1개를 구매한다.") {
                lottos.autoLottos.size shouldBe 1
            }
        }
    }

    given("입력받은 금액이 1000원이고") {
        val inputPrice = 1000
        `when`("수동으로 2개를 구매하면") {
            val manualLottoNumbers = List(2) { LottoNumbers(listOf(1, 2, 3, 4, 5, 6).map { LottoNumber(it) }) }
            val exception = shouldThrow<IllegalArgumentException> {
                LottoStore.buyLottos(inputPrice, manualLottoNumbers)
            }
            then("예외가 발생한다.") {
                exception.message shouldBe "로또를 구매할 수 없습니다."
            }
        }
    }
})
