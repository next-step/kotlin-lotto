package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class MatchTest : DescribeSpec({
    lateinit var lottoNumbers: Set<LottoNumber>
    lateinit var winningLotto: Lotto

    describe("사용자의 로또와 당첨로또의 숫자를 비교한다.") {
        beforeTest {
            lottoNumbers =
                setOf(
                    LottoNumber.from(1),
                    LottoNumber.from(2),
                    LottoNumber.from(3),
                    LottoNumber.from(4),
                    LottoNumber.from(5),
                    LottoNumber.from(6),
                )

            winningLotto = Lotto(lottoNumbers)
        }

        context("6자리가 모두 일치하는 경우") {
            it("should be 1") {
                val userLotto = winningLotto.copy()
                val sut = Match.lottoNumber(userLotto, winningLotto)
                sut shouldBe 1
            }
        }

        context("5자리가 일치하는 경우") {
            it("should be 2") {
                val userLotto = winningLotto.copy()
                val sut = Match.lottoNumber(userLotto, winningLotto)
                sut shouldBe 2
            }
        }

        context("4자리가 일치하는 경우") {
            it("should be 3") {
                val userLotto = winningLotto.copy()
                val sut = Match.lottoNumber(userLotto, winningLotto)
                sut shouldBe 3
            }
        }

        context("5자리가 일치하는 경우") {
            it("should be 4") {
                val userLotto = winningLotto.copy()
                val sut = Match.lottoNumber(userLotto, winningLotto)
                sut shouldBe 4
            }
        }
    }
})
