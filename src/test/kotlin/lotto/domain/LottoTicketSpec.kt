package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class LottoTicketSpec : FunSpec({
    val oneToSixLottoNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6))

    context("한 장 가격(1_000)이 주어지면 총 장수에 대한 로또 구매 금액 계산") {
        val ticketPrice = Amount(1000)

        forAll(
            row(listOf(oneToSixLottoNumber), 1000),
            row(listOf(oneToSixLottoNumber, oneToSixLottoNumber), 2000),
            row(listOf(oneToSixLottoNumber, oneToSixLottoNumber, oneToSixLottoNumber), 3000),
        ) { lottoNumbers, expectAmount ->
            test("로또를 ${lottoNumbers.size}장 구매했을 때 총 구매 금액 $expectAmount") {

                val ticket = LottoTicket(lottoNumbers)

                val result = ticket.calculateTotalPriceBy(ticketPrice)

                result.value shouldBe expectAmount
            }
        }
    }

    context("티켓 장수 구하기") {
        forAll(
            row(LottoTicket(listOf(oneToSixLottoNumber)), 1),
            row(LottoTicket(listOf(oneToSixLottoNumber, oneToSixLottoNumber)), 2),
            row(LottoTicket(listOf(oneToSixLottoNumber, oneToSixLottoNumber, oneToSixLottoNumber)), 3),
        ) { ticket, count ->
            test("${count}장 구매한 티켓에서 장수를 세면 $count 반환") {
                ticket.count shouldBe count
            }
        }
    }

    context("로또 티켓 등수별 당첨 장수 생성") {
        val bonusNumber = 7
        val winningLotto = WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), bonusNumber)
        val nonMatchedLotto = LottoNumber(listOf(101, 102, 103, 104, 105, 106))
        val oneMatchedLotto = LottoNumber(listOf(1, 102, 103, 104, 105, 106))
        val threeMatchedLotto = LottoNumber(listOf(1, 2, 3, 104, 105, 106))
        val fourMatchedLotto = LottoNumber(listOf(1, 2, 3, 4, 105, 106))
        val fourMatchedLottoWithBonus = LottoNumber(listOf(1, 2, 3, 4, 105, bonusNumber))
        val fiveMatchedLotto = LottoNumber(listOf(1, 2, 3, 4, 5, 106))
        val fiveMatchedLottoWithBonus = LottoNumber(listOf(1, 2, 3, 4, 5, bonusNumber))
        val allMatchedLotto = LottoNumber(listOf(1, 2, 3, 4, 5, 6))


        test("한 장도 당첨되지 않음") {
            val ticket = LottoTicket(listOf(nonMatchedLotto, oneMatchedLotto))

            val result = ticket determineResultBy winningLotto

            result.value shouldBe mapOf(LottoRank.MISS to 2)
        }

        test("1등 1장, 2등 1장, 3등 2장, 4등 3장, 5등 1장, 당첨 안된 5장") {
            val ticket = LottoTicket(
                listOf(
                    allMatchedLotto,
                    fiveMatchedLottoWithBonus,
                    fiveMatchedLotto, fiveMatchedLotto,
                    fourMatchedLotto, fourMatchedLotto, fourMatchedLottoWithBonus,
                    threeMatchedLotto,
                    oneMatchedLotto, oneMatchedLotto, oneMatchedLotto, oneMatchedLotto, nonMatchedLotto
                )
            )

            val result = ticket determineResultBy winningLotto

            result.value shouldBe mapOf(
                LottoRank.FIRST to 1,
                LottoRank.SECOND to 1,
                LottoRank.THIRD to 2,
                LottoRank.FOURTH to 3,
                LottoRank.FIFTH to 1,
                LottoRank.MISS to 5,
            )
        }
    }
})
