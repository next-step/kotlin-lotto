package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMatchTest {
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
    fun `1) 로또를 구매한 번호와 당첨 번호가 일치하는 경우 개수를 반환한 경우 해당 개수 통해서 당첨금액과 교환이 가능하다`(
        count: Int,
        money: Int
    ) {
        val findLottoMatch = LottoMatch.findLottoMatch(count)
        Assertions.assertThat(findLottoMatch.prize).isEqualTo(money)
    }
}
