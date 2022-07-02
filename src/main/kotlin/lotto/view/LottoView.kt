package lotto.view

import lotto.domain.Lotto

object LottoView {

    fun print(lotto: Lotto) {
        println("[${lotto.numbers.joinToString { it.value.toString() }}]")
    }
}
