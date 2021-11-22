package lotto

import lotto.domain.LottoMatch
import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.WinningLotto
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottoMatchTest {

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,11,22,33|1,2,3,14,24,35"], delimiterString = "|")
    fun `3개이상이 매칭될경우 Map에 저장되어 반환됩니다`(userLottoNumber: String, winningLottoNumber: String) {

        val userLotto = listOf(
            Lotto(
                userLottoNumber
                    .split(",")
                    .map { it.trim().toInt() }
                    .toList()
            )
        )

        val winningLotto = WinningLotto(
            winningLottoNumber
                .split(",")
                .map { it.trim().toInt() }
                .toList()
        )

        val matchMap = LottoMatch.match(userLotto, winningLotto)

        assertThat(matchMap).isNotEmpty
    }

    @ParameterizedTest
    @CsvSource(value = ["1,2,3,4,5,6|11,13,24,35,44,45"], delimiterString = "|")
    fun `3개미만으로 매칭될경우 비어있는 Map 이 반환됩니다`(userLottoNumber: String, winningLottoNumber: String) {
        val userLotto = listOf(
            Lotto(
                userLottoNumber
                    .split(",")
                    .map { it.trim().toInt() }
                    .toList()
            )
        )

        val winningLotto = WinningLotto(
            winningLottoNumber
                .split(",")
                .map { it.trim().toInt() }
                .toList()
        )

        val matchMap = LottoMatch.match(userLotto, winningLotto)

        assertThat(matchMap).isEmpty()
    }
}
