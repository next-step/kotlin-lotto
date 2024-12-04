package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.strategy.FifthRankLottoNumberGenerator
import lotto.strategy.FirstRankLottoLottoNumberGenerator
import lotto.strategy.FourRankLottoNumberGenerator
import lotto.strategy.ThirdRankLottoNumberGenerator
import lotto.strategy.WinningLottoNumberListGenerator

class MatchTest : DescribeSpec({
    lateinit var winningLotto: Lotto

    describe("사용자의 로또와 당첨로또의 숫자를 비교한다.") {
        beforeTest {
            val lottoNumbers = WinningLottoNumberListGenerator().generate()
            winningLotto = Lotto(lottoNumbers)
        }

        context("우승 로또와 사용자 로또를 비교해서 일치하는 개수를 리턴한다.") {
            it("6자리가 모두 일치하는 경우") {
                val userLottoNumbers = FirstRankLottoLottoNumberGenerator().generate()
                val sut = Lotto(userLottoNumbers)
                val actual = sut.getIntersectSize(winningLotto)
                actual shouldBe 6
            }

            it("5자리 일치") {
                val userLottoNumbers = ThirdRankLottoNumberGenerator().generate()
                val sut = Lotto(userLottoNumbers)
                val actual = sut.getIntersectSize(winningLotto)
                actual shouldBe 5
            }

            it("4자리 일치") {
                val userLottoNumbers = FourRankLottoNumberGenerator().generate()
                val sut = Lotto(userLottoNumbers)
                val actual = sut.getIntersectSize(winningLotto)

                actual shouldBe 4
            }

            it("3자리 일치") {
                val userLottoNumbers = FifthRankLottoNumberGenerator().generate()
                val sut = Lotto(userLottoNumbers)
                val actual = sut.getIntersectSize(winningLotto)
                actual shouldBe 3
            }
        }
    }
})
