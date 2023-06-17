package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {

    private lateinit var lotto: Lotto

    @BeforeEach
    fun setup() {
        val lottoGenerator = LottoGenerator()
        val numbers = lottoGenerator.getLottoNumbers()
        lotto = Lotto(numbers)
    }

    @Test
    fun `1 ~ 45 까지의 로또 번호에서 랜덤한 숫자의 로또를 생성할 수 있다`() {
        val actual = LottoGenerator().getLottoNumbers()
        assertThat(actual.size).isEqualTo(6)
    }
}
