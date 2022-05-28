package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setup() {
        lotto = Lotto()
    }

    @Test
    fun `1) 로또를 구매하는 경우에 6개의 번호가 생성된다`() {
        lotto.getLottoNumber()
        Assertions.assertThat(lotto.lottoNumber.size).isEqualTo(6)
    }
}
