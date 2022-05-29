package lotto

private const val LOTTO_NUMBER_START = 1
private const val LOTTO_NUMBER_END = 45

object CachedLottoNumbers {
    private val lottoNumberMap: MutableMap<Int, LottoNumber> = HashMap()

    init {
        for (i in LOTTO_NUMBER_START..LOTTO_NUMBER_END) {
            lottoNumberMap[i] = LottoNumber(i)
        }
    }

    fun getLottoNumber(value: Int): LottoNumber {
        return lottoNumberMap.getOrPut(value) { LottoNumber(value) }
    }
}
