package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe

class LottoTicketGeneratorSpec : FunSpec({
    test("주어진 범위에서 주어진 개수의 서로 다른 숫자가 추출된다") {
        forAll(
            row(1..1, 1),
            row(1..6, 6),
            row(1..45, 6)
        ) { range, count ->

            val ticket = LottoTicketGenerator(range, count).create()

            ticket.numbers.forEach {
                it shouldBeGreaterThanOrEqual range.first
                it shouldBeLessThanOrEqual range.last
            }
            ticket.numbers.size shouldBe count
            ticket.numbers.distinct().count() shouldBe ticket.numbers.count()
            ticket.numbers.zipWithNext { before, next -> before shouldBeLessThan next }
        }
    }

    test("범위로 주어진 수의 개수보다 더 많은 개수를 추출하는 생성기는 생성할 수 없다") {
        val range = 1..6
        val count = 7

        shouldThrow<IllegalArgumentException> {
            LottoTicketGenerator(range, count)
        }
    }
})
