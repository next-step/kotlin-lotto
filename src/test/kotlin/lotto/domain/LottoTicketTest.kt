package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainAll
import io.kotest.matchers.shouldBe

class LottoTicketTest : DescribeSpec({

    it("Int List 로 생성할수 있다") {
        // given
        val lottoNumbersByInt = listOf(1, 2, 3, 4, 5, 6)

        // when
        val lottoTicket = LottoTicket.ofInts(lottoNumbersByInt)

        // then
        lottoTicket.lottoTicketNumbers.value.size shouldBe lottoNumbersByInt.size
        lottoTicket.lottoTicketNumbers.value.map { it.value } shouldContainAll lottoNumbersByInt
    }

    it("로또 숫자로 일치하는 번호 갯수를 알수 있다") {
        // given
        val lottoTicket = LottoTicket.ofInts(listOf(1, 2, 3, 4, 5, 6))
        val lottoNumbers = LottoTicketNumbers.ofInts(listOf(1, 2, 3, 10, 20, 30))

        // when
        val matchedCount = lottoTicket.getMatchedCount(lottoNumbers)

        // then
        matchedCount shouldBe 3
    }
})
