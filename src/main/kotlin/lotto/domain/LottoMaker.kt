package lotto.domain

interface LottoMaker {
    val manualLotto: List<LottoNumbers>

    fun makeLottoNumbers(): LottoNumbers
    fun buyManualLotto(numbers: List<List<Int>>)
}
