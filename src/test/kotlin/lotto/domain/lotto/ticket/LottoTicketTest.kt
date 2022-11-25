package lotto.domain.lotto.ticket

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.collections.shouldHaveSize
import io.kotest.matchers.shouldNotBe

class LottoTicketTest : FunSpec({
    test("로또 티켓 1장이 정상적으로 생성된다") {
        val lottoTicket = LottoTicket.randomGenerate()
        val lottoNumberList = lottoTicket.lottoNumberList

        lottoTicket shouldNotBe null
        lottoNumberList shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
        lottoNumberList shouldContainInOrder lottoNumberList.sorted()
        lottoNumberList.map { it.number }.toSet() shouldHaveSize LottoTicket.TOTAL_COUNT_LOTTO_NUMBER
    }
})
