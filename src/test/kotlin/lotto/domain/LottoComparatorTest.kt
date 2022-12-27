package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe

class LottoComparatorTest : StringSpec({
    "지난 주 당첨 번호와 로또 티켓을 비교해 맞은 개수를 확인해요" {
        val ticketBundle = listOf(
            LottoTicket(
                setOf(
                    LottoNumber(1),
                    LottoNumber(2),
                    LottoNumber(3),
                    LottoNumber(4),
                    LottoNumber(5),
                    LottoNumber(6),
                )
            )
        )
        val winningNumber = setOf(
            LottoNumber(1),
            LottoNumber(2),
            LottoNumber(3),
            LottoNumber(6),
            LottoNumber(8),
            LottoNumber(9),
        )

        val rank = LottoComparator.compare(ticketBundle, winningNumber)

        rank[4] shouldBe 1
    }
})
