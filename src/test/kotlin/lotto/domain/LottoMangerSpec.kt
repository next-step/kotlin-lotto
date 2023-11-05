package lotto.domain

import io.kotest.assertions.forEachAsClue
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.ints.shouldBeLessThan
import io.kotest.matchers.ints.shouldBeLessThanOrEqual
import io.kotest.matchers.shouldBe

class LottoMangerSpec : DescribeSpec({
    describe("로또 생성") {
        forAll(
            row(1..5, 5),
            row(1..45, 6),
        ) { numbersRange, numbersCount ->
            describe("로또 수 범위($numbersRange)와 로또 수 개수($numbersCount)") {
                val storage = LottoTicketStorage()
                val manager = LottoManager(LottoTicketGenerator(numbersRange, numbersCount), storage)
                val count = TicketCount(5)
                describe("티켓 수${count.value}") {
                    val result = manager.createTicket(count)
                    it("티켓 수${count.value}만큼 티켓이 생성") {
                        result.size shouldBe count.value
                    }
                    it("티켓을 저장") {
                        val stored = storage.getAll()
                        stored.size shouldBe count.value
                        stored.map { it.numbers } shouldBe result.map { it.numbers }
                    }
                    it("티켓당 수의 갯수 = 로또 수(${numbersCount})") {
                        result.forEach { ticket ->
                            ticket.numbers.size shouldBe numbersCount
                        }
                    }
                    it("티켓의 수 범위 = 로또의 수 범위(${numbersRange})") {
                        result.forEach { ticket ->
                            ticket.numbers.forEach {
                                it shouldBeGreaterThanOrEqual numbersRange.first
                                it shouldBeLessThanOrEqual numbersRange.last
                            }
                        }
                    }
                    it("티켓의 수는 각각 다른 숫자") {
                        result.forEach { ticket ->
                            ticket.numbers.distinct().count() shouldBe ticket.numbers.count()
                        }
                    }
                    it("티켓의 숫자들은 작은수부터 정렬") {
                        result.forEach { ticket ->
                            ticket.numbers.zipWithNext { before, next -> before shouldBeLessThan next  }
                        }
                    }
                }
            }
        }
    }
})
