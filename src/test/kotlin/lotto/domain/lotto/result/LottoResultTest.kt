package lotto.domain.lotto.result

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.ints.shouldBeGreaterThanOrEqual
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.Lotto
import lotto.domain.lotto.benefit.LottoBenefitLevel
import lotto.domain.lotto.number.LottoNumber
import lotto.domain.lotto.ticket.LottoAnswerTicket
import lotto.domain.lotto.ticket.LottoTicket

class LottoResultTest : FunSpec({
    context("LottoResult가 정상적으로 생성된다") {
        withData(
            (1..100).map { LottoTicket.randomGenerate() }
                .map { randomLottoTicket ->
                    LottoAnswerTicket(
                        randomLottoTicket,
                        LottoNumber.values().find { !randomLottoTicket.contains(it) })
                }
        ) { givenLottoAnswerTicket ->
            val givenLottoCost = 1400000
            val givenLottoTicketPrice = 1000

            val lotto = Lotto(givenLottoCost, givenLottoTicketPrice)
            val lottoResult = lotto.result(givenLottoAnswerTicket)

            lottoResult shouldNotBe null

            lottoResult.lottoBenefit shouldNotBe null
            lottoResult.lottoResultMap shouldNotBe null

            LottoBenefitLevel.values().forEach {
                lottoResult.lottoResultMap.winningCount(it) shouldBeGreaterThanOrEqual 0
            }
        }
    }

})
