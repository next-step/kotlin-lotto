package lotto

import lotto.model.lotto.Lotto
import lotto.model.LottoManager
import lotto.model.lotto.WinnerNumbers
import lotto.model.lotto.toLottoNumber
import lotto.model.lotto.toNumbers
import lotto.model.prize.Money
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class LottoManagerTest {

    @DisplayName(value = "특정 가격 입력시, 가격에 맞는 로또가 있어야한다.")
    @ParameterizedTest
    @ValueSource(ints = [0, 100, 1000, 10000, 20000])
    fun lottoManagerCheckNumberSize(input: Int) {
        val winner = WinnerNumbers("1,2,3,4,5,6".toNumbers(), 7.toLottoNumber())
        val lottos = LottoManager(Money(input)).checkNumbers(winner)
        assertThat(lottos.lottoBuyCount).isSameAs(input / Lotto.PRICE)
    }
}
