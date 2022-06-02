package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class LottoCreatorTest {

    @Test
    fun `로또 번호는 중복되지 않는 1-45 숫자 6개를 선택한다`() {
        val autoCreatedLotto = LottoCreator.autoCreate()
        Assertions.assertThat(autoCreatedLotto.numbers.size).isEqualTo(6)
    }
}
