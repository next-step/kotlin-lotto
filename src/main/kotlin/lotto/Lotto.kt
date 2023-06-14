package lotto

import kotlin.random.Random
import kotlin.random.nextInt

class Lotto(
    lottoNumbers: List<LottoNumber> = emptyList(),
) {
    var lottoNumbers: List<LottoNumber> =
        lottoNumbers.ifEmpty { List(LOTTO_NUMBER_COUNT) { LottoNumber(randomLottoNumber()) } }
        private set

    init {
        require(lottoNumbers.size == lottoNumbers.distinct().size) { "로또번호는 중복이 없어야 합니다." }
    }

    fun isMatchedByMatchCount(other: Lotto, matchCount: Int): Boolean {
        val matchedLottoNumbers = lottoNumbers.filter { other.lottoNumbers.contains(it) }
        return matchedLottoNumbers.size == matchCount
    }

    private fun randomLottoNumber(): Int = Random.nextInt(LOTTO_NUMBER_RANGE)

    companion object {
        private const val LOTTO_NUMBER_COUNT = 6
    }
}
