package lotto

class LottoMachine(private val autoLottoMaker: LottoMaker, private val manualLottoMaker: LottoMaker) {

    private val autoLotto: MutableList<LottoNumber> = mutableListOf()

    init {
        for (i in LOTTO_NUMBER_START..LOTTO_NUMBER_END) autoLotto.add(CachedLottoNumbers.getLottoNumber(i))
    }

    fun buyLotto(count: Int): List<Lotto> {
        val autoLottos: MutableList<Lotto> = mutableListOf()
        repeat(count) {
            autoLottos.add(autoLottoMaker.make(autoLotto.toList()))
        }
        return autoLottos.toList()
    }

    fun buyManualLotto(lotto: List<LottoNumber>): Lotto {
        return manualLottoMaker.make(lotto)
    }

    companion object {
        private const val LOTTO_NUMBER_START = 1
        private const val LOTTO_NUMBER_END = 45
    }
}
