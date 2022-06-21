package lotto.domain

import org.junit.jupiter.api.assertDoesNotThrow
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoPriceTest {

    @ParameterizedTest(name = "`{0}`인 경우 IllegalArgumentException 에러 발생")
    @ValueSource(ints = [-3, -7, 1, 900])
    internal fun `입력한 값이 1000원 미만이면 IllegalArgumentException 에러 발생`(price: Int) {
        assertThrows<IllegalArgumentException> { LottoPrice.of(price) }
    }

    @ParameterizedTest(name = "`{0}`인 경우 LottoPrice 생성 성공")
    @ValueSource(ints = [1000, 1500, 30000])
    internal fun `입력한 값이 1000원 이상이면 LottoPrice 생성 성공`(price: Int) {
        assertDoesNotThrow { LottoPrice.of(price) }
    }
}
