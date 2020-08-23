package lotto.model.lotto

class LottoNumber private constructor(val number: Int) {
    companion object {
        private val lottoNumbers = Lotto.LOTTO_RANGE.associateWith(::LottoNumber)
        fun from(number: Int) = lottoNumbers[number] ?: throw IllegalArgumentException()
        fun from(number: String) = from(number.toInt())
    }

    override fun toString() = number.toString()
}

fun List<Int>.toLottoNumbers() = this.map { LottoNumber.from(it) }.toSet()
