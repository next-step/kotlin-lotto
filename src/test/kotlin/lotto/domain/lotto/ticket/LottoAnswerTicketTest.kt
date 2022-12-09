package lotto.domain.lotto.ticket

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.number.LottoNumber

class LottoAnswerTicketTest : FunSpec({
    context("로또 결과를 정상적으로 랜덤하게 생성한다") {
        withData(
            nameFn = { "$it" },
            (0..100).map {
                LottoTicket.randomGenerate()
            }
        ) { randomLottoTicket ->
            val lottoAnswerTicket = LottoAnswerTicket(randomLottoTicket)

            lottoAnswerTicket shouldNotBe null
            lottoAnswerTicket.answerLottoTicket shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            lottoAnswerTicket.answerLottoTicket shouldBeSortedWith Comparator.naturalOrder()
            lottoAnswerTicket.answerLottoTicket shouldContainExactly randomLottoTicket
        }
    }

    context("0~6개 일치 여부를 정확하게 계산한다") {
        withData(
            nameFn = { "${it.first.intersect(it.second.toSet()).size}개 일치: ${it.first}, ${it.second}" },
            listOf(
                listOf(1, 2, 3, 4, 5, 6) to listOf(7, 9, 15, 19, 22, 43),
                listOf(1, 2, 3, 4, 5, 6) to listOf(1, 7, 8, 9, 10, 11),
                listOf(1, 2, 3, 4, 5, 6) to listOf(1, 2, 7, 9, 10, 25),
                listOf(1, 2, 3, 4, 5, 6) to listOf(1, 2, 3, 9, 10, 25),
                listOf(1, 2, 3, 4, 5, 6) to listOf(1, 2, 3, 4, 10, 25),
                listOf(1, 2, 3, 4, 5, 6) to listOf(1, 2, 3, 4, 5, 25),
                listOf(1, 2, 3, 4, 5, 6) to listOf(1, 2, 3, 4, 5, 6),
            )
        ) { (lottoResultNumberList, lottoNumberList) ->
            val answerLottoTicket = LottoTicket(*lottoResultNumberList.toIntArray())
            val lottoAnswerTicket = LottoAnswerTicket(answerLottoTicket)

            val lottoTicket = LottoTicket(lottoNumberList.toLottoNumber())

            val matchCount = lottoAnswerTicket.matchCount(lottoTicket)
            val lottoTicketResult = lottoAnswerTicket.result(lottoTicket)

            val expectedMatchCount = lottoResultNumberList.intersect(lottoNumberList.toSet()).size
            matchCount shouldBe expectedMatchCount
            lottoTicketResult.matchCount shouldBe expectedMatchCount
        }
    }

    context("보너스 일치 여부를 정확하게 계산한다") {
        withData(
            nameFn = { "${it.first.intersect(it.third.toSet()).size}개 일치: ${it.first}, ${it.third}" },
            listOf(
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(8, 9, 15, 19, 22, 43)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 8, 9, 10, 11, 12)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 8, 9, 10, 25)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 9, 10, 25)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 10, 25)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 25)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 6)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(7, 9, 15, 19, 22, 43)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 7, 9, 10, 11, 12)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 7, 9, 10, 25)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 7, 10, 25)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 7, 25)),
                Triple(listOf(1, 2, 3, 4, 5, 6), 7, listOf(1, 2, 3, 4, 5, 7)),
            )
        ) { (lottoResultNumberList, bonusNumber, lottoNumberList) ->
            val answerLottoTicket = LottoTicket(*lottoResultNumberList.toIntArray())
            val lottoBonusNumber = LottoNumber(bonusNumber)
            val lottoAnswerTicket = LottoAnswerTicket(answerLottoTicket, lottoBonusNumber)

            val lottoTicket = LottoTicket(lottoNumberList.toLottoNumber())

            val matchCount = lottoAnswerTicket.matchCount(lottoTicket)
            val lottoTicketResult = lottoAnswerTicket.result(lottoTicket)

            val expectedMatchCount = lottoResultNumberList.intersect(lottoNumberList.toSet()).size
            val expectedIsBonus = lottoNumberList.contains(bonusNumber)
            matchCount shouldBe expectedMatchCount
            lottoTicketResult.matchCount shouldBe expectedMatchCount
            lottoTicketResult.isBonus shouldBe expectedIsBonus
        }
    }
})

fun List<Int>.toLottoNumber(): List<LottoNumber> {
    return this.map { LottoNumber(it) }
}
