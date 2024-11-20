package lotto.service

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto.domain.Lotto
import lotto.domain.LottoRank

class LottoServiceTest : StringSpec({
    val lottoService = LottoService(Lotto(14000))

    "구매한 개수만큼 로또를 발급해야 한다." {
        val lottoList = lottoService.lottoIssuance().map { it.numbers() }
        lottoList.size shouldBe 14
    }

    "수익률을 계산해야 한다. (당첨 금액 / 구매 금액 의 소수점 둘째자리까지 버림)" {
        val lottoTickets = lottoService.lottoIssuance()
        val winningNumbers = listOf(1, 2, 3, 4, 5, 6)

        val totalPrize = lottoTickets.sumOf { ticket ->
            LottoRank.from(ticket.matchCount(winningNumbers)).prize
        }

        val profitRate = lottoService.calculateProfitRate(totalPrize)
        val expectedProfitRate = "0.00".toBigDecimal()

        profitRate shouldBe expectedProfitRate
    }
})