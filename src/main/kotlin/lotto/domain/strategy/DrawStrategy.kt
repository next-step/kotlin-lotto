package lotto.domain.strategy

import lotto.domain.Lotto

interface DrawStrategy {

    fun draw(): Lotto
}
