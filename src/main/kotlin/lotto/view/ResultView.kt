package lotto.view

import lotto.model.Lotto

object ResultView {
    fun showBuyLotto(lottoList: List<Lotto>) {
        println("${lottoList.size}개를 구매했습니다.")
        lottoList.forEach {
            println(it.numbers.map { lottoNumber -> lottoNumber.number })
        }
    }
}
