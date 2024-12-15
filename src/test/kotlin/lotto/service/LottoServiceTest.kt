package lotto.service

import io.kotest.matchers.shouldBe
import lotto.domain.Amount
import lotto.domain.LottoNumber
import lotto.domain.WinningLottoNumber
import lotto.enums.prize.Prize
import lotto.repository.LottoRepository
import org.junit.jupiter.api.Test

class LottoServiceTest {
    val lottoRepository: LottoRepository = LottoRepository()
    val service: LottoService = LottoService(lottoRepository)

    @Test
    fun `lotto 값 생성 시 중복되는 숫자가 없어야한다`() {
        val amount = Amount(5000)
        amount.setManualCount(5)
        service.start(
            amount,
            listOf(
                LottoNumber(setOf(15, 14, 17, 9, 3, 6)),
                LottoNumber(setOf(1, 2, 3, 7, 8, 9)),
                LottoNumber(setOf(1, 2, 17, 14, 15, 16)),
                LottoNumber(setOf(7, 8, 17, 9, 15, 30)),
            )
        )
        val lotto = lottoRepository.findAll()
        val totalLottoInfo = lotto.getTotalLottoInfos()
        totalLottoInfo.forEach { it.getNumbers().size shouldBe 6 }
    }

    @Test
    fun `당첨번호에 따른 당첨등수 보너스 포함 산정 테스트`() {
        val amount = Amount(5000)
        amount.setManualCount(5)
        service.start(
            amount,
            listOf(
                LottoNumber(setOf(15, 14, 17, 9, 3, 6)),
                LottoNumber(setOf(1, 2, 3, 7, 8, 9)),
                LottoNumber(setOf(1, 2, 17, 14, 15, 16)),
                LottoNumber(setOf(7, 8, 17, 9, 15, 30)),
            )
        )
        val winningLottoNumber = WinningLottoNumber(LottoNumber(setOf(7, 8, 9, 17, 14, 15)), 30)
        val result = service.getResult(winningLottoNumber)

        result.get(Prize.THREE) shouldBe 2
        result.get(Prize.FOUR) shouldBe 1
        result.get(Prize.BONUS) shouldBe 1
    }
}
