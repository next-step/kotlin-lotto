package lotto.domain.lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldContainExactly
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.number.toInt
import lotto.domain.lotto.number.toLottoNumber
import lotto.domain.lotto.ticket.LottoTicket
import org.junit.jupiter.api.assertThrows

class LottoAnswerTest : FunSpec({
    context("로또 결과를 정상적으로 랜덤하게 생성한다") {
        withData(
            nameFn = { "$it" },
            (0..100).map {
                LottoNumber.randomShuffle(LottoTicket.TOTAL_COUNT_LOTTO_NUMBER)
                    .map { it.number }
            }
        ) { lottoResultNumberList ->
            val lottoAnswer = LottoAnswer(lottoResultNumberList)

            lottoAnswer shouldNotBe null
            lottoAnswer.lottoNumberList shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
            lottoAnswer.lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
            lottoAnswer.lottoNumberList.map { it.number } shouldContainExactly lottoResultNumberList
        }
    }

    context("중복된 로또 결과 번호가 있을 경우, IllegalArgumentException") {
        withData(
            nameFn = { "$it" },
            listOf(
                listOf(1, 1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 1, 6),
                listOf(1, 2, 3, 4, 5, 5)
            )
        ) { invalidInput ->
            assertThrows<IllegalArgumentException> { LottoAnswer(invalidInput) }
        }
    }

    context("로또 결과 번호 갯수가 6개가 아닐 경우, IllegalArgumentException") {
        withData(
            nameFn = { "${it.size}개일 경우" },
            ((1..5) + (7..10)).map { lottoResultNumberCount ->
                LottoNumber.randomShuffle(lottoResultNumberCount)
                    .map { it.number }
            }
        ) { invalidInput ->
            assertThrows<IllegalArgumentException> { LottoAnswer(invalidInput) }
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
            val lottoAnswer = LottoAnswer(lottoResultNumberList)

            val lottoTicket = LottoTicket(lottoNumberList.toLottoNumber())

            val result = lottoAnswer.calculate(lottoTicket)

            result shouldBe lottoResultNumberList.intersect(lottoNumberList.toSet()).size
        }
    }

    test("로또의 결과를 정확하게 계산한다") {
        val lottoAnswer = LottoAnswer(listOf(1, 2, 3, 4, 5, 6))
        val lotto = Lotto(14000, 1000)

        val expected = lotto.lottoTicketList.map { lottoTicket ->
            lottoTicket.lottoNumberList.toInt()
                .intersect(lottoAnswer.lottoNumberList.toInt().toSet())
                .size
        }.groupingBy { it }.eachCount()

        lottoAnswer.calculate(lotto) shouldBe expected
    }
})
