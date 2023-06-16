package com.nextstep.second.lotto

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoVendingMachineTest {
    @Test
    fun `주어진 금액만큼 로또를 구매해준다`() {
        // given
        val money = 15_000
        val totalCnt = 15

        // when
        val lottos = LottoVendingMachine.buyLottoInRandom(money)

        // then
        lottos.size shouldBe totalCnt
    }

    @Test
    fun `2개의 lotto 파라미터를 받아서 LottoResultVo를 반환해준다`() {
        // given
        val money = 15_000
        val totalCnt = 15
        val lottos = LottoVendingMachine.buyLottoInRandom(money)
        val winnerNumber = LottoVendingMachine.getWinnerLotto(listOf(1, 2, 3, 4, 5, 6))
        // when
        val result = LottoVendingMachine.checkThisWeekLottoResult(winnerNumber, lottos)
        // then
        result.size shouldBe totalCnt
    }
}
