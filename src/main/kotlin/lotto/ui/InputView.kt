package lotto.ui

import lotto.domain.Lotto
import lotto.domain.LottoDispenser

class InputView {

    fun input(): Pair<Int, List<Lotto>> {
        println("구입금액을 입력해 주세요.")
        val amount = readLine()?.toIntOrNull() ?: 0
        val lottoList = LottoDispenser(amount).list
        return amount to lottoList
    }

    fun showLottoList(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach { println(it) }
    }
}
