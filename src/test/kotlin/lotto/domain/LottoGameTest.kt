package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

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

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 100])
    fun `Buy N Lotto Games`(n: Int) {
        val games = lottoGame.buy(n)

        assertThat(games).hasSize(n)
        assertThat(games[0].numbers).hasSize(6)
    }
}
