package lotto.model.game

object LottoNumberPool {
    private const val MIN = 1
    private const val MAX = 45
    private const val INDEX_FIRST_INCLUSIVE = 0
    private const val INDEX_LAST_EXCLUSIVE = 6
    private val NUMBER_POOL = (MIN..MAX).toSet()
    private val LOTTO_POOL = NUMBER_POOL.map(::LottoNumber)

    fun getOneLotto(): Lotto {
        return Lotto(getSixLottoNumbers())
    }

    private fun getSixLottoNumbers(): Set<LottoNumber> {
        return LOTTO_POOL
            .shuffled()
            .subList(INDEX_FIRST_INCLUSIVE, INDEX_LAST_EXCLUSIVE)
            .toSet()
    }
}
