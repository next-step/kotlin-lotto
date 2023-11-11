package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe

class LottoTicketGeneratorSpec : FunSpec({
    test("1부터 45까지의 6개의 서로 다른 숫자로 오름 차순으로 생성") {
        val ticket = LottoTicketGenerator.create()

        ticket.numbers.min() shouldBeGreaterThanOrEqual 1
        ticket.numbers.max() shouldBeLessThanOrEqual 45
        ticket.numbers.size shouldBe 6
        ticket.numbers.distinct().count() shouldBe 6
        ticket.numbers.zipWithNext { before, next -> before shouldBeLessThan next }
    }
})
