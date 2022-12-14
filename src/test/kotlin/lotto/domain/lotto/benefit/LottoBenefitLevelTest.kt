package lotto.domain.lotto.benefit

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.result.LottoTicketResult

class LottoBenefitLevelTest : FunSpec({
    context("번호 일치 갯수 별로 상금을 정상적으로 리턴한다") {
        withData(
            nameFn = { "${it.matchCount}개 일치할 경우, ${it.benefitPerTicket}원" },
            LottoBenefitLevel.values().filter { it.matchCount >= 0 }.toList()
        ) {
            LottoBenefitLevel.benefitPerTicketOf(LottoTicketResult(it.matchCount, it.isBonus)) shouldBe it.benefitPerTicket
        }
    }

    context("LottoBenefitLevel을 정상적으로 찾아준다") {
        withData(
            nameFn = { "${it.matchCount}개 일치, 보너스 번호 일치 여부: ${it.isBonus}" },
            LottoBenefitLevel.validBenefitLevelSet().map { LottoTicketResult(it.matchCount, it.isBonus) }
        ) {
            val lottoBenefitLevel = LottoBenefitLevel.of(it)
            lottoBenefitLevel shouldNotBe null
        }
    }
})
