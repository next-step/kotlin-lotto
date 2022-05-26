package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {
    @Test
    fun `구매개수만큼 로또번호를 발급한다`() {
        val count = 10
        val lottoList = List(count) { Lotto { LottoGenerator().generateNumbers() } }
        assertThat(lottoList.size).isEqualTo(count)
    }

    @Test
    fun `생성된 로또번호는 중복을 허용하지 않는다`() {
        val count = 10
        val lottoList = List(count) { Lotto { LottoGenerator().generateNumbers() } }

        repeat(count) {
            assertThat(lottoList[it].numbers.distinct().size).isEqualTo(6)
        }
    }
}
