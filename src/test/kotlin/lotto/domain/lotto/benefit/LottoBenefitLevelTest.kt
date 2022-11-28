package lotto.domain.lotto.benefit

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe

class LottoBenefitLevelTest : FunSpec({
    context("번호 일치 갯수 별로 상금을 정상적으로 리턴한다") {
        withData(
            nameFn = { "${it.first}개 일치할 경우, ${it.second}원" },
            LottoBenefitLevel.values().map { it.matchCount to it.benefitPerTicket }
        ) { (matchCount, benefitPerTicket) ->
            LottoBenefitLevel.benefitPerTicketOf(matchCount) shouldBe benefitPerTicket
        }
    }
})
