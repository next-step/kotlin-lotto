package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldNotBe

class DefaultLottoMachineTest : DescribeSpec({

    describe("generate") {
        it("로또 티켓을 생성한다") {
            DefaultLottoMachine.generate() shouldNotBe null
        }
    }
})
