package lotto

import lotto.domain.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @Test
    fun `로또 번호를 생성한다`() {
        // given
        val lottoGenerator = LottoGenerator()

        // when
        val lotto = lottoGenerator.generate()

        // then
        assertThat(lotto).hasSize(6)
    }

}
