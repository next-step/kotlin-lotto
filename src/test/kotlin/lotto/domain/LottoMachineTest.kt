package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMachineTest : FunSpec({
    test("로또 자동 발급이 가능하다.") {
        val lotto = LottoMachine().generateAuto()
        lotto.numbers.size shouldBe 6
    }
})
