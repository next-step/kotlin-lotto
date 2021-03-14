package lotto.domain

import lotto.vo.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

internal class LottoGeneratorTest {
    @Test
    @DisplayName("로또 번호 자동 생성기는 6개의 로또번호를 생성한다")
    fun autoGenerateLottoTest() {
        assertThat(LottoGenerator.generate().lottoNumbers.size).isEqualTo(Lotto.LOTTO_SIZE)
    }
}