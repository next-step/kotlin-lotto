package lotto.view

import lotto.model.Lotto

object ResultView {
    fun showLottos(list: List<Lotto>) {
        println("${list.size}개 로또 구매완료")
        list.map { println(it) }
    }
}
