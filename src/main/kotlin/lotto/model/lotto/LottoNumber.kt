package lotto.model.lotto

class LottoNumber private constructor(val number: Int) {
    companion object {
        private val lottoNumbers = Lotto.LOTTO_RANGE.associateWith(::LottoNumber)
        fun from(number: Int) = lottoNumbers.get(number) ?: throw IllegalArgumentException()
        fun from(number: String) = from(number.toInt())
    }
}

fun List<Int>.toLottoNumbers() = this.map { LottoNumber.from(it) }.toSet()
