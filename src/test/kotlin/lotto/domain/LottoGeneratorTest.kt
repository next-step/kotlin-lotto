package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LottoGeneratorTest {

    @Test
    fun `로또 번호 6개가 들어 있는 로또를 생성한다`() {
        val lotto = LottoGenerator.generateLotto()
        assertThat(lotto.lottoNumbers.size).isEqualTo(6)
    }

    @Test
    fun `로또 번호 6개가 중복 되지 않는 로또를 생성한다`() {
        val lotto = LottoGenerator.generateLotto()
        assertThat(lotto.lottoNumbers.distinct().size).isEqualTo(6)
    }
}
