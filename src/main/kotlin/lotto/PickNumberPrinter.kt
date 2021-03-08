package lotto

class PickNumberPrinter(private val lottoNumbers: List<LottoNumber>) {
    fun print() {
        lottoNumbers.map { it.joinToString(prefix = "[", postfix = "]") }
            .forEach { println(it) }
    }
}
