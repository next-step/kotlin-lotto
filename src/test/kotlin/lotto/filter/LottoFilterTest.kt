package lotto.filter

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoFilterTest {

    @ParameterizedTest
    @ValueSource(strings = ["1", "10", "21", "30", "41", "45"])
    fun `들어오는 로또 번호 값이 로또 범위 (1 ~ 45 )  안에 있는 있는지 확인합니다`(number: Int) {
        assertThat(LottoFilter.verify(number)).isEqualTo(number)
    }

    @ParameterizedTest
    @ValueSource(strings = ["-1", "46", "999", "-111"])
    fun `들어오는 로또 번호 값이 로또 범위를 벗어나면 IllegalArgumentException 예외가 발생한다`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoFilter.verify(number) }
    }
}
