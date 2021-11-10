package lotto

import lotto.domain.lotto.Lotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `원하는 로또 번호를 생성 할 수 있다 `() {

        val customLottoNumber = listOf(1, 2, 43, 42, 45, 22).sorted()

        val lotto: Lotto = Lotto(customLottoNumber)

        checkSameLottoNumber(lotto.lottoNumber, customLottoNumber, 6)
    }

    private fun checkSameLottoNumber(createLotto: List<Int>, customLotto: List<Int>, size: Int) {

        assertThat(createLotto.size).isEqualTo(size)
        assertThat(customLotto.size).isEqualTo(size)

        for (i in 0 until size) {
            assertThat(createLotto[i]).isEqualTo(customLotto[i])
        }
    }
}
