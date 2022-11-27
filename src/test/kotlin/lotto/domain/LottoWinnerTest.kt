package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe

class LottoWinnerTest : StringSpec({

    "당첨 로또 선택 테스트" {
        // given
        val luckyNumbers = listOf(1, 3, 5, 7, 9, 11)
        val lottoWinner = LottoWinner(luckyNumbers)

        val fourthWinLotto = Lotto(listOf(7, 9, 11, 12, 13, 14))
        val thirdWinLotto = Lotto(listOf(5, 7, 9, 11, 12, 13))
        val notWintLotto = Lotto(listOf(2, 4, 6, 8, 10, 12))
        // when
        val result = lottoWinner.findWinLottoList(listOf(fourthWinLotto, notWintLotto, thirdWinLotto))
        // then
        result.size shouldBe 2
        result shouldContainInOrder listOf(WinLottoPrize.FOURTH, WinLottoPrize.THIRD)
    }
})
