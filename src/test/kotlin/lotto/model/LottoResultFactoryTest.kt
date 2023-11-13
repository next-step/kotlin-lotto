package lotto.model

import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.Test


class LottoResultFactoryTest {
    @Test
    fun getLottoResult() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }
        val lottoTickets = listOf(LottoTicket(lottoNumbers))
        val lottoResult = LottoResultFactory.getLottoResult(lottoTickets, lottoNumbers, LottoNumber.from(7))
        lottoResult.results shouldBe mapOf(Prize.FIRST to 1)
    }
}
