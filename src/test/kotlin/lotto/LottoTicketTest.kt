package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoTicketTest : FunSpec({
    context("로또 티켓 구매") {
        test("티켓은 하나의 로또 번호를 가진다.") {
            val actual = LottoTicket.purchase(payment = 1000)
            actual.lottoNumber shouldNotBe null
        }

        test("지불 금액이 1000원 초과하면 티켓을 구매할 수 없다.") {
            assertThrows<IllegalArgumentException> { LottoTicket.purchase(payment = 1500) }
        }

        test("지불 금액이 1000원 미만이면 티켓을 구매할 수 없다.") {
            assertThrows<IllegalArgumentException> { LottoTicket.purchase(payment = 500) }
        }

        test("지불 금액이 1000원이면 티켓을 구매할 수 있다.") {
            val actual = LottoTicket.purchase(payment = 1000)
            actual shouldNotBe null
            actual.lottoStatus shouldBe LottoStatus.WAITING
            actual.matchCount shouldBe 0
        }

        test("수동 로또 번호로 구매할 수 있다.") {
            val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(5, 10, 15, 20, 25, 30))
            val actual = LottoTicket.purchase(payment = 1000, manualNumber = lottoNumber)
            actual.lottoNumber.numbers shouldContainExactly lottoNumber.numbers
            actual.lottoStatus shouldBe LottoStatus.WAITING
            actual.matchCount shouldBe 0
        }
    }

    context("로또 티켓 당첨 비교") {
        val winningNumber = WinningNumber.from(numbers = listOf(5, 10, 15, 22, 33, 44))
        val lottoNumber = LottoNumber.manualGenerate(numbers = listOf(5, 10, 15, 20, 25, 30))
        val actual = LottoTicket.purchase(payment = 1000, lottoNumber)

        actual.match(winningNumber = winningNumber)

        actual.lottoStatus shouldBe LottoStatus.WIN
        actual.matchCount shouldBe 3
    }
})
