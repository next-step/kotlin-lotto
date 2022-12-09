package lotto.domain.lotto.result

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.ticket.LottoTicket
import org.junit.jupiter.api.assertThrows

class LottoTicketResultTest : FunSpec({

    context("LottoTicketResult가 정상적으로 생성된다") {
        withData(
            nameFn = { "${it.first}개 일치, 보너스 번호 일치 여부: ${it.second}" },
            (0..6).flatMap { listOf(it to true, it  to false) }
        ) { (matchCount, isBonus) ->
            val lottoTicketResult = LottoTicketResult(matchCount, isBonus)

            lottoTicketResult shouldNotBe null
            lottoTicketResult.matchCount shouldBe matchCount
            lottoTicketResult.isBonus shouldBe isBonus
        }
    }

    context("matchCount가 (${0}..${LottoTicket.TOTAL_COUNT_LOTTO_NUMBER}) 안에 있지 않을 경우, IllegalArgumentException") {
        withData(
            nameFn = { "${it.first}개 일치, 보너스 번호 일치 여부: ${it.second}" },
            ((-100..-1) + (7..100)).flatMap { listOf(it to true, it  to false) }
        ) { (matchCount, isBonus) ->
            assertThrows<IllegalArgumentException> {
                LottoTicketResult(matchCount, isBonus)
            }
        }
    }
})
