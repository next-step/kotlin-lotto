package lotto.application

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.config.LottoConfig
import lotto.domain.LottoCreateRequest
import lotto.domain.LottoNumbersFixtureMaker
import lotto.domain.LottoType
import lotto.domain.ProfitRate
import lotto.domain.Rank
import lotto.domain.WinningNumbers

class LottoServiceTest : BehaviorSpec({

    Given("유효한 로또 서비스가 있다") {
        val service = LottoService(
            lottoNumbersGenerators = mapOf(
                LottoType.AUTO to LottoNumberFixtureGenerator(listOf(1, 2, 3, 4, 5, 6))
            ),
            profitCalculator = LottoConfig.profitCalculator
        )
        When("유효한 로또 생성 정보를 전달하면") {
            val request = LottoCreateRequest(money = 1000)
            val winningNumbers =
                LottoNumbersFixtureMaker.createLottoNumbers(listOf(1, 2, 3, 8, 11, 7)).let(::WinningNumbers)


            Then("당첨 결과와 수익율을 반환한다.") {
                val actual = service.getWinningStatistics(request = request, winningNumbers = winningNumbers)
                val expected = ProfitRate(5.0)

                actual.winningStatistics[Rank.FOURTH] shouldBe 1
                actual.profitRate shouldBe expected
            }
        }

        When("유효하지 않은 로또 생성 정보를 전달하면") {
            val request = LottoCreateRequest(money = 900)
            val winningNumbers =
                LottoNumbersFixtureMaker.createLottoNumbers(listOf(1, 2, 3, 8, 11, 7)).let(::WinningNumbers)

            Then("예외를 던진다.") {
                shouldThrow<IllegalArgumentException> {
                    service.getWinningStatistics(request = request, winningNumbers = winningNumbers)
                }
            }
        }
    }

    Given("로또 번호 생성기가 없는 로또 서비스가 있다. ") {
        val service = LottoService(
            lottoNumbersGenerators = emptyMap(),
            profitCalculator = LottoConfig.profitCalculator
        )

        When("유효한 로또 번호를 전달하면") {
            val request = LottoCreateRequest(money = 1000)
            val winningNumbers =
                LottoNumbersFixtureMaker.createLottoNumbers(listOf(1, 2, 3, 8, 11, 7)).let(::WinningNumbers)

            Then("예외를 던진다.") {
                shouldThrow<IllegalStateException> {
                    service.getWinningStatistics(request = request, winningNumbers = winningNumbers)
                }
            }

        }
    }


})
