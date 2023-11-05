package lotto

class Lottos(val lottoList: List<Lotto>) {
    constructor (amount: Int) : this(generateLottoList(amount))

    fun isNotEmpty() = lottoList.isNotEmpty()
    companion object {
        private fun generateLottoList(amount: Int) = (1..amount).map { Lotto() }
    }
}
