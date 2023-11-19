package lotto.domain

interface NumberGenerator {
    fun generateNumbers(startNumber: Int, endNumber: Int, count: Int): Set<LottoNumber>
}
