package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.domain.extension.lotto
import lotto.domain.extension.lottoNumbers

class LottoSpec : DescribeSpec({
    describe("로또 생성 검증") {
        context("로또를 생성하면") {
            val lotto = Lotto()

            it("로또는 6개의 번호를 갖고있다.") {
                lotto.numbers.values.size shouldBe 6
            }
        }
    }

    describe("로또 가격 검증") {
        it("로또의 가격은 1000원이다.") {
            Lotto.PRICE shouldBe 1000
        }
    }

    describe("로또 결과 계산") {
        val winningNumbers = lottoNumbers(1, 2, 3, 4, 5, 6)
        val bonusNumber = LottoNumber(7)

        context("로또 번호와 당첨 번호가 6개 일치하면") {
            val lotto = lotto(1, 2, 3, 4, 5, 6)

            it("1등이다.") {
                val lottoPrize = lotto.calculateResult(winningNumbers, bonusNumber)

                lottoPrize shouldBe LottoRank.FIRST
            }
        }

        context("로또 번호와 당첨 번호가 5개 일치하고 보너스 번호가 일치하면") {
            val lotto = lotto(1, 2, 3, 4, 5, 7)

            it("2등이다.") {
                val lottoPrize = lotto.calculateResult(winningNumbers, bonusNumber)

                lottoPrize shouldBe LottoRank.SECOND
            }
        }

        context("로또 번호와 당첨 번호가 5개 일치하고 보너스 번호가 불일치하면") {
            val lotto = lotto(1, 2, 3, 4, 5, 8)

            it("3등이다.") {
                val lottoPrize = lotto.calculateResult(winningNumbers, bonusNumber)

                lottoPrize shouldBe LottoRank.THIRD
            }
        }

        context("로또 번호와 당첨 번호가 4개 일치하면") {
            val lotto = lotto(1, 2, 3, 4, 7, 8)

            it("4등이다.") {
                val lottoPrize = lotto.calculateResult(winningNumbers, bonusNumber)

                lottoPrize shouldBe LottoRank.FOURTH
            }
        }

        context("로또 번호와 당첨 번호가 3개 일치하면") {
            val lotto = lotto(1, 2, 3, 7, 8, 9)

            it("5등이다.") {
                val lottoPrize = lotto.calculateResult(winningNumbers, bonusNumber)

                lottoPrize shouldBe LottoRank.FIFTH
            }
        }
    }
})
