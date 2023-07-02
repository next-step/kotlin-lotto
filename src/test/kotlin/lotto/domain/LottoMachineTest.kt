package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "구매 금액과 수동 갯수를 통하여 로또 머신을 생성한다." {
        val lottoMachine = LottoMachine(Price("10000"), 1)
        val lottoNumbers = lottoMachine.lottoNumbers(listOf("1,2,3,4,5,6"))

        lottoNumbers.lottos.size shouldBe 10
    }
})
