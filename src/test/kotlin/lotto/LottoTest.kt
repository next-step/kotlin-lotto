package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoTest {

    @Test
    fun `로또의 번호는 순서와 상관없이 일치한 갯수로 계산된다`() {
        val lotto = Lotto(LottoNumbers(Fixtures.createSixLottoNumber(listOf(2, 10, 3, 11, 5, 6))))
        val lottoNumbers = LottoNumbers(Fixtures.createSixLottoNumber(listOf(10, 2, 11, 3, 12, 45)))

        val matchesCount = lotto.matches(lottoNumbers)
        assertThat(matchesCount).isEqualTo(4)
    }
}
