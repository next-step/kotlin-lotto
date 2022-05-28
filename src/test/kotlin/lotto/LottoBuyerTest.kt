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

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000])
    fun `2) 총 금액 계산하기`(money: Int) {
        lottoBuyer.buyLotto(money)
        lottoBuyer.lottoNumbers[0].getLottoNumber(listOf(3, 20, 4, 15, 4, 5))
        Assertions.assertThat(lottoBuyer.calculateWinningTotalMoney(listOf(3, 20, 4, 15, 4, 5))).isEqualTo(2000000000)
    }

    @ParameterizedTest
    @ValueSource(ints = [1000, 2000])
    fun `3) 수익률 계산하기`(money: Int) {
        lottoBuyer.buyLotto(money)
        lottoBuyer.lottoNumbers[0].getLottoNumber(listOf(3, 20, 4, 15, 9, 5))
        val winningMoney = lottoBuyer.calculateWinningTotalMoney(listOf(3, 20, 33, 5, 2, 34))
        Assertions.assertThat(lottoBuyer.calculateEarningRate(1000, winningMoney)).isEqualTo(5.0)
    }
}
