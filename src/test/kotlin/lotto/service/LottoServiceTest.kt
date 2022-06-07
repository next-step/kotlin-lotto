package lotto.service

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoServiceTest {

    lateinit var lottoService: LottoService

    @BeforeEach
    fun setUp() {
        lottoService = LottoService()
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 100])
    fun `Buy N Lotto Games`(n: Int) {
        val games = lottoService.buy(n)

        assertThat(games).hasSize(n)
        assertThat(games[0].numbers).hasSize(6)
    }
}
