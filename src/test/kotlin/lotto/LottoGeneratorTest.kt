package lotto

import lotto.domain.Lotto
import lotto.domain.LottoGenerator
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LottoGeneratorTest {

    @DisplayName("로또 생성 반환값 테스트 ")
    @Test
    fun validateLottoGenerator() {
        assertThat(LottoGenerator.createLotto()).isInstanceOf(Lotto::class.java)
    }
}
