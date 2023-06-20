package lotto.domain.shop

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.analysis.LottoWinRank
import lotto.domain.lottonumber.LottoNumber
import lotto.domain.lottonumber.LottoNumbers
import lotto.domain.lottonumber.WinLottoNumbers

class LottoGameTest : BehaviorSpec({

    fun lottoNumbers(vararg numbers: Int): LottoNumbers {
        return LottoNumbers(numbers.map { LottoNumber(it) })
    }

    fun autoLottoGame(lottoNumbers: LottoNumbers): LottoGame {
        return LottoGame(LottoGameType.AUTO, lottoNumbers)
    }

    Given("로또 번호가") {
        val winLottoNumbers = WinLottoNumbers(
            lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 6),
            bonusNumber = LottoNumber(40),
        )
        When("6개 일치하면") {
            val lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 6)
            Then("1등이다") {
                autoLottoGame(lottoNumbers).matchOrNull(winLottoNumbers) shouldBe LottoWinRank.FIRST
            }
        }
        When("5개 일치하면서 보너스 번호도 일치하면") {
            val lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 40)
            Then("2등이다") {
                autoLottoGame(lottoNumbers).matchOrNull(winLottoNumbers) shouldBe LottoWinRank.SECOND
            }
        }
        When("5개 일치하면서 보너스 번호는 일치하지 않으면") {
            val lottoNumbers = lottoNumbers(1, 2, 3, 4, 5, 7)
            Then("3등이다") {
                autoLottoGame(lottoNumbers).matchOrNull(winLottoNumbers) shouldBe LottoWinRank.THIRD
            }
        }
        When("4개 일치하면") {
            val lottoNumbers = lottoNumbers(1, 2, 3, 4, 7, 8)
            Then("4등이다") {
                autoLottoGame(lottoNumbers).matchOrNull(winLottoNumbers) shouldBe LottoWinRank.FOURTH
            }
        }
        When("3개 일치하면") {
            val lottoNumbers = lottoNumbers(1, 2, 3, 7, 8, 9)
            Then("5등이다") {
                autoLottoGame(lottoNumbers).matchOrNull(winLottoNumbers) shouldBe LottoWinRank.FIFTH
            }
        }
        When("2개 이하가 일치하면") {
            forAll(
                row(lottoNumbers(1, 2, 7, 8, 9, 10)),
                row(lottoNumbers(1, 7, 8, 9, 10, 11)),
                row(lottoNumbers(7, 8, 9, 10, 11, 12)),
            ) { lottoNumbers ->
                Then("당첨이 아니다") {
                    autoLottoGame(lottoNumbers).matchOrNull(winLottoNumbers) shouldBe null
                }
            }
        }
    }
})
