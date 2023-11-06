package lotto.domain

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe
import lotto.test.LottoNumberGenerator

class LottoWinningNumberTest : BehaviorSpec({

    given("1,2,3,4,5,6 당첨 번호와 7 보너스 번호가 주어졌을 떄") {
        val winningNumbers = LottoWinningNumber(
            numbers = LottoNumbers(LottoNumberGenerator.generate(1, 2, 3, 4, 5, 6)),
            bonusNumber = LottoNumber(7)
        )

        `when`("1,2,3,4,5,6 로또 번호를 입력하면") {
            val lottoNumbers = LottoNumbers(LottoNumberGenerator.generate(1, 2, 3, 4, 5, 6))

            then("1등을 반환한다.") {
                val result = winningNumbers.evaluateMatchResult(lottoNumbers)
                result.lottiPrize shouldBe LottoPrize.FIRST
            }
        }

        `when`("1,2,3,4,5,7 로또 번호를 입력하면") {
            val lottoNumbers = LottoNumbers(LottoNumberGenerator.generate(1, 2, 3, 4, 5, 7))

            then("2등을 반환한다.") {
                val result = winningNumbers.evaluateMatchResult(lottoNumbers)
                result.lottiPrize shouldBe LottoPrize.SECOND
            }
        }

        `when`("1,2,3,4,5,8 로또 번호를 입력하면") {
            val lottoNumbers = LottoNumbers(LottoNumberGenerator.generate(1, 2, 3, 4, 5, 8))

            then("3등을 반환한다.") {
                val result = winningNumbers.evaluateMatchResult(lottoNumbers)
                result.lottiPrize shouldBe LottoPrize.THIRD
            }
        }

        `when`("10,11,12,13,14,15 로또 번호를 입력하면") {
            val lottoNumbers = LottoNumbers(LottoNumberGenerator.generate(10, 11, 12, 13, 14, 15))

            then("미당첨을 반환한다.") {
                val result = winningNumbers.evaluateMatchResult(lottoNumbers)
                result.lottiPrize shouldBe LottoPrize.MISS
            }
        }
    }
})
