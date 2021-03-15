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
        val dummyBonusNumber = LottoNumber(45)
        val result = WinningLotto(lottoNumbers, dummyBonusNumber)
        Assertions.assertThat(result).isNotNull
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 5, 7])
    fun `당첨로또를 생성 시 로또번호 6개가 아닌 경우 예외를 반환한다`(lottoNumberCount: Int) {
        val lottoNumbers = (1..lottoNumberCount).map { LottoNumber(it) }
        val dummyBonusNumber = LottoNumber(45)
        val expectedMessage = "로또번호 개수가 6개가 아닙니다."

        val result = assertThrows<IllegalArgumentException> { WinningLotto(lottoNumbers, dummyBonusNumber) }

        Assertions.assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `당첨로또를 생성 시 중복된 로또번호가 있는 경우 예외를 반환한다`() {
        val lottoNumbers = listOf(1, 1, 2, 3, 4, 5).map { LottoNumber(it) }
        val dummyBonusNumber = LottoNumber(45)
        val expectedMessage = "중복된 로또번호가 있습니다."

        val result = assertThrows<IllegalArgumentException> { WinningLotto(lottoNumbers, dummyBonusNumber) }

        Assertions.assertThat(result.message).isEqualTo(expectedMessage)
    }

    @Test
    fun `당첨로또의 당첨번호 중에 보너스번호가 존재하는 경우 예외를 반환한다`() {
        val lottoNumbers = (1..6).map { LottoNumber(it) }
        val bonusNumber = LottoNumber(1)
        val expectedMessage = "당첨번호 중에 보너스번호가 존재할 수 없습니다."

        val result = assertThrows<IllegalArgumentException> { WinningLotto(lottoNumbers, bonusNumber) }

        Assertions.assertThat(result.message).isEqualTo(expectedMessage)
    }
}
