package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe

class WinningLottoSpec : FunSpec({

    context("당첨 로또 생성") {
        test("당첨 티켓과 보너스 볼로 당첨 로또가 생성된다") {
            WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 45)
        }
        test("당첨 번호에 보너스 볼이 포함되어 있으면 에러가 발생한다") {
            shouldThrow<IllegalArgumentException> {
                WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), 6)
            }
        }
        test("보너스볼이 1부터 45사이의 숫자가 아니라면 에러가 발생한다") {
            forAll(
                row(0),
                row(46),
            ) { bonusNumber ->
                shouldThrow<IllegalArgumentException> {
                    WinningLotto(LottoNumber(listOf(1, 2, 3, 4, 5, 6)), bonusNumber)
                }
            }
        }
    }

    context("Rank 계산") {
        test("당첨번호와 맞은 개수에 따라 Rank를 계산한") {
            val winningLotto = WinningLotto(
                winningNumber = LottoNumber(listOf(1, 2, 3, 4, 5, 6)),
                bonusNumber = 7,
            )

            forAll(
                row(mutableListOf(1, 2, 3, 4, 5, 6), LottoRank.FIRST),
                row(mutableListOf(1, 2, 3, 4, 5, 7), LottoRank.SECOND),
                row(mutableListOf(1, 2, 3, 4, 5, 45), LottoRank.THIRD),
                row(mutableListOf(1, 2, 3, 4, 44, 45), LottoRank.FOURTH),
                row(mutableListOf(1, 2, 3, 43, 44, 45), LottoRank.FIFTH),
                row(mutableListOf(1, 2, 42, 43, 44, 45), LottoRank.MISS),
                row(mutableListOf(1, 41, 42, 43, 44, 45), LottoRank.MISS),
                row(mutableListOf(40, 41, 42, 43, 44, 45), LottoRank.MISS),
            ) { numbers, expect ->

                val result =  winningLotto.rank(LottoNumber(numbers))

                result shouldBe expect
            }
        }
    }
})
