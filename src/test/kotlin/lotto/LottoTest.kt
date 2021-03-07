package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoTest {

    @Test
    fun `로또번호 6개로 로또를 생성할 수 있다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val result = Lotto(lottoNumbers)
        assertThat(result).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 7])
    fun `로또 생성 시 로또번호 6개가 아닌 경우 예외를 반환한다`(lottoNumberCount: Int) {
        val lottoNumbers = (1..lottoNumberCount).map { LottoNumber(it) }
        val expectedMessage = "로또번호 개수가 6개가 아닙니다."

        val result = assertThrows<IllegalArgumentException> { Lotto(lottoNumbers) }

        assertThat(result.message).isEqualTo(expectedMessage)
    }
}
