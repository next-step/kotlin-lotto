package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe
import lotto.strategy.FifthRankLottoNumberGenerator
import lotto.strategy.FirstRankLottoLottoNumberGenerator
import lotto.strategy.FourRankLottoNumberGenerator
import lotto.strategy.NoRankLottoNumberGenerator
import lotto.strategy.ThirdRankLottoNumberGenerator
import lotto.strategy.WinningLottoNumberListGenerator

class MatchTest : DescribeSpec({
    lateinit var winningLotto: Lotto

    describe("사용자의 로또와 당첨로또의 숫자를 비교한다.") {
        beforeTest {
            val lottoNumbers = WinningLottoNumberListGenerator().generate()
            winningLotto = Lotto.createLotto(lottoNumbers)
        }

        context("6자리가 모두 일치하는 경우") {
            it("should be 1") {
                val userLottoNumbers = FirstRankLottoLottoNumberGenerator().generate()
                val userLotto = Lotto.createLotto(userLottoNumbers)

                val actual = Match.lottoNumber(userLotto, winningLotto)

                actual shouldBe 1
            }
        }

        context("5자리가 일치하는 경우") {
            it("should be 2") {
                val userLottoNumbers = ThirdRankLottoNumberGenerator().generate()
                val userLotto = Lotto.createLotto(userLottoNumbers)

                val actual = Match.lottoNumber(userLotto, winningLotto)

                actual shouldBe 3
            }
        }

        context("4자리가 일치하는 경우") {
            it("should be 4") {
                val userLottoNumbers = FourRankLottoNumberGenerator().generate()
                val userLotto = Lotto.createLotto(userLottoNumbers)

                val actual = Match.lottoNumber(userLotto, winningLotto)

                actual shouldBe 4
            }
        }

        context("3자리가 일치하는 경우") {
            it("should be 5") {
                val userLottoNumbers = FifthRankLottoNumberGenerator().generate()
                val userLotto = Lotto.createLotto(userLottoNumbers)

                val actual = Match.lottoNumber(userLotto, winningLotto)

                actual shouldBe 5
            }
        }

        context("3자리 미만인 경우") {
            it("should be 0") {
                val userLottoNumbers = NoRankLottoNumberGenerator().generate()
                val userLotto = Lotto.createLotto(userLottoNumbers)

                val actual = Match.lottoNumber(userLotto, winningLotto)

                actual shouldBe 0
            }
        }
    }
})
