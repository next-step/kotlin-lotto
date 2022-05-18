package lotto.domain

class LottoMachine {

    fun generateAuto(): Lotto {
        return Lotto()
    }

    companion object {
        const val LOTTO_PRICE: Long = 1_000
    }
}
