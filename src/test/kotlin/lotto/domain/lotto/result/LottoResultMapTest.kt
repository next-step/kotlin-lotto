package lotto.domain.lotto.result

import io.kotest.core.spec.style.FunSpec
import io.kotest.datatest.withData
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import lotto.domain.lotto.benefit.LottoBenefitLevel

class LottoResultMapTest : FunSpec({
    context("LottoResultMap이 정상적으로 생성된다") {
        withData(
            nameFn = { "LottoTicketResult 갯수: ${it.size}" },
            (1..100).map { (0..it).map { randomGenerateLottoTicketResult() } }
        ) {
           val lottoResultMap = LottoResultMap(it)

            lottoResultMap shouldNotBe null
        }
    }

    test("아무 결과 없을 경우, 모든 당첨 갯수가 0이다") {
        val lottoResultMap = LottoResultMap(emptyList())

        lottoResultMap shouldNotBe null

        LottoBenefitLevel.values().forEach {
            lottoResultMap.winningCount(it) shouldBe 0
        }
    }

})

fun randomGenerateLottoTicketResult(): LottoTicketResult =
    (0..6).flatMap { listOf(it to true, it  to false) }
        .map{ LottoTicketResult(it.first, it.second) }
        .random()
