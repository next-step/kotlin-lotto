package lotto

class ManualStrategy(val numbers: List<LottoNumber>) : LottoNumbersGenerateStrategy {
    constructor(vararg numbers: Int) : this(numbers.map { LottoNumber.from(it) })

    override fun generate(): LottoNumbers {
        return LottoNumbers(numbers)
    }
}