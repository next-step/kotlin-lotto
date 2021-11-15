package lotto

import lotto.domain.LottoNumber
import lotto.domain.LottoNumbers
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `0과 46은 로또 범위에 들어가있지 않기 때문에 에러를 발생시킨다`(input: Int) {
        // given
        val actual =
            runCatching { LottoNumber.from(input) }.exceptionOrNull()

        // then
        Assertions.assertThat(actual).hasMessageContaining("범위에 벗어난 숫자입니다.")
    }

    @Test
    fun `당첨 번호 속에 보너스 번호가 중복이 된다면 에러를 발생시킨다`() {
        // given
        val winningNumber = LottoNumbers.generateLottoNumbers(listOf(1, 2, 3, 4, 5, 6))

        // when
        val actual =
            runCatching { LottoNumber.ofBonusNumber(3, winningNumber) }.exceptionOrNull()

        // then
        Assertions.assertThat(actual).hasMessageContaining("당첨 번호와 겹치는 숫자가 있습니다.")
    }
}
