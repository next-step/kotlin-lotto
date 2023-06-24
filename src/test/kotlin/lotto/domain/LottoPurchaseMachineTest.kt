package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.test.FakeGenerator

class LottoPurchaseMachineTest : BehaviorSpec({
    given("금액을 지불한다.") {
        `when`("수동 로또 번호를 전달한다") {
            then("남은 금액만큼의 자동로또를 생성한다.") {
                forAll(
                    row(6000, FakeGenerator.lottoNumbersOfLottos(2), 6),
                    row(14500, FakeGenerator.lottoNumbersOfLottos(2), 14),
                    row(0, FakeGenerator.lottoNumbersOfLottos(0), 0),
                ) { purchasePrice, manualLottos, totalLottoCount ->
                    val lottos = LottoPurchaseMachine.getLottos(purchasePrice, manualLottos)
                    lottos.size shouldBe totalLottoCount
                }
            }
        }

        `when`("지불한 금액보다 더 높은 금액의 수동로또 번호를 전달한다.") {
            then("예외가 발생한다.") {
                val purchasePrice = 1000
                val manualLottos = FakeGenerator.lottoNumbersOfLottos(3)
                shouldThrow<IllegalArgumentException> {
                    LottoPurchaseMachine.getLottos(purchasePrice, manualLottos)
                }
            }
        }
    }
})
