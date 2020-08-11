package model

import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WinningResultTest {
    @Test
    @DisplayName("로또 숫자와 당첨 번호를 가지고 (같은 숫자의 수, 발생횟수, 당첨금액) 목록 생성된다")
    fun `getPrizeList`() {
        var list = lottoList()
        val winningLotto = WinningLotto(setOf(1, 2, 3, 4, 5, 6).map { LottoNumber.from(it) }.toSet(), 7)
        val winningResult = WinningResult(list, winningLotto, Money(1000))
        val winningStatList = winningResult.stat()
        println(winningStatList)
        Assertions.assertThat(winningStatList).isNotEmpty
    }

    @Test
    @DisplayName("수익률을 계산 할 수 있다")
    fun `getEarningRate`() {
        var list = lottoList()
        val winningLotto = WinningLotto(list[0].number, 7)
        val winningResult = WinningResult(list, winningLotto, Money(1000))
        val result = winningResult.earningRate()
        assertThat(result).isGreaterThanOrEqualTo(0.0)
    }

    private fun lottoList(): List<Lotto> {
        var list = mutableListOf<Lotto>()
        repeat(10) {
            val lotto = Lotto.make()
            list.add(lotto)
        }
        return list.toList()
    }
}
