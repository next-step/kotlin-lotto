package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : StringSpec({
    "로또를 생성한다." {
        val lottoMachine = LottoMachine(RandomLottoNumberGenerator())
        val lotto = lottoMachine.generateLotto()
        lotto.lottoNumbers.size shouldBe Lotto.SIZE
    }
})
