package lotto

import lotto.domain.LottoGenerator
import lotto.domain.LottoSeller
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {
    @Test
    fun `로또 구매 갯수만큼 로또 번호를 생성한다`() {
        val lottoSeller = LottoSeller(5000)
        val lottoGenerator = LottoGenerator()
        assertThat(lottoGenerator.getLottos(lottoSeller.getLottoPurchaseCount()).all { it.isLotto() }).isEqualTo(true)
    }
}
