package lotto.generator.ticket

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

class AutoTicketGeneratorTest : BehaviorSpec({
    given("auto ticket generator") {
        `when`("creates lotto Tickets") {
            then("should provide correct ticket count") {
                AutoTicketGenerator.create(3).lottoTicketList.size shouldBe 3
            }
        }
    }
})
