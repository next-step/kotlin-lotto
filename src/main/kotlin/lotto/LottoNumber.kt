package lotto

class LottoNumber private constructor(val values: List<Int>) {
    companion object {
        fun generate(): LottoNumber {
            return LottoNumber(values = listOf(1, 3, 5, 7, 9, 10))
        }
    }
}
