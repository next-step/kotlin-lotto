package lotto.domain

class QuantityChanger {

    fun change(amount: Int): Int = amount / Lotto.AMOUNT_PER_LOTTO

}
