package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.shouldBe

internal class LottoNumbersTest : BehaviorSpec({
    given("생성한 로또 번호가") {
        `when`("6개의 숫자가 아니라면") {
            val lottoNumbers = lottoNumberListOf(1, 2, 3, 4, 5, 6, 7)

            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(lottoNumbers)
                }
            }
        }

        `when`("중복이 있다면") {
            val duplicatedNumbers = lottoNumberListOf(1, 2, 3, 3, 3, 3)

            then("IllegalArgumentException 이 발생한다.") {
                shouldThrow<IllegalArgumentException> {
                    LottoNumbers(duplicatedNumbers)
                }
            }
        }
    }

    given("당첨 번호와 구입한 로또의 일치하는 수의 개수를 구할 때") {
        val winningLottoNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)

        `when`("3개가 일치한다면") {
            val purchasedLottoNumbers = lottoNumberOf(1, 2, 3, 33, 34, 35)

            then("일치하는 수 3을 반환한다.") {
                val result = winningLottoNumbers.getNumberOfMatch(purchasedLottoNumbers)
                result shouldBe 3
            }
        }
    }

    given("로또 번호들과 당첨 번호를 비교할 때") {
        val lottoNumbers = lottoNumberOf(1, 2, 3, 4, 5, 6)

        `when`("보너스 볼의 숫자와 일치한다면") {
            val bonusBall = LottoNumber(1)
            val result = lottoNumbers.isMatchBonusLottoNumber(bonusBall)

            then("true 를 반환한다.") {
                result shouldBe true
            }
        }
    }
})
