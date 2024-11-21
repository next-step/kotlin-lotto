package lotto.view.result

import lotto.domain.Lotto

object LottoListView {
    fun print(lottos: List<Lotto>) {
        val sb = StringBuilder()
        lottos.forEach { sb.append("${it}\n") }
        println(sb.toString())
    }
}
