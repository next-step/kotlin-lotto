package lotto

import lotto.domain.BonusBall
import lotto.domain.Lotto
import lotto.domain.LottoGeneratorImpl
import lotto.domain.LottoNumber
import lotto.domain.Lottos
import lotto.domain.Money
import lotto.domain.Rank
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LottosTest {

    @DisplayName(value = "당첨 lotto번호를 통해 Map(Rank, count)를 생성한다")
    @Test
    fun `당첨 lotto번호를 통해 Map(Rank, count)를 생성한다`() {
        val winningLottoNumbers = (1..6).map { LottoNumber.from(it) }
        val winningLotto = Lotto.from(winningLottoNumbers)

        val lottos1Numbers = (1..6).map { LottoNumber.from(it) }
        val lotto1 = Lotto.from(lottos1Numbers)
        val lottos2Numbers = (1..6).map { LottoNumber.from(it) }
        val lotto2 = Lotto.from(lottos2Numbers)
        val lottos3Numbers = (2..7).map { LottoNumber.from(it) }
        val lotto3 = Lotto.from(lottos3Numbers)
        val lottos4Numbers = (3..8).map { LottoNumber.from(it) }
        val lotto4 = Lotto.from(lottos4Numbers)

        val lottos = Lottos.from(listOf(lotto1, lotto2, lotto3, lotto4))

        assertThat(lottos.match(winningLotto, BonusBall.of("45", winningLotto)).result).containsEntry(Rank.FIRST, 2)
            .containsEntry(Rank.THIRD, 1)
            .containsEntry(Rank.FOURTH, 1)
    }

    @ParameterizedTest(name = "money와 LottoNumberGenerator를 통해 lottos를 생성할 수 있다.")
    @CsvSource("10000, 10", "9000, 9", "8350, 8", "99999, 99")
    fun `money와 LottoNumberGenerator를 통해 lottos를 생성할 수 있다`(value: Int, expected: Int) {
        val money = Money.from(value)
        val lottoGenerator = LottoGeneratorImpl()

        val lottos = Lottos.from(lottoGenerator.generateLotto(money))

        assertThat(lottos.lottos.size).isEqualTo(expected)
    }
}
