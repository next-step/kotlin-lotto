package lotto.model

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class LottoResultsTest : BehaviorSpec({
    Given("로또 결과") {
        When("로또 결과가 1, 2, 3, 4, 5, 6이고 당첨 번호가 1, 2, 3, 4, 5, 6 생성 했을 때") {
            val lottoResults = LottoResults(
                listOf(LottoTicket(numbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) })),
                listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }
            )
            Then("6개 1개 일치") {
                lottoResults.results shouldBe (0..LottoTicket.NUMBER_COUNT + 1).associateWith { 0 }.toMutableMap().apply { this[6] = 1 }
            }
            Then("수익률은") {
                lottoResults.profit shouldBe 2000000.0
            }
        }
    }
})
