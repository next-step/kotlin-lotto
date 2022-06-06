package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

internal class LottoGameTest {

    private lateinit var lottoGame: LottoGame

    @BeforeEach
    fun setUp() {
        val lottoNumbers = (1..45).map { LottoNumber.of(it) }
        lottoGame = LottoGame(lottoNumbers)
    }

    @Test
    fun `LottoGame has Lotto Number`() {
        assertThat(lottoGame.lottoNumbers).hasSize(45)
    }

    @Test
    fun `Buy 1 Lotto Game`() {
        val game = lottoGame.buy()

        assertThat(game).hasSize(6)
    }
}
