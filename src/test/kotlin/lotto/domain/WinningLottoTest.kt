package lotto.domain

import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.data.row
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class WinningLottoTest : StringSpec({
    "당첨 번호와 보너스볼이 중복되면 예외를 발생시킨다" {
        // given
        val winningLotto = Lotto.of(1, 2, 3, 4, 5, 6)
        val bonusBall = LottoNumber.valueOf(6)

        // when // then
        shouldThrowExactly<IllegalArgumentException> { WinningLotto(winningLotto, bonusBall) }
    }

    "당첨 로또와 로또를 비교하여 결과를 얻는다" {
        listOf(
            row(listOf(1, 2, 3, 4, 5, 6), LottoNumber.valueOf(7), listOf(1, 2, 3, 4, 5, 6), Rank.FIRST),
            row(listOf(1, 2, 3, 4, 5, 6), LottoNumber.valueOf(7), listOf(1, 2, 3, 4, 5, 7), Rank.SECOND),
            row(listOf(1, 2, 3, 4, 5, 6), LottoNumber.valueOf(7), listOf(1, 2, 3, 4, 5, 8), Rank.THIRD),
            row(listOf(1, 2, 3, 4, 5, 6), LottoNumber.valueOf(7), listOf(1, 2, 3, 4, 8, 9), Rank.FOURTH),
            row(listOf(1, 2, 3, 4, 5, 6), LottoNumber.valueOf(7), listOf(1, 2, 3, 8, 9, 10), Rank.FIFTH),
        ).forAll { (winningLottoNumbers, bonusBall, targetLottoNumbers, expected) ->
            // given
            val winningLotto = WinningLotto(
                Lotto(
                    winningLottoNumbers.map { LottoNumber.valueOf(it) }.toSet()
                ),
                bonusBall,
            )
            val targetLotto = Lotto(targetLottoNumbers.map { LottoNumber.valueOf(it) }.toSet())

            // when
            val actual = winningLotto.match(targetLotto)

            // then
            actual shouldBe expected
        }
    }
})
