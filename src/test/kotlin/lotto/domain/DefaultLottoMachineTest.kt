package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe

class DefaultLottoMachineTest : DescribeSpec({

    describe("generateAuto") {
        it("자동 로또 티켓을 생성한다") {
            DefaultLottoMachine.generateAuto() shouldNotBe null
        }
    }

    describe("generateManual") {
        it("수동 로또 티켓을 생성한다") {
            DefaultLottoMachine.generateManual(`기본 로또 번호 목록(1~6)`()) shouldBe LottoTicket(
                listOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            )
        }
    }
})
