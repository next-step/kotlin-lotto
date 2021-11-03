package domain.lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.assertAll
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

@DisplayName("순위(Rank)")
class RankTest {

    @ParameterizedTest(name = "당첨 갯수 = {0}, 보너스볼 필요 여부 = {1}")
    @CsvSource(
        value = [
            "0:true", "0:false", "1:true", "1:false", "2:true", "2:false",
            "3:true", "3:false", "4:true", "4:false", "5:true", "5:false", "6:false", "6:true"
        ],
        delimiter = ':'
    )
    fun `맞은 숫자와 보너스 필요 유무를 통해 생성한다`(matchOfNumber: Int, needBonusBall: Boolean) {
        val rank = Rank(matchOfNumber, needBonusBall)

        assertAll(
            { assertThat(rank).isNotNull },
            { assertThat(rank).isExactlyInstanceOf(Rank::class.java) }
        )
    }
}
