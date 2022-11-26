package lotto.domain.lotto.ticket

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldBeSortedWith
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldNotBe

class LottoTicketTest : FunSpec({
    test("로또 티켓 1장이 정상적으로 생성된다") {
        val lottoTicket = LottoTicket.randomGenerate()
        val lottoNumberList = lottoTicket.lottoNumberList

        lottoTicket shouldNotBe null
        lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
        lottoNumberList.distinct() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
    }

    test("로또 번호 ${LottoTicket.TOTAL_COUNT_LOTTO_NUMBER}개를 랜덤하게 정상적으로 발급한다.") {
        val givenLottoNumberCount = LottoTicket.TOTAL_COUNT_LOTTO_NUMBER

        val lottoTicket = LottoTicket.randomGenerate()
        val lottoNumberList = lottoTicket.lottoNumberList

        lottoNumberList shouldBeSortedWith Comparator.naturalOrder()
        lottoNumberList shouldHaveSize givenLottoNumberCount
        lottoNumberList.map { it.number }.distinct() shouldHaveSize givenLottoNumberCount
    }
})

