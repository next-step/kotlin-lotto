package lotto.domain

object LottoSeller {

    fun sellAutoLotto(amount: Int) = List(amount) { Lotto(generateLottoNumbers()) }

    fun sellManualLotto(manualNumbers: List<List<Int>>): List<Lotto> {
        return manualNumbers.map { numbers ->
            Lotto(numbers.map{ LottoNumber(it) }.toSet())
        }
    }

    private fun generateLottoNumbers(): Set<LottoNumber> = LottoNumber.VALID_RANGE.shuffled()
        .take(Lotto.COUNT_OF_LOTTO_NUMBER)
        .map { LottoNumber(it) }
        .toSet()
}
