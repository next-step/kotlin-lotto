package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe

class LottoWinnerTest : StringSpec({

    "당첨 로또 선택 테스트" {
        // given
        val luckyNumbers = listOf(1, 3, 5, 7, 9, 11)
        val bonusNumber = 13
        val lottoWinner = LottoWinner(LuckyNumbers(luckyNumbers, bonusNumber))

        val fourthWinLotto = Lotto(listOf(7, 9, 11, 12, 13, 14))
        val secondWinLotto = Lotto(listOf(3, 5, 7, 9, 11, 13))
        val thirdWinLotto = Lotto(listOf(5, 7, 9, 11, 12, 13))
        val notWintLotto = Lotto(listOf(2, 4, 6, 8, 10, 12))
        // when
        val result = lottoWinner.findWinLottoList(listOf(fourthWinLotto, notWintLotto, secondWinLotto, thirdWinLotto))
        // then
        result.size shouldBe 3
        result shouldContainInOrder listOf(LottoRank.FOURTH, LottoRank.SECOND, LottoRank.THIRD)
    }
})
