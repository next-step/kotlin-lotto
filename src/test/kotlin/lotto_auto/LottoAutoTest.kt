package lotto_auto

import io.kotest.core.spec.style.StringSpec
import io.kotest.matchers.shouldBe
import lotto_auto.lotto.Lotto
import lotto_auto.lotto.LottoAuto

class LottoAutoTest : StringSpec({
    "입력된 개수 만큼 로또 용지가 생성 된다." {
        val input = 4
        val expected = 4

        LottoAuto.createLottoList(input).size shouldBe expected
    }

    "구매한 로또 총 당첨 금액이 맞는지" {
        // 로또 당첨 금액 (1) - 0원   (2) - 50000원
        val input = listOf(Lotto(listOf(1, 2, 3, 4, 5, 6)), Lotto(listOf(2, 4, 6, 8, 12, 15)))
        val winningLotto = Lotto(listOf(3, 6, 9, 12, 15, 18))
        val expected = 5000

        LottoAuto.sumOfWonLottoList(input, winningLotto) shouldBe expected
    }

    "matchCountList 함수가 3,4,5,6개 맞은 순서를 잘 나타내는지" {
        val input = listOf(
            Lotto(listOf(1, 2, 3, 30, 31, 32)),
            Lotto(listOf(1, 2, 3, 4, 30, 31)),
            Lotto(listOf(1, 2, 3, 4, 5, 31)),
            Lotto(listOf(1, 2, 3, 4, 5, 6))
        )
        val winningLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        // 순서대로 3,4,5,6개 맞아서 리스트에 1,1,1,1가 저장됨
        val expected = listOf(1, 1, 1, 1)
        LottoAuto.matchCountList(input, winningLotto) shouldBe expected
    }

    "구매 금액 대비 당첨 금액의 비율이 맞는지" {
        val resultSum = 5000
        val inputAmount = 14000
        val expected = 5000.toFloat() / 14000.toFloat()
        LottoAuto.earningRate(resultSum, inputAmount) shouldBe expected
    }
})
