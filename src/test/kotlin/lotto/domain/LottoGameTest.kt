package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoGameTest : StringSpec({
    "should generate multiple lotto tickets" {
        val tickets = LottoGame.generateTickets(8800)
        tickets shouldHaveSize 8
        tickets.all { it.getNumbers().size == 6 && it.getNumbers().all { number -> number in 1..45 } } shouldBe true
    }
})
