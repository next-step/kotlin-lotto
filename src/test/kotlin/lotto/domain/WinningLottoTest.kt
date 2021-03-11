package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class WinningLottoTest {

    @Test
    fun `로또번호 6개로 당첨로또를 생성할 수 있다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val result = WinningLotto(lottoNumbers)
        Assertions.assertThat(result).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 7])
    fun `당첨로또를 생성 시 로또번호 6개가 아닌 경우 예외를 반환한다`(lottoNumberCount: Int) {
        val lottoNumbers = (1..lottoNumberCount).map { LottoNumber(it) }
        val expectedMessage = "로또번호 개수가 6개가 아닙니다."

        val result = assertThrows<IllegalArgumentException> { WinningLotto(lottoNumbers) }

        Assertions.assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `당첨로또를 생성 시 중복된 로또번호가 있는 경우 예외를 반환한다`() {
        val lottoNumbers = listOf(1, 1, 2, 3, 4, 5).map { LottoNumber(it) }
        val expectedMessage = "중복된 로또번호가 있습니다."

        val result = assertThrows<IllegalArgumentException> { WinningLotto(lottoNumbers) }

        Assertions.assertThat(result.message).isEqualTo(expectedMessage)
    }
}
