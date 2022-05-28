package lotto

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoBuyerTest {
    private lateinit var lottoBuyer: LottoBuyer

    @BeforeEach
    fun setup() {
        lottoBuyer = LottoBuyer()
    }

    @ParameterizedTest
    @ValueSource(ints = [5000, 20000, 100000])
    fun `1) 입력한 금액만큼 로또 구매하기`(money: Int) {
        lottoBuyer.buyLotto(money)
        Assertions.assertThat(lottoBuyer.lottoNumbers.size).isEqualTo(money / LottoBuyer.PRICE)
    }
}
