package lotto.domain

import org.junit.jupiter.api.Assertions.assertDoesNotThrow
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows

class LottoTest {
    @Test
    fun `로또 1장은 1부터 45까지의 모두 다른 6개의 숫자로 구성된다`() {
        val lottoNumbers =
            listOf(LottoNumber(1), LottoNumber(2), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))
        assertDoesNotThrow { Lotto.fromLottoNumbers(lottoNumbers) }
    }

    @Test
    fun `로또 1장에 동일한 숫자가 있을 경우 IllegalArgumentException 이 발생한다`() {
        val lottoNumbers =
            listOf(LottoNumber(1), LottoNumber(1), LottoNumber(3), LottoNumber(4), LottoNumber(5), LottoNumber(6))
        assertThrows<IllegalArgumentException> { Lotto.fromLottoNumbers(lottoNumbers) }
    }

    @Test
    fun `Integer List 로 부터 Lotto 를 생성할 때 정상적으로 생성된다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, 6)
        assertDoesNotThrow { (Lotto.fromInts(lottoNumbers)) }
    }

    @Test
    fun `Integer List 로 부터 Lotto 를 생성할 때 로또 숫자의 범위를 벗어나면 IllegalArgumentException 이 발생한다`() {
        val lottoNumbers = listOf(1, 2, 3, 4, 5, LottoNumber.LOTTO_UPPER_BOUND + 1)
        assertThrows<IllegalArgumentException> { (Lotto.fromInts(lottoNumbers)) }
    }
}
