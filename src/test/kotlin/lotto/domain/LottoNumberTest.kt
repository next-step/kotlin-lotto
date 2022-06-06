package lotto.domain

import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

/**
 * Created by Jaesungchi on 2022.06.06..
 */
class LottoNumberTest {
    @ParameterizedTest
    @ValueSource(ints = [0, 46, 47, 48])
    internal fun `로또 번호가 1에서 45사이가 아닌경우 IllegalArgumentException을 던진다`(source: Int) {
        assertThrows<IllegalArgumentException> {
            LottoNumber.of(source)
        }
    }
}
