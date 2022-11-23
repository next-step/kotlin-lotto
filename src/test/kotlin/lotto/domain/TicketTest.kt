package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.shouldBe

class TicketTest : StringSpec({

    val ticket = Ticket()

    "티켓의 번호는 총 6개여야 한다"{
        ticket.numbers.size shouldBe 6
    }

    "티켓의 번호는 1부터 45 사이의 숫자여야 한다"{
        ticket.numbers.filter { it in NumberPolicy.LOTTO_RANGE }.size shouldBe 6
    }

    "티켓은 정렬되어 있어야 한다"{
        ticket.numbers.shouldBeSorted()
    }

})
