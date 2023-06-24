package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : StringSpec({
    val lottoGenerator = LottoGenerator()

    "구입 금액을 1000원 단위로 나눈다." {
        val inputPayment = 14000
        val count = lottoGenerator.getLottoCount(inputPayment)

        count shouldBe inputPayment / 1000
    }

    "로또 번호 6자리를 생성한다." {
        val count = 6
        val lottoNumbers = lottoGenerator.generateLottoNumbers()
        lottoNumbers.size shouldBe count
    }

    "수동, 자동 로또를 개수만큼 생성한다." {
        val count = 12
        val lottos = lottoGenerator.generateLottos(count, mutableListOf())
        lottos.lottoNumbers.size shouldBe 12
    }
})
