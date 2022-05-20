package lotto.domain

import io.kotest.core.spec.style.FunSpec
import io.kotest.data.forAll
import io.kotest.data.row
import io.kotest.matchers.shouldBe
import lotto.domain.enums.LottoRank

class LottoMatchResultTest : FunSpec({

    test("로또 1장 매칭 테스트") {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 45)
        forAll(
            row(lotto(1, 2, 3, 4, 5, 6), 1, 0, 0, 0, 0, 0, 2000000.0),
            row(lotto(1, 2, 3, 4, 5, 16), 0, 0, 1, 0, 0, 0, 1500.0),
            row(lotto(1, 2, 3, 4, 15, 16), 0, 0, 0, 1, 0, 0, 50.0),
            row(lotto(1, 2, 3, 14, 15, 16), 0, 0, 0, 0, 1, 0, 5.0),
            row(lotto(1, 2, 13, 14, 15, 16), 0, 0, 0, 0, 0, 1, 0.0),
            row(lotto(1, 12, 13, 14, 15, 16), 0, 0, 0, 0, 0, 1, 0.0),
            row(lotto(11, 12, 13, 14, 15, 16), 0, 0, 0, 0, 0, 1, 0.0),
        ) {
            lotto: Lotto, first: Int, second: Int, third: Int, fourth: Int, fifth: Int, none: Int, rateOfReturn: Double ->
            val lottoMatchResult = LottoMatchResult.of(winningLotto, listOf(lotto))
            lottoMatchResult.matchingCountBy(LottoRank.FIRST) shouldBe first
            lottoMatchResult.matchingCountBy(LottoRank.SECOND) shouldBe second
            lottoMatchResult.matchingCountBy(LottoRank.THIRD) shouldBe third
            lottoMatchResult.matchingCountBy(LottoRank.FOURTH) shouldBe fourth
            lottoMatchResult.matchingCountBy(LottoRank.FIFTH) shouldBe fifth
            lottoMatchResult.matchingCountBy(LottoRank.NONE) shouldBe none
            lottoMatchResult.rateOfReturn shouldBe rateOfReturn
        }
    }

    test("로또 여러장 매칭 테스트") {
        val winningLotto = WinningLotto(listOf(1, 2, 3, 4, 5, 6), 45)
        forAll(
            row(
                listOf(
                    lotto(1, 2, 3, 4, 5, 6),
                    lotto(1, 2, 3, 4, 5, 6),
                    lotto(1, 2, 3, 4, 5, 6),
                    lotto(1, 2, 3, 4, 5, 6),
                    lotto(1, 2, 3, 4, 5, 6)
                ),
                5, 0, 0, 0, 0, 0, 2000000.0
            )
        ) {
            lottoList: List<Lotto>, first: Int, second: Int, third: Int, fourth: Int, fifth: Int, none: Int, rateOfReturn: Double ->
            val lottoMatchResult = LottoMatchResult.of(winningLotto, lottoList)
            lottoMatchResult.matchingCountBy(LottoRank.FIRST) shouldBe first
            lottoMatchResult.matchingCountBy(LottoRank.SECOND) shouldBe second
            lottoMatchResult.matchingCountBy(LottoRank.THIRD) shouldBe third
            lottoMatchResult.matchingCountBy(LottoRank.FOURTH) shouldBe fourth
            lottoMatchResult.matchingCountBy(LottoRank.FIFTH) shouldBe fifth
            lottoMatchResult.matchingCountBy(LottoRank.NONE) shouldBe none
            lottoMatchResult.rateOfReturn shouldBe rateOfReturn
        }
    }
})

fun lotto(vararg numbers: Int): Lotto {
    return Lotto(numbers.toList())
}
