package lotto.domain.response

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe
import lotto.domain.LottoType
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
                LottoType.AUTO.generate(),
                LottoType.AUTO.generate(),
            )

            val response = LottosGenerateResponse(manualLottos + autoLottos)

            it("총 로또 수는 5개다.") {
                response.lottos.lottoQuantity.value shouldBe 5
                response.lottos.values shouldContainAll manualLottos.values
                response.lottos.values shouldContainAll autoLottos.values
            }
            it("수동 로또 수는 입력된 3개다.") {
                response.lottos.manual.lottoQuantity.value shouldBe 3
                response.lottos.manual.values shouldBe manualLottos.values
            }
            it("자동 로또 수는 입력된 2개다.") {
                response.lottos.auto.lottoQuantity.value shouldBe 2
                response.lottos.auto.values shouldBe autoLottos.values
            }
        }
    }
})
