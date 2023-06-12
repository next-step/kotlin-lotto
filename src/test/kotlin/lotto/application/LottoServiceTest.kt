package lotto.application

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.config.LottoConfig
import lotto.domain.LottoCreateRequest
import lotto.domain.Lottos
import lotto.domain.ProfitRate
import lotto.domain.Rank
import lotto.fixture.LottoFixtureGenerator

class LottoServiceTest : BehaviorSpec({

    Given("유효한 로또 서비스가 있다") {
        val service = LottoConfig.lottoService

        When("유효한 로또 생성 정보를 전달하면") {
            val lottos = Lottos(
                values = listOf(
                    LottoFixtureGenerator.createLotto(listOf(1, 2, 3, 4, 5, 6))
                )
            )
            val request = LottoCreateRequest(
                money = 1000,
                winningNumbers = listOf("1", "2", "3", "8", "11", "7"),
                lottos = lottos
            )

            Then("당첨 결과와 수익율을 반환한다.") {
                val actual = service.getWinningStatistics(request = request)
                val expected = ProfitRate(5.0)

                actual.winningStatistics[Rank.FOURTH] shouldBe 1
                actual.profitRate shouldBe expected
            }
        }
    }

    Given("로또 번호 생성기가 없는 로또 서비스가 있다. ") {
        val service = LottoService(
            lottoNumbersGenerators = emptyMap(),
            profitCalculator = LottoConfig.profitCalculator
        )

        When("로또 발급을 요청하면 ") {
            Then("예외를 던진다.") {
                shouldThrow<IllegalStateException> {
                    service.issueLottos(1000)
                }
            }
        }
    }
})
