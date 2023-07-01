package lotto.domain

data class LottoNumbers(val values: List<LottoNumber>) {
    init {
        require(values.size == LOTTO_SIZE) {
            "로또 사이즈는 $LOTTO_SIZE 입니다. [입력 사이즈: ${values.size}]"
        }
    }

    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber(it) }.toList())

    fun countMatchingNumbers(winningNumbers: LottoNumbers) =
        values.count { winningNumbers.containNumber(it) }

    fun containNumber(number: LottoNumber): Boolean {
        return values.contains(number)
    }

    companion object {
        fun List<Int>.toNumbers(): LottoNumbers {
            return LottoNumbers(this.map { LottoNumber(it) })
        }
    }
}
