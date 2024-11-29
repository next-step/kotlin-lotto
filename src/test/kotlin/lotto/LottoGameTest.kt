package lotto

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoGameTest {

    @ParameterizedTest
    @CsvSource("1000", "2000", "3000")
    fun `구매한 로또 만큼 랜덤한 번호를 생성한다`(price: Int) {
        LottoGame().purchase(1000).forEach {
            assertThat(it.numbers.distinct().size).isEqualTo(6)
        }
    }

    @Test
    fun `구매한 로또번호와 당첨번호가 3개 이상 일치하면 당첨된다`() {
        val purchaseLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        purchaseLotto.match(winningLotto)
    }

    @Test
    fun `구매한 로또번호와 당첨번호가 2개 이하 일치하면 낙첨된다`() {
        val purchaseLotto = Lotto(listOf(1, 2, 3, 4, 5, 6))
        val winningLotto = Lotto(listOf(1, 2, 3, 7, 8, 9))
        purchaseLotto.match(winningLotto)
    }


}
