package lotto.service

import lotto.domain.Numbers

interface NumberCreateStrategy {

    fun makeNumbersByQuantity(quantity: Int): List<Numbers>
}
