package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({

    "돈을 받고 로또를 생성한다." {
        val lottoMachine = LottoMachine(RandomLottoNumberGenerator())
        val lotto = lottoMachine.generateLotto(Amount(1000))
        lotto[0].lottoNumbers.size shouldBe Lotto.SIZE
    }
})
