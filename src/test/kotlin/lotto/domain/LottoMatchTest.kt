package lotto.domain

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMatchTest {
    @ParameterizedTest
    @CsvSource(
        "0/ false/ 0",
        "1/ false/ 0",
        "2/ false/ 0",
        "3/ false/ 5_000",
        "4/ false/ 50_000",
        "5/ false/ 1_500_000",
        "5/ true/ 30_000_000",
        "6/ false/ 2_000_000_000",
        delimiter = '/'
    )
    fun `1) 로또를 구매한 번호와 당첨 번호가 일치하는 경우 개수를 반환한 경우 해당 개수 통해서 당첨금액과 교환이 가능하다`(
        count: Int,
        hasBonusNumber: Boolean,
        money: Int
    ) {
        val findLottoMatch = LottoMatch.findLottoMatch(count, hasBonusNumber)
        Assertions.assertThat(findLottoMatch.prize).isEqualTo(money)
    }
}
