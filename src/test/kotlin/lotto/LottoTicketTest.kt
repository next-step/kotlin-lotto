package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows
import java.lang.IllegalArgumentException

class LottoTicketTest : FunSpec({
    context("로또 티켓 구매") {
        test("티켓은 하나의 로또 번호를 가진다.") {
            val lottoTicket = LottoTicket.purchase(payment = 1000)
            lottoTicket.lottoNumber shouldNotBe null
        }

        test("지불 금액이 1000원 초과하면 티켓을 구매할 수 없다.") {
            assertThrows<IllegalArgumentException> { LottoTicket.purchase(payment = 1500) }
        }

        test("지불 금액이 1000원 미만이면 티켓을 구매할 수 없다.") {
            assertThrows<IllegalArgumentException> { LottoTicket.purchase(payment = 500) }
        }

        test("지불 금액이 1000원이면 티켓을 구매할 수 있다.") {
            val lottoTicket = LottoTicket.purchase(payment = 1000)
            lottoTicket shouldNotBe null
        }
    }
})
