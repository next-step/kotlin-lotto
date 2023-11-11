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
    context("로또 구입 티켓 생성") {
        test("생성된 숫자는 1부터 45까지의 6개의 서로 다른 숫자") {
            val ticket = LottoTicketGenerator.create()

            ticket.numbers.min() shouldBeGreaterThanOrEqual 1
            ticket.numbers.max() shouldBeLessThanOrEqual 45
            ticket.numbers.size shouldBe 6
            ticket.numbers.distinct().count() shouldBe 6
            ticket.numbers.zipWithNext { before, next -> before shouldBeLessThan next }
        }
    }

    context("당첨 번호 티켓 생성") {
        test("1부터 45까지의 6개의 서로 다른 숫자로 티켓 생성") {
            val numbers = listOf(1, 2, 3, 4, 13, 23)
            val ticket = LottoTicketGenerator.create(numbers)

            ticket.numbers shouldBe numbers
        }

        test("오름 차순으로 정렬되지 않았다면 티켓 생성시 정렬") {
            val numbers = listOf(6, 1, 5, 3, 4, 2)
            val ticket = LottoTicketGenerator.create(numbers)

            ticket.numbers shouldBe listOf(1, 2, 3, 4, 5, 6)
        }

        test("6개의 숫자가 아닐 경우 당첨 번호 생성 불가") {
            forAll(
                row(listOf(1, 2, 3, 4, 13, 23, 33)),
                row(listOf(1, 2, 3, 4, 13)),
            ) { numbers ->
                shouldThrow<IllegalArgumentException> {
                    LottoTicketGenerator.create(numbers)
                }
            }
        }

        test("1부터 45까지의 범위를 넘으면 생성 불가") {
            forAll(
                row(listOf(1, 2, 3, 4, 13, 46)),
                row(listOf(0, 1, 2, 3, 4, 13)),
            ) { numbers ->
                shouldThrow<IllegalArgumentException> {
                    LottoTicketGenerator.create(numbers)
                }
            }
        }

        test("중복된 숫자가 있으면 생성 불가") {
            shouldThrow<IllegalArgumentException> {
                LottoTicketGenerator.create(listOf(1, 2, 3, 4, 5, 5))
            }
        }
    }

    context("로또 티켓이 될 수 있는 수인지 검증") {
        test("1부터 45 사이의 숫자라면 해당 숫자가 반환된다") {
            forAll(
                row(1),
                row(13),
                row(45),
            ) { number ->
                val result = LottoTicketGenerator.checkNumber(number)

                result shouldBe number
            }
        }
        test("1보다 작은 숫자라면 에러가 발생한다") {
            shouldThrow<IllegalArgumentException> {
                LottoTicketGenerator.checkNumber(0)
            }
        }
        test("45보다 큰 숫자라면 에러가 발생한다") {
            shouldThrow<IllegalArgumentException> {
                LottoTicketGenerator.checkNumber(46)
            }
        }
    }
})
