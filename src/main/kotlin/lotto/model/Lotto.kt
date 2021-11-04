package lotto.model

data class Lotto(
    val price: Int,
    val numbers: LottoNumbers,
    private val type: Type
) {

    enum class Type {
        AUTO,
        MANUAL
    }

    val isAuto: Boolean = type == Type.AUTO
    val isManual: Boolean = type == Type.MANUAL

    init {
        require(price >= 0)
    }

    fun match(numbers: LottoNumbers): Int = this.numbers.match(numbers)

    operator fun contains(number: LottoNumber): Boolean = number in numbers

    companion object {

        fun auto(price: Int): Lotto = Lotto(price, LottoNumbers.random(), Type.AUTO)

        fun manual(price: Int, numbers: LottoNumbers) = Lotto(price, numbers, Type.MANUAL)
    }
}
