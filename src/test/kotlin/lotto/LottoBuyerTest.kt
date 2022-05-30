package lotto

import lotto.domain.LottoBuyer
import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoBuyerTest {
    @ParameterizedTest
    @ValueSource(ints = [5000, 20000, 100000])
    fun `1) 입력한 금액만큼 로또 구매하기`(money: Int) {
        Assertions.assertThat(LottoBuyer.buyer(money).lottoNumbers.size).isEqualTo(money / LottoBuyer.PRICE)
    }
}
