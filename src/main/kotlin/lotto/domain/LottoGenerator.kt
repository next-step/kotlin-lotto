package lotto.domain

interface LottoGenerator {
    fun generateLotto(numbers: List<Int>): Lotto
    fun generateLottoNumbers(): Set<LottoNumber>
}
