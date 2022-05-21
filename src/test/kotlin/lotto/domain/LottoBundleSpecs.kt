package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import lotto.domain.WinningPlace.BLANK
import lotto.domain.WinningPlace.FIRST
import lotto.domain.WinningPlace.SECOND
import lotto.domain.WinningPlace.THIRD

class LottoBundleSpecs : DescribeSpec({

    describe("로또 뭉치는") {
        it("주어진 로또의 개수가 0개라면 예외를 발생시킨다") {
            shouldThrowExactly<IllegalArgumentException> {
                LottoBundle(emptyList())
            }
        }

        context("당첨 로또가 주어지면") {
            val winning = Lotto.of(listOf(1, 2, 3, 4, 5, 6))
            it("가지고 있는 모든 로또의 당첨 등수를 알 수 있다") {
                val lottoBundle = LottoBundle(
                    listOf(
                        Lotto.of(listOf(1, 2, 3, 4, 5, 6)),
                        Lotto.of(listOf(1, 2, 3, 4, 5, 7)),
                        Lotto.of(listOf(1, 2, 3, 4, 9, 10)),
                        Lotto.of(listOf(8, 9, 10, 14, 19, 20)),
                    )
                )
                lottoBundle.matchWinning(winning) shouldContainExactly listOf(FIRST, SECOND, THIRD, BLANK)
            }
        }
    }
})
