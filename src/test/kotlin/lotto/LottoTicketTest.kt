package lotto

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.collections.shouldBeSorted
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe

class LottoTicketTest : StringSpec({
    "로또 티켓은 6개의 번호를 가진다" {
        val numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
        val sut = LottoTicket(numbers)

        sut.numbers.size shouldBe 6
        sut.numbers shouldContainExactly listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
    }

    "로또 티켓은 6개 미만의 번호를 받으면 예외를 던진다" {
        val numbers = listOf(1, 2, 3, 4, 5).map(::LottoNumber)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }

    "로또 티켓은 6개 초과한 번호를 받으면 예외를 던진다" {
        val numbers = listOf(1, 2, 3, 4, 5, 6, 7).map(::LottoNumber)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }

    "로또 티켓의 각 번호는 오름차순으로 정렬된다" {
        val numbers = listOf(6, 4, 2, 5, 3, 1).map(::LottoNumber)

        val sut = LottoTicket(numbers)

        sut.numbers.shouldBeSorted()
        sut.numbers shouldContainInOrder listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)
    }

    "똑같은 로또 번호가 존재하면 예외를 던진다" {
        val numbers = listOf(1, 1, 3, 4, 5, 6).map(::LottoNumber)
        shouldThrow<IllegalArgumentException> {
            LottoTicket(numbers)
        }
    }

    "로또 티켓은 다른 로또 티켓과 비교하여 일치하는 숫자 개수를 반환할 수 있다" {
        val sut = LottoTicket(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))

        forAll(
            row(LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber)), 6),
            row(LottoTicket(numbers = listOf(2, 3, 4, 5, 6, 7).map(::LottoNumber)), 5),
            row(LottoTicket(numbers = listOf(3, 4, 5, 6, 7, 8).map(::LottoNumber)), 4),
            row(LottoTicket(numbers = listOf(4, 5, 6, 7, 8, 9).map(::LottoNumber)), 3),
            row(LottoTicket(numbers = listOf(5, 6, 7, 8, 9, 10).map(::LottoNumber)), 2),
            row(LottoTicket(numbers = listOf(6, 7, 8, 9, 10, 11).map(::LottoNumber)), 1),
            row(LottoTicket(numbers = listOf(7, 8, 9, 10, 11, 12).map(::LottoNumber)), 0),
        ) { lottoTicket, expectedCountOfMatches ->
            val result = sut.countOfMatches(lottoTicket)
            result shouldBe expectedCountOfMatches
        }
    }

    "로또 티켓은 보너스 로또 번호와 일치하는 로또 번호를 가지고 있으면 true를 반환한다" {
        val sut = LottoTicket(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))

        listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber).forEach { bonusNumber ->
            val result: Boolean = sut.matchesBonusBall(bonusNumber)
            result shouldBe true
        }
    }

    "로또 티켓은 보너스 로또 번호와 일치하지 않는 로또 번호를 가지고 있으면 false를 반환한다" {
        val sut = LottoTicket(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))

        val bonusNumber = LottoNumber(7)
        val result: Boolean = sut.matchesBonusBall(bonusNumber)
        result shouldBe false
    }

    "로또 티켓은 해당 로또 번호가 포함되어 있는지 여부를 알려줄 수 있다" {
        val sut = LottoTicket(listOf(1, 2, 3, 4, 5, 6).map(::LottoNumber))

        forAll(
            row(LottoNumber(1), true),
            row(LottoNumber(2), true),
            row(LottoNumber(3), true),
            row(LottoNumber(4), true),
            row(LottoNumber(5), true),
            row(LottoNumber(6), true),
            row(LottoNumber(7), false),
        ) { lottoNumber, expected ->
            sut.contain(lottoNumber) shouldBe expected
        }
    }
})
