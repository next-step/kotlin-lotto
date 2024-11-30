package lotto.step4

import io.kotest.core.spec.style.FunSpec
import io.kotest.matchers.shouldBe
import lotto.step4.domain.LottoNumber
import lotto.step4.domain.Rank
import lotto.step4.domain.RankClassifier

class RankClassifierTest : FunSpec({
    test("RankClassifier가 로또를 올바르게 분류한다.") {
        // given
        val givenLottoList =
            listOf(
                LottoStub.get(numbers = listOf(1, 2, 3, 4, 5, 6)),
                LottoStub.get(numbers = listOf(1, 2, 3, 4, 5, 7)),
                LottoStub.get(numbers = listOf(1, 2, 3, 4, 5, 16)),
                LottoStub.get(numbers = listOf(1, 2, 3, 4, 15, 16)),
                LottoStub.get(numbers = listOf(1, 2, 3, 14, 15, 16)),
                LottoStub.get(numbers = listOf(1, 2, 13, 14, 15, 16)),
                LottoStub.get(numbers = listOf(1, 12, 13, 14, 15, 16)),
                LottoStub.get(numbers = listOf(11, 12, 13, 14, 15, 16)),
                LottoStub.get(numbers = listOf(21, 22, 23, 24, 25, 26)),
                LottoStub.get(numbers = listOf(7, 22, 23, 24, 25, 26)),
            )
        val givenWinningNumbers = setOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))
        val givenBonusNumber = LottoNumber(7)
        // when
        val result = RankClassifier.classify(givenLottoList, givenWinningNumbers, givenBonusNumber)

        // then
        result shouldBe
            mapOf(
                Rank.FIRST to 1,
                Rank.SECOND to 1,
                Rank.THIRD to 1,
                Rank.FOURTH to 1,
                Rank.FIFTH to 1,
                Rank.MISS to 5,
            )
    }
})
