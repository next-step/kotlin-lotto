package lotto.domain

interface LottoMaker {
    val manualLotto: List<LottoNumbers>

    fun buyAutoLotto(): LottoNumbers
    fun buyManualLotto(numbers: List<List<Int>>)
}
