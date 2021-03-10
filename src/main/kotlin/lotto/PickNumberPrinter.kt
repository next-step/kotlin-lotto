package lotto

class PickNumberPrinter(private val lottoNumbers: List<LottoNumbers>) {
    fun print() {
        lottoNumbers.map { it.joinToString(prefix = "[", postfix = "]") }
            .forEach { println(it) }
    }
}
