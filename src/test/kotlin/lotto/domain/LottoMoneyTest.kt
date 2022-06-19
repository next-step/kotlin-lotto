package lotto.domain

import io.kotest.matchers.throwable.shouldHaveMessage
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoMoneyTest {

    @ParameterizedTest
    @ValueSource(ints = [0, 999, -1000])
    fun `1000원 미만 금액 입력시 예외`(money: Int) {
        assertThrows<IllegalArgumentException>{LottoMoney.from(money)}
            .shouldHaveMessage("최소 구입금액은 ${Lotto.PRICE}원 입니다.")
    }

    @ParameterizedTest
    @ValueSource(ints = [1001, 1999, 100001])
    fun `1000원 단위가 아닌 금액 입력시 예외`(money: Int) {
        assertThrows<IllegalArgumentException>{LottoMoney.from(money)}
            .shouldHaveMessage("${Lotto.PRICE}원 단위로 구매하실 수 있습니다.")
    }
}
