package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({
    "당첨 번호와 보너스볼이 중복되면 예외를 발생시킨다" {
        // given
        // val winningLotto = Lotto()

        // when

        // then
    }

    "당첨 로또와 로또를 비교하여 결과를 얻는다" {
        listOf(
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 6), Rank.FIRST),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 5, 7), Rank.SECOND),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 4, 7, 8), Rank.THIRD),
            row(listOf(1, 2, 3, 4, 5, 6), listOf(1, 2, 3, 7, 8, 9), Rank.FOURTH),
        ).forAll { (winningLottoNumbers, targetLottoNumbers, expected) ->
            // given
            val winningLotto = WinningLotto(
                Lotto(
                    winningLottoNumbers.map { LottoNumber.valueOf(it) }
                )
            )
            val targetLotto = Lotto(targetLottoNumbers.map { LottoNumber.valueOf(it) })

            // when
            val actual = winningLotto.match(targetLotto)

            // then
            actual shouldBe expected
        }
    }
})
