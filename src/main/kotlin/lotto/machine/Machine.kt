package lotto.machine

import lotto.Lotto

interface Machine {
    fun generate(): Lotto
}
