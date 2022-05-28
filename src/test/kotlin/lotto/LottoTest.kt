package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {
    private lateinit var lotto: Lotto

    @BeforeEach
    fun setup() {
        lotto = Lotto()
    }

    @Test
    fun `1) 로또를 구매하는 경우에 6개의 번호가 생성된다`() {
        lotto.getLottoNumber()
        Assertions.assertThat(lotto.lottoNumber.size).isEqualTo(6)
    }

    @Test
    fun `2) 로또를 구매한 번호와 당첨 번호가 일치하는 경우 개수를 반환한다`() {
        lotto.getLottoNumber(listOf(5, 10, 15, 20, 25, 30))
        val count = lotto.getCountWithWinningLottoNumber(listOf(1, 2, 3, 4, 10, 15))
        Assertions.assertThat(count).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource(
        "3/ 5000",
        "4/ 50000",
        "5/ 150000",
        "6/ 2000000000",
        "0/ 0",
        "1/ 0",
        "2/ 0",
        delimiter = '/'
    )
    fun `3) 로또를 구매한 번호와 당첨 번호가 일치하는 경우 개수를 반환한 경우 해당 개수 통해서 당첨금액과 교환이 가능하다`(
        count: Int,
        money: Int
    ) {
        val exchangeMoney = lotto.exchangeCountToMoney(count)
        Assertions.assertThat(exchangeMoney).isEqualTo(money)
    }
}
