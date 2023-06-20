package com.nextstep.second.lotto

import com.nextstep.second.lotto.service.LottoService
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import org.junit.jupiter.api.Test

class LottoServiceTest {
    @Test
    fun `주어진 금액만큼 로또를 구매해준다`() {
        // given
        val totalCnt = 15

        // when
        val lottos = LottoService.buyLottoInAuto(totalCnt)

        // then
        lottos.size shouldBe totalCnt
    }

    @Test
    fun `2개의 lotto 파라미터를 받아서 LottoResultVo를 반환해준다`() {
        // given
        val totalCnt = 15
        val lottos = LottoService.buyLottoInAuto(totalCnt)
        val winnerNumber = LottoService.getWinnerLotto(listOf(1, 2, 3, 4, 5, 6), 7)
        // when
        val result = LottoService.checkThisWeekLottoResult(winnerNumber, lottos)
        // then
        result shouldNotBe null
    }
}
