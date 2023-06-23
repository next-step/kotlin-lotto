package lotto

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe

class LottoMatcherTest : FunSpec({
    test("당첨 번호와 일치하는 로또의 숫자 개수를 반환한다.") {
        // given
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)
        val myNumbers = Numbers(listOf(1, 3, 5, 7, 8, 9))
        val lottoTickets = LottoTicket(listOf(myNumbers))
        val lottoMatcher = LottoMatcher(winningNumbers)
        val expected = LottoResult(mapOf(3 to 1))

        // when
        val actual = lottoMatcher.getMatchingResult(lottoTickets)

        // then
        actual.map shouldBe expected.map
    }
})
