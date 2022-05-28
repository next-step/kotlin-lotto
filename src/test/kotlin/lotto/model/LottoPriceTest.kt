package lotto.model

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource
import java.lang.IllegalArgumentException

internal class LottoPriceTest {

    @ParameterizedTest(name = "`{0}`인 경우 IllegalArgumentException 에러 발생")
    @ValueSource(ints = [-3, -7])
    internal fun `입력한 값이 음의 정수이면 IllegalArgumentException 에러 발생`(price: Int) {
        assertThrows<IllegalArgumentException> { LottoPrice(price) }
    }

    @ParameterizedTest(name = "`{0}`인 경우 LottoPrice 생성 성공")
    @ValueSource(ints = [0, 1500, 1])
    internal fun `입력한 값이 0이거나 양의 정수이면 LottoPrice 생성 성공`(price: Int) {
        assertThat(LottoPrice(price).get()).isEqualTo(price)
    }
}
