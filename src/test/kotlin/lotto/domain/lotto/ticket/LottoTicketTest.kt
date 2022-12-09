package lotto.domain.lotto.ticket

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.number.LottoNumber
import org.junit.jupiter.api.assertThrows

class LottoTicketTest : FunSpec({
    test("로또 티켓 1장이 정상적으로 랜덤 생성된다") {
        val lottoTicket = LottoTicket.randomGenerate()
        val lottoNumberList = lottoTicket.lottoNumberList

        lottoTicket shouldNotBe null
        lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
        lottoNumberList.distinct() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
    }

    context("로또 티켓 1장이 정상적으로 생성된다") {
        withData(
            nameFn = { "LottoTicket($it)" },
            (1..100).map { LottoTicket.randomGenerate() }
                .map {
                    it.lottoNumberList.map { lottoNumber ->
                        lottoNumber.number
                    }
                }
        ) { lottoNumberList ->
            val lottoTicket = LottoTicket(1, 2, 3, 4, 5, 6)
            lottoTicket shouldNotBe null
            lottoTicket.lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
            lottoTicket.lottoNumberList.distinct() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
        }
    }

    test("로또 번호 ${LottoTicket.TOTAL_COUNT_LOTTO_NUMBER}개를 랜덤하게 정상적으로 발급한다.") {
        val givenLottoNumberCount = LottoTicket.TOTAL_COUNT_LOTTO_NUMBER

        val lottoTicket = LottoTicket.randomGenerate()
        val lottoNumberList = lottoTicket.lottoNumberList

        lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
        lottoNumberList shouldHaveSize givenLottoNumberCount
        lottoNumberList.map { it.number }.distinct() shouldHaveSize givenLottoNumberCount
    }

    context("로또 결과 번호 갯수가 6개가 아닐 경우, IllegalArgumentException") {
        withData(
            nameFn = { "${it.size}개일 경우" },
            ((1..5) + (7..10)).map { lottoResultNumberCount ->
                randomShuffle(lottoResultNumberCount)
                    .map { it.number }
            }
        ) { invalidSizeOfLottoNumberList ->
            assertThrows<IllegalArgumentException> { LottoTicket(*invalidSizeOfLottoNumberList.toIntArray()) }
        }
    }

    context("중복된 로또 번호가 있을 경우, IllegalArgumentException") {
        withData(
            nameFn = { "$it" },
            listOf(
                listOf(1, 1, 2, 3, 4, 5),
                listOf(1, 2, 3, 4, 1, 6),
                listOf(1, 2, 3, 4, 5, 5)
            )
        ) { duplicatedLottoNumberList ->
            assertThrows<IllegalArgumentException> { LottoTicket(*duplicatedLottoNumberList.toIntArray()) }
        }
    }
})

fun randomShuffle(count: Int): List<LottoNumber> {
    require(count > 0)

    return LottoNumber.values()
        .shuffled()
        .take(count)
        .sorted()
}
