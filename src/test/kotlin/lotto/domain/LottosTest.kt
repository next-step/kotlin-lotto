package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottosTest : DescribeSpec({
    describe("로또 묶음 테스트") {
        val lottoNumbers = (2..7).map { LottoNumber.of(it) }.toSet()
        val lottos = Lottos(
            listOf(
                Lotto(lottoNumbers)
            )
        )

        val otherLottoNumbers = (1..6).map { LottoNumber.of(it) }.toSet()
        var otherLottos = Lottos(
            listOf(
                Lotto(otherLottoNumbers)
            )
        )

        it("두개의 묶음을 합칠 수 있다.") {
            var combinedLottos = lottos + otherLottos

            combinedLottos.elements.size shouldBe 2
        }
    }
})
