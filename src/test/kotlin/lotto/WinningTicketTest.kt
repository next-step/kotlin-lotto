package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class WinningTicketTest : FunSpec({
    context("당첨 티켓 생성") {
        test("당첨되지 않은 로또 티켓을 전달하면") {
            test("당첨 티켓을 생성할 수 없다.") {
                val winningNumber = WinningNumber.from(numbers = listOf(5, 10, 15, 22, 33, 44))
                val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(1, 2, 3, 4, 5, 6))
                val lottoTicket = LottoTicket.purchase(payment = 1000, manualNumber = lottoNumber)

                lottoTicket.match(winningNumber = winningNumber)

                assertThrows<IllegalArgumentException> { WinningTicket.from(lottoTicket = lottoTicket) }
            }
        }

        context("당첨된 로또 티켓을 전달하면") {
            test("당첨 티켓을 생성할 수 있다.") {
                val winningNumber = WinningNumber.from(numbers = listOf(5, 10, 15, 22, 33, 44))
                val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(5, 10, 15, 20, 25, 30))
                val lottoTicket = LottoTicket.purchase(payment = 1000, manualNumber = lottoNumber)

                lottoTicket.match(winningNumber = winningNumber)

                val actual = WinningTicket.from(lottoTicket = lottoTicket)
                actual.lottoRank shouldBe LottoRank.FORTH
            }
        }
    }
})
