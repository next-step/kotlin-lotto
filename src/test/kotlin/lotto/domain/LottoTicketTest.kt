package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.WithDataTestName
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeInRange
import io.kotest.matchers.shouldBe

class LottoTicketTest : FunSpec({

    context("로또티켓 정상 생성") {
        test("기본 생성자 사용") {
            val lottoNumbers = setOf(1, 2, 3, 4, 5, 6)
            val lottoTicket = LottoTicket(lottoNumbers = lottoNumbers)

            lottoTicket.lottoNumbers shouldBe lottoNumbers
        }

        test("자동 발급") {
            val lottoTicket = LottoTicket.issueByAuto()
            lottoTicket.lottoNumbers.forEach {
                it shouldBeInRange LottoTicket.MIN_LOTTO_NUMBER..LottoTicket.MAX_LOTTO_NUMBER
            }
            lottoTicket.lottoNumbers.size shouldBe LottoTicket.LOTTO_TICKET_NUMBER_SIZE
        }
    }

    context("로또 숫자 6개 아닌 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "lottNumbers : $it" },
            setOf(1, 2, 3, 4, 5),
            setOf(1, 2, 3, 4, 5, 6, 7),
        ) { lottoNumbers ->
            shouldThrow<IllegalArgumentException> {
                LottoTicket(lottoNumbers = lottoNumbers)
            }
        }
    }

    context("로또 숫자가 1~45 아닌 경우 IllegalArgumentException throw") {
        withData(
            nameFn = { "lottNumbers : $it" },
            setOf(-1, 2, 3, 4, 5, 6),
            setOf(0, 4, 10, 22, 1, 2),
            setOf(46, 44, 43, 42, 41, 40),
        ) { lottoNumbers ->
            shouldThrow<IllegalArgumentException> {
                LottoTicket(lottoNumbers = lottoNumbers)
            }
        }
    }

    context("로또는 당첨번호로부터 몇개의 숫자가 일치하는지 확인할 수 있다.") {
        withData(
            LottoMatchNumberCountTestData(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 6), 6),
            LottoMatchNumberCountTestData(setOf(1, 2, 3, 4, 5, 6), setOf(1, 2, 3, 4, 5, 7), 5),
            LottoMatchNumberCountTestData(setOf(10, 20, 30, 40, 41, 42), setOf(10, 2, 3, 4, 5, 6), 1),
            LottoMatchNumberCountTestData(setOf(10, 20, 30, 40, 41, 42), setOf(1, 2, 3, 4, 5, 6), 0),
        ) { (lottoNumbers, winningLottoNumbers, matchNumberCount) ->

            val lottoTicket = LottoTicket(lottoNumbers)
            lottoTicket.matchNumberCount(winningLottoNumbers) shouldBe matchNumberCount
        }
    }
})

data class LottoMatchNumberCountTestData(val lottoNumbers1: Set<Int>, val lottoNumbers2: Set<Int>, val matchNumberCount: Int) : WithDataTestName {
    override fun dataTestName(): String = "$lottoNumbers1, $lottoNumbers2 => matchNumberCount : $matchNumberCount"
}
