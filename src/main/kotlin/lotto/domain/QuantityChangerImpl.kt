package lotto.domain

class QuantityChangerImpl : QuantityChanger {

    override fun change(amount: Int): Int = amount / Lotto.AMOUNT_PER_LOTTO

}
