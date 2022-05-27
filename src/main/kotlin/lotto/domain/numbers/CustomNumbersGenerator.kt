package lotto.domain.numbers

class CustomNumbersGenerator(private val customNumbers: List<Int>) : LottoNumbersGenerator() {
    override fun generate(): List<Int> = customNumbers
        .takeIf { verify(it) }
        ?: throw IllegalArgumentException("로또 번호는 총 6개이고 1과 45사이의 숫자여야 합니다.")

    private fun verify(lottoNumbers: List<Int>): Boolean = lottoNumbers.size == lottoNumberSize &&
        lottoNumbers.filter { it in lottoNumberPool }.size == lottoNumberSize
}
