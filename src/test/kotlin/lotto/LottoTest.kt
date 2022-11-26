package lotto

import lotto.domain.Lotto
import lotto.domain.generator.RandomGenerator
import org.assertj.core.api.AssertionsForInterfaceTypes.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또 번호가 1~45 범위 내 무작위로 선택된다`() {
        val lotto = Lotto(RandomGenerator())
        for(number in lotto.lottoNums) {
            assertThat(number.value).isGreaterThanOrEqualTo(1)
            assertThat(number.value).isLessThanOrEqualTo(45)
        }
    }
}