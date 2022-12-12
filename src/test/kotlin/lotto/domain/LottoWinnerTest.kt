package lotto.domain

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.collections.shouldContainInOrder
import io.kotest.matchers.shouldBe
import lotto.application.common.Number
import lotto.domain.Lotto
import lotto.domain.LottoRank
import lotto.domain.LottoWinner
import lotto.domain.LuckyNumbers

class LottoWinnerTest : StringSpec({

    "당첨 로또 선택 테스트" {
        // given
        val luckyNumbers = listOf(
            Number(1),
            Number(3),
            Number(5),
            Number(7),
            Number(9),
            Number(11)
        )
        val bonusNumber = Number(13)
        val lottoWinner = LottoWinner(LuckyNumbers(luckyNumbers, bonusNumber))

        val fourthWinLotto = Lotto(listOf(
            LottoNumber(Number(5)),
            LottoNumber(Number(7)),
            LottoNumber(Number(9)),
            LottoNumber(Number(11)),
            LottoNumber(Number(12)),
            LottoNumber(Number(13))
        ))
        val secondWinLotto = Lotto(listOf(
            LottoNumber(Number(3)),
            LottoNumber(Number(5)),
            LottoNumber(Number(7)),
            LottoNumber(Number(9)),
            LottoNumber(Number(11)),
            LottoNumber(Number(13))
        ))
        val thirdWinLotto = Lotto(listOf(
            LottoNumber(Number(3)),
            LottoNumber(Number(5)),
            LottoNumber(Number(7)),
            LottoNumber(Number(9)),
            LottoNumber(Number(11)),
            LottoNumber(Number(15))
        ))
        val notWintLotto = Lotto(listOf(
            LottoNumber(Number(2)),
            LottoNumber(Number(4)),
            LottoNumber(Number(6)),
            LottoNumber(Number(8)),
            LottoNumber(Number(10)),
            LottoNumber(Number(13))
        ))
        // when
        val result = lottoWinner.findWinLottoList(listOf(fourthWinLotto, notWintLotto, secondWinLotto, thirdWinLotto))
        // then
        result.size shouldBe 3
        result shouldContainInOrder listOf(LottoRank.FOURTH, LottoRank.SECOND, LottoRank.THIRD)
    }
})
