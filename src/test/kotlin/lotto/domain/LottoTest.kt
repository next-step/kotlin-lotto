package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.shouldBe

class LottoTest : DescribeSpec({
    describe("로또를 생성한다") {
        context("6자리가 아닌경우 exception throw") {
            it("LottoNumber가 5자리인 경우") {
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        Lotto(1, 2, 3, 4, 5)
                    }
                exception.message shouldBe "정확히 6개의 숫자를 입력해야 합니다."
            }

            it("LottoNumber가 7자리인 경우") {
                val exception =
                    shouldThrow<IllegalArgumentException> {
                        Lotto(1, 2, 3, 4, 5, 6, 7)
                    }
                exception.message shouldBe "정확히 6개의 숫자를 입력해야 합니다."
            }
        }

        context("6자리인 경우") {
            it("로또를 생성한다.") {
                shouldNotThrow<IllegalArgumentException> {
                    Lotto(1, 2, 3, 4, 5, 6)
                }
            }
        }

        context("중복이 있는 경우") {
            it("exception throw") {
                shouldThrow<IllegalArgumentException> { Lotto(1, 1, 1, 1, 1, 1) }
            }
        }
    }

    describe("사용자의 로또 번호와 당첨번호 일치 개수를 계산한다.") {
        lateinit var winningLotto: Lotto
        beforeTest { winningLotto = Lotto(1, 2, 3, 4, 5, 6) }

        it("6개 일치") {
            val lotto = Lotto(1, 2, 3, 4, 5, 6)
            val actual = lotto.getIntersectSize(winningLotto)
            actual shouldBe 6
        }

        it("5개 일치") {
            val lotto = Lotto(1, 2, 3, 4, 5, 7)
            val actual = lotto.getIntersectSize(winningLotto)
            actual shouldBe 5
        }

        it("4개 일치") {
            val lotto = Lotto(1, 2, 3, 4, 7, 8)
            val actual = lotto.getIntersectSize(winningLotto)
            actual shouldBe 4
        }

        it("3개 일치") {
            val lotto = Lotto(1, 2, 3, 11, 12, 13)
            val actual = lotto.getIntersectSize(winningLotto)
            actual shouldBe 3
        }

        it("2개 일치") {
            val lotto = Lotto(1, 2, 11, 12, 13, 14)
            val actual = lotto.getIntersectSize(winningLotto)
            actual shouldBe 2
        }
    }

    describe("보너스볼 일치 여부") {
        context("사용자의 로또번호에 보너스볼이 포함되어 있는 경우") {
            it("should be true") {
                val lotto = Lotto(1, 2, 3, 4, 5, 6)
                val actual = lotto.isMatchedBonusBall(LottoNumber(1))
                actual shouldBe true
            }
        }

        context("사용자의 로또번호에 보너스볼이 포함되어 있지 않은 경우") {
            it("should be false") {
                val lotto = Lotto(1, 2, 3, 4, 5, 6)
                val actual = lotto.isMatchedBonusBall(LottoNumber(10))
                actual shouldBe false
            }
        }
    }
})
