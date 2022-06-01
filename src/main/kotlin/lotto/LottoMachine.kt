package lotto

class LottoMachine(private val autoLottoMaker: LottoMaker, private val manualLottoMaker: LottoMaker) {

    private val lotto: MutableList<LottoNumber> = mutableListOf()
    val lottos: Lottos = Lottos()

    init {
        for (i in LOTTO_NUMBER_START..LOTTO_NUMBER_END) lotto.add(CachedLottoNumbers.getLottoNumber(i))
    }

    fun buyLotto(count: Int){
        repeat(count) {
            lottos.add(autoLottoMaker.make(lotto.toList()))
        }
    }

    fun buyManualLotto(lotto: List<LottoNumber>) {
        lottos.add(manualLottoMaker.make(lotto))
    }


    companion object {
        private const val LOTTO_NUMBER_START = 1
        private const val LOTTO_NUMBER_END = 45
    }
}
