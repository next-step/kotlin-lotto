package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import lotto.common.IntegerNumber

class LottoWinnerTest : StringSpec({

    "당첨 로또 선택 테스트" {
        // given
        val luckyNumbers = listOf(
            IntegerNumber(1),
            IntegerNumber(3),
            IntegerNumber(5),
            IntegerNumber(7),
            IntegerNumber(9),
            IntegerNumber(11)
        )
        val bonusNumber = IntegerNumber(13)
        val lottoWinner = LottoWinner(LuckyNumbers(luckyNumbers, bonusNumber))

        val fourthWinLotto = Lotto(
            listOf(
                LottoNumber(IntegerNumber(5)),
                LottoNumber(IntegerNumber(7)),
                LottoNumber(IntegerNumber(9)),
                LottoNumber(IntegerNumber(11)),
                LottoNumber(IntegerNumber(12)),
                LottoNumber(IntegerNumber(13))
            )
        )
        val secondWinLotto = Lotto(
            listOf(
                LottoNumber(IntegerNumber(3)),
                LottoNumber(IntegerNumber(5)),
                LottoNumber(IntegerNumber(7)),
                LottoNumber(IntegerNumber(9)),
                LottoNumber(IntegerNumber(11)),
                LottoNumber(IntegerNumber(13))
            )
        )
        val thirdWinLotto = Lotto(
            listOf(
                LottoNumber(IntegerNumber(3)),
                LottoNumber(IntegerNumber(5)),
                LottoNumber(IntegerNumber(7)),
                LottoNumber(IntegerNumber(9)),
                LottoNumber(IntegerNumber(11)),
                LottoNumber(IntegerNumber(15))
            )
        )
        val notWintLotto = Lotto(
            listOf(
                LottoNumber(IntegerNumber(2)),
                LottoNumber(IntegerNumber(4)),
                LottoNumber(IntegerNumber(6)),
                LottoNumber(IntegerNumber(8)),
                LottoNumber(IntegerNumber(10)),
                LottoNumber(IntegerNumber(13))
            )
        )
        // when
        val result = lottoWinner.findWinLottoList(listOf(fourthWinLotto, notWintLotto, secondWinLotto, thirdWinLotto))
        // then
        result.size shouldBe 3
        result shouldContainInOrder listOf(LottoRank.FOURTH, LottoRank.SECOND, LottoRank.THIRD)
    }
})
