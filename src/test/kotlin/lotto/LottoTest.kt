package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lottoSeller: LottoSeller

    @BeforeEach
    fun setUp() {
        lottoSeller = LottoSeller()
    }

    @Test
    fun `1000원당 1장의 로또를 구매한다`() {
        assertThat(lottoSeller.purchaseLotto(1000)).isEqualTo(1)
    }
}
