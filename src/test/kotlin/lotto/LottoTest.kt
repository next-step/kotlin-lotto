package lotto

import lotto.domain.Lotto
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoTest {

    @Test
    fun `1) 로또를 구매하는 경우에 6개의 번호가 생성된다`() {
        Lotto.random()
        Assertions.assertThat(Lotto.random().lottoNumber.size).isEqualTo(6)
    }

    @Test
    fun `2) 구매한 로또가 5개로 이루어진 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(5, 10, 15, 20, 25)) }
    }

    @Test
    fun `3) 구매한 로또가 중복된 번호가 있는 경우 예외를 발생한다`() {
        assertThrows<IllegalArgumentException> { Lotto(listOf(5, 10, 15, 20, 25, 25)) }
    }

    @Test
    fun `4) 로또를 구매한 번호와 당첨 번호가 일치하는 경우 개수를 반환한다`() {
        val count = Lotto(listOf(5, 10, 15, 20, 25, 30)).getCountWithWinningLottoNumber(listOf(1, 2, 3, 4, 10, 15))
        Assertions.assertThat(count).isEqualTo(2)
    }

    @ParameterizedTest
    @CsvSource(
        "3/ 5000",
        "4/ 50000",
        "5/ 1500000",
        "6/ 2000000000",
        "0/ 0",
        "1/ 0",
        "2/ 0",
        delimiter = '/'
    )
    fun `5) 로또를 구매한 번호와 당첨 번호가 일치하는 경우 개수를 반환한 경우 해당 개수 통해서 당첨금액과 교환이 가능하다`(
        count: Int,
        money: Int
    ) {
        val exchangeMoney = Lotto(listOf(5, 10, 15, 20, 25, 30)).exchangeCountToMoney(count)
        Assertions.assertThat(exchangeMoney).isEqualTo(money)
    }
}
