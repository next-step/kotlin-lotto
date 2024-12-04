package lotto.domain

import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class WinningLottoTest : DescribeSpec({
    describe("로또의 등수를 계산한다") {
        lateinit var sut: WinningLotto

        beforeTest {
            val winningLotto = Lotto(1, 2, 3, 4, 5, 6)
            val bonusBall = LottoNumber(10)
            sut = WinningLotto(winningLotto, bonusBall)
        }

        describe("사용자 로또 등수를 리턴한다.") {
            it("모두 일치하는 경우") {
                val userLotto = Lotto(1, 2, 3, 4, 5, 6)
                val actual = sut.getUserRank(userLotto)
                actual shouldBe LottoRank.FIRST
            }

            context("5개 일치 + 보너스볼") {
                it("should be 2") {
                    val userLotto = Lotto(1, 2, 3, 4, 5, 10)
                    val actual = sut.getUserRank(userLotto)
                    actual shouldBe LottoRank.SECOND
                }
            }

            context("5개 일치") {
                it("should be 3") {
                    val userLotto = Lotto(1, 2, 3, 4, 5, 11)
                    val actual = sut.getUserRank(userLotto)
                    actual shouldBe LottoRank.THIRD
                }
            }

            context("4개 일치 + 보너스볼") {
                it("should be 4") {
                    val userLotto = Lotto(1, 2, 3, 4, 10, 11)
                    val actual = sut.getUserRank(userLotto)
                    actual shouldBe LottoRank.FOURTH
                }
            }

            context("4개 일치") {
                it("should be 4") {
                    val userLotto = Lotto(1, 2, 3, 4, 11, 12)
                    val actual = sut.getUserRank(userLotto)
                    actual shouldBe LottoRank.FOURTH
                }
            }

            context("3개 일치") {
                it("should be 5") {
                    val userLotto = Lotto(1, 2, 3, 11, 12, 13)
                    val actual = sut.getUserRank(userLotto)
                    actual shouldBe LottoRank.FIFTH
                }
            }
        }
    }
})
