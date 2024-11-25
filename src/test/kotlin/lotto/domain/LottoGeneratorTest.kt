package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldBeUnique
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe

class LottoGeneratorTest : StringSpec ({
    "should generate a single lotto ticket with 6 unique numbers" {
        val ticket = LottoGenerator.generateTicket()
        ticket shouldHaveSize 6
        ticket.shouldBeUnique()
        ticket.all { it in 1..45 } shouldBe true
    }
})
