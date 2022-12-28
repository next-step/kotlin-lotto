package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.utils.LottoNumberTestUtils

class LottoComparatorTest : StringSpec({
    "지난 주 당첨 번호와 로또 티켓을 비교해 맞은 개수를 확인해요" {
        val winningNumbers = LottoNumberTestUtils.lottoNumbers(1, 2, 3, 7, 8, 9)
        val lottoNumbers = LottoNumberTestUtils.lottoNumbers(1, 2, 3, 4, 5, 6)

        val ticketBundle = listOf(
            LottoTicket(lottoNumbers)
        )

        val rank = LottoComparator.compare(ticketBundle, winningNumbers)

        rank.rank[WinningAmount.FOURTH_PLACE] shouldBe 1
    }
})
