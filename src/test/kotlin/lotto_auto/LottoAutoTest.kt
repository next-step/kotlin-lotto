package lotto_auto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto_auto.lotto.Lotto
import lotto_auto.lotto.LottoAuto
import lotto_auto.lotto.LottoPrize

class LottoAutoTest : StringSpec({
    "구매한 로또 총 당첨 금액이 맞는지" {
        // 로또 당첨 금액 (1) - 0원   (2) - 50000원
        val input = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(2, 4, 6, 8, 12, 15)))
        val winningLotto = Lotto(listOf(3, 6, 9, 12, 15, 18))
        val expected = 5000
        val matchedList = input.map { it.lottoMatchCount(winningLotto) }

        LottoAuto.sumOfWonLottoList(matchedList) shouldBe expected
    }

    "matchCountList 함수가 3,4,5,6개 맞은 순서를 잘 나타내는지" {
        val input = listOf(
            Lotto(listOf(1, 2, 3, 30, 31, 32)),
            Lotto(listOf(1, 2, 3, 4, 30, 31)),
            Lotto(listOf(1, 2, 3, 4, 5, 31)),
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        // 순서대로 3,4,5,6개 맞아서 리스트에 LottoPrize와 함께 1,1,1,1가 저장됨
        val expected = mapOf(
            LottoPrize.FOURTH_PRIZE to 1,
            LottoPrize.THIRD_PRIZE to 1,
            LottoPrize.SECOND_PRIZE to 1,
            LottoPrize.FIRST_PRIZE to 1
        )
        val matchedList =
            input.map { it.lottoMatchCount(winningLotto) }.filter { it > 2 }.map { LottoPrize.getLottoPrize(it) }

        LottoAuto.matchCountList(matchedList) shouldBe expected
    }

    "구매 금액 대비 당첨 금액의 비율이 맞는지" {
        val input = listOf(
            Lotto(listOf(1, 2, 3, 4, 5, 6)),
            Lotto(listOf(7, 8, 9, 10, 11, 12)),
            Lotto(listOf(13, 14, 15, 16, 17, 18)),
            Lotto(listOf(19, 20, 21, 22, 23, 24)),
            Lotto(listOf(25, 26, 27, 28, 29, 30))
        )
        // 5개 샀고, 1번 로또가 4개 당첨 되어 5 만원
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 31, 32))
        val inputAmount = 5000
        val matchedList = input.map { it.lottoMatchCount(winningLotto) }.filter { it > 2 }
        val resultSum = LottoAuto.sumOfWonLottoList(matchedList)

        val expected = resultSum.toFloat() / inputAmount.toFloat()

        LottoAuto.earningRate(resultSum, inputAmount) shouldBe expected
    }
})
