package lotto.domain

class LottoStore(private val money: Int, private val lottoMaker: LottoMaker = LottoMakerImpl()) {
    val lottoCount = money / EACH_LOTTO_PRICE
    val boughtLottos = mutableListOf<List<Int>>()

    init {
        repeat(lottoCount) {
            boughtLottos.add(lottoMaker.makeLottoNumbers())
        }
    }

    companion object {
        private const val EACH_LOTTO_PRICE = 1000
    }
}