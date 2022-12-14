package lotto.domain.lotto.price

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.assertThrows

class LottoTicketPriceTest : FunSpec({
    test("LottoTicketPrice가 정상적으로 디폴트 가격으로 생성된다") {
        val lottoTicketPrice = LottoTicketPrice()

        lottoTicketPrice shouldNotBe null
        lottoTicketPrice.price shouldBe LottoTicketPrice.DEFAULT_LOTTO_TICKET_PRICE
    }

    context("LottoTicketPrice가 정상적으로 생성된다") {
        withData(
            nameFn = { "price=$it" },
            (1..10000 step 50)
        ) {
            val lottoTicketPrice = LottoTicketPrice(it)

            lottoTicketPrice shouldNotBe null
            lottoTicketPrice.price shouldBe it
        }
    }

    context("price가 0보다 작으면, IllegalArgumentException") {
        withData(
            nameFn = { "price=$it <= 0" },
            (0 downTo -10000  step 50)
        ) {
            assertThrows<IllegalArgumentException> {
                LottoTicketPrice(it)
            }
        }
    }
})
