package lotto.view

import lotto.domain.Lotto

data class LottoView(val lotto: Lotto) {

    fun print() {
        println(lotto)
    }
}
