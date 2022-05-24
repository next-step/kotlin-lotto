package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrow
import io.kotest.core.spec.style.DescribeSpec
import io.kotest.matchers.collections.shouldContainExactly
import lotto.domain.WinningPlace.BLANK
import lotto.domain.WinningPlace.FIRST
import lotto.domain.WinningPlace.FOURTH
import lotto.domain.WinningPlace.SECOND

class LottoBundleSpecs : DescribeSpec({

    describe("로또 뭉치는") {
        it("로또가 하나도 존재하지 않을 수 있다") {
            shouldNotThrow<IllegalArgumentException> {
                LottoBundle(emptyList())
            }
        }

        context("당첨 번호가 주어지면") {
            val winning = WinningLotto(lotto(1, 2, 3, 4, 5, 6), LottoNumber(7))
            it("가지고 있는 모든 로또의 당첨 등수를 알 수 있다") {
                val lottoBundle = LottoBundle(
                    listOf(
                        lotto(1, 2, 3, 4, 5, 6),
                        lotto(1, 2, 3, 4, 5, 7),
                        lotto(1, 2, 3, 4, 9, 10),
                        lotto(8, 9, 10, 14, 19, 20)
                    )
                )
                lottoBundle.matchWinning(winning) shouldContainExactly listOf(FIRST, SECOND, FOURTH, BLANK)
            }
        }
    }
})
