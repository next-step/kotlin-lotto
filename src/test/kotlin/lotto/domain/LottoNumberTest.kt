package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoNumberTest {

    @ParameterizedTest
    @ValueSource(ints = [0, -1, 46, 47, 48, 49])
    fun `유효하지 않은 로또 번호를 만들 때 Excetion 발생 확인`(number: Int) {
        assertThrows<IllegalArgumentException> { LottoNumber.from(number) }
    }

    @ParameterizedTest
    @ValueSource(ints = [1, 2, 3, 4, 5, 45])
    fun `유효한 번호를 넣었을 때 잘 생성이 되는지 확인`(number: Int) {
        assertThat(LottoNumber.from(number)).isEqualTo(LottoNumber.from(number))
    }
}
