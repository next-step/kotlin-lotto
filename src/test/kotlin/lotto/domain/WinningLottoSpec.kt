package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.extension.lotto
import lotto.domain.extension.lottoNumbers

class WinningLottoSpec : DescribeSpec({
    describe("로또 결과 계산") {
        val winningLotto = WinningLotto(lottoNumbers(1, 2, 3, 4, 5, 6), LottoNumber(7))

        context("로또 번호와 당첨 번호가 6개 일치하면") {
            val lotto = lotto(1, 2, 3, 4, 5, 6)

            it("1등이다.") {
                val lottoPrize = lotto.calculateResult(winningLotto)

                lottoPrize shouldBe LottoRank.FIRST
            }
        }

        context("로또 번호와 당첨 번호가 5개 일치하고 보너스 번호가 일치하면") {
            val lotto = lotto(1, 2, 3, 4, 5, 7)

            it("2등이다.") {
                val lottoPrize = lotto.calculateResult(winningLotto)

                lottoPrize shouldBe LottoRank.SECOND
            }
        }

        context("로또 번호와 당첨 번호가 5개 일치하고 보너스 번호가 불일치하면") {
            val lotto = lotto(1, 2, 3, 4, 5, 8)

            it("3등이다.") {
                val lottoPrize = lotto.calculateResult(winningLotto)

                lottoPrize shouldBe LottoRank.THIRD
            }
        }

        context("로또 번호와 당첨 번호가 4개 일치하면") {
            val lotto = lotto(1, 2, 3, 4, 7, 8)

            it("4등이다.") {
                val lottoPrize = lotto.calculateResult(winningLotto)

                lottoPrize shouldBe LottoRank.FOURTH
            }
        }

        context("로또 번호와 당첨 번호가 3개 일치하면") {
            val lotto = lotto(1, 2, 3, 7, 8, 9)

            it("5등이다.") {
                val lottoPrize = lotto.calculateResult(winningLotto)

                lottoPrize shouldBe LottoRank.FIFTH
            }
        }
    }
})
