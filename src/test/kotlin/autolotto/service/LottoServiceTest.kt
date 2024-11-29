package autolotto.service

import autolotto.entity.Lotto
import autolotto.repository.LottoRepository
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test

class LottoServiceTest {
    val lottoRepository: LottoRepository = LottoRepository()
    val service: LottoService = LottoService(lottoRepository)

    @Test
    fun `lotto 값 생성 시 중복되는 숫자가 없어야한다`() {
        service.start(1)
        val lotto = lottoRepository.findAll().first()
        lotto.lottoGame.size shouldBe 6
    }

    @Test
    fun `당첨번호에 따른 당첨등수 산정 테스트`() {
        val lottos =
            listOf(
                Lotto(setOf(1, 2, 3, 4, 5, 6)),
                Lotto(setOf(1, 2, 3, 7, 8, 9)),
                Lotto(setOf(1, 2, 17, 14, 15, 16)),
            )
        lottos.forEach { lotto -> lottoRepository.save(lotto) }

        val result = service.getResult(listOf(7, 8, 9, 17, 14, 15, 16))

        result.get(3) shouldBe 1
        result.get(4) shouldBe 1
    }
}
