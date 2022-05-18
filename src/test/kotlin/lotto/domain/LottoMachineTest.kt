package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    val lottoMachine = LottoMachine()

    test("로또 자동 발급이 가능하다.") {
        val lotto = lottoMachine.generateAuto()
        lotto.numbers.size shouldBe 6
    }
})
