package lotto

import lotto.Fixtures.createSixLottoNumber
import lotto.model.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoNumbersTest {

    @Test
    fun `로또의 번호는 순서와 상관없이 일치한 갯수로 계산된다`() {
        val lotto = Lotto(createSixLottoNumber(listOf(2, 10, 3, 11, 5, 6)))
        val lottoNumbers = Lotto(createSixLottoNumber(listOf(10, 2, 11, 3, 12, 45)))

        val matchesCount = lotto.matches(lottoNumbers)
        Assertions.assertThat(matchesCount).isEqualTo(4)
    }

    @Test
    fun `발급되는 로또는 1~45의 로또 숫자가 6개가 아니면 IllegalArgument 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> { Lotto(createSixLottoNumber(listOf(2, 10, 15, 22, 27, 36, 9))) }
    }

    @Test
    fun `로또 번호 6자리가 중복되면 IllegalArgument 에러가 발생한다`() {
        assertThrows<IllegalArgumentException> { Lotto(createSixLottoNumber(listOf(2, 10, 3, 11, 5, 5))) }
    }
}
