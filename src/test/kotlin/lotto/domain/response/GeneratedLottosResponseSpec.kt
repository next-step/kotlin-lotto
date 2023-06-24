package lotto.domain.response

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.domain.extension.lotto
import lotto.domain.extension.lottos

class GeneratedLottosResponseSpec : DescribeSpec({
    describe("객체 생성 검증") {
        context("수동 로또 3개, 자동 로또 2개로 객체를 생성하면") {
            val manualLottos = lottos(
                lotto(1, 2, 3, 4, 5, 6),
                lotto(1, 2, 3, 4, 5, 7),
                lotto(1, 2, 3, 4, 5, 8),
            )

            val autoLottos = lottos(
                lotto(10, 2, 3, 4, 5, 6),
                lotto(10, 2, 3, 4, 5, 7),
            )

            val generatedLottosResponse = GeneratedLottosResponse(
                manualLottos = manualLottos,
                autoLottos = autoLottos,
            )

            it("총 로또 수는 5개다.") {
                generatedLottosResponse.lottos.lottoQuantity.value shouldBe 5
                generatedLottosResponse.lottos.values shouldContainAll manualLottos.values
                generatedLottosResponse.lottos.values shouldContainAll autoLottos.values
            }
            it("수동 로또 수는 입력된 3개다.") {
                generatedLottosResponse.manualLottos.lottoQuantity.value shouldBe 3
                generatedLottosResponse.manualLottos shouldBe manualLottos
            }
            it("자동 로또 수는 입력된 2개다.") {
                generatedLottosResponse.autoLottos.lottoQuantity.value shouldBe 2
                generatedLottosResponse.autoLottos shouldBe autoLottos
            }
        }
    }
})
