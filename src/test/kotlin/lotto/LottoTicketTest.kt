package lotto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoTicketTest : StringSpec({

    "로또 티켓 한장을 생성하면 1부터 45까지 숫자 중에 중복되지 않는 6개의 숫자가 랜덤으로 생성된다." {
        repeat(100) {
            val lottoTicket = LottoTicket.generate()

            lottoTicket.numbers.all { it in 1..45 } shouldBe true
            lottoTicket.numbers.size shouldBe 6
            lottoTicket.numbers.distinct().size shouldBe 6
        }
    }
})
