package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoesRankTest {

    private lateinit var lottoesRank: LottoesRank
    private var spentMoney: Long = 1000

    @BeforeEach
    fun init() {
        lottoesRank = LottoesRank(mapOf(Rank.FIRST to 1))
    }

    @Test
    fun `1등일 때 수익률 확인`() {
        assertThat(lottoesRank.calcualteRateOfReutrn(spentMoney)).isEqualTo("2000000.00")
    }
}
