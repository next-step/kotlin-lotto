package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `로또번호는 1이상 45이하여야 한다`(number: Int) {
        // then
        assertThrows<IllegalArgumentException> { LottoNumber(number) }
            .run { assertThat(this).hasMessageContaining("로또 번호는 ${LottoNumber.MIN_NUMBER}보다 크고 ${LottoNumber.MAX_NUMBER}보다 작아야 합니다. number:$number") }
    }

    @ParameterizedTest
    @ValueSource(ints = [0, 46])
    fun `캐싱해둔 번호도 1이상 45에서 가져온다`(number: Int) {
        // then
        assertThrows<IllegalArgumentException> { LottoNumber.of(number) }
            .run { assertThat(this).hasMessageContaining("로또 번호는 ${LottoNumber.MIN_NUMBER}보다 크고 ${LottoNumber.MAX_NUMBER}보다 작아야 합니다. number:$number") }
    }
}
