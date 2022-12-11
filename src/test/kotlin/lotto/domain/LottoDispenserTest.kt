package lotto.domain

import io.kotest.assertions.throwables.shouldThrow
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LottoDispenserTest {

    @DisplayName("구입 금액 만큼 로또를 생성한다")
    @ParameterizedTest
    @ValueSource(
        ints = [1000, 14000, 14500]
    )
    fun createLotto(amount: Int) {
        val expectedValue = amount / MINIMUM_PRICE
        val dispenser = LottoDispenser(amount)

        dispenser.lottoList.size shouldBe expectedValue
    }

    @DisplayName("금액이 0이거나 음수인 경우 로또는 생성되지 않는다")
    @ParameterizedTest
    @ValueSource(
        ints = [0, -14000, -14500]
    )
    fun zeroOrMinusAmount(amount: Int) {
        shouldThrow<IllegalArgumentException> {
            LottoDispenser(amount)
        }
    }
}
