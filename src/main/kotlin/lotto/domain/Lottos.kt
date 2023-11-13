package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    constructor (amount: Int) : this(generateLottoList(amount))

    fun getResult(winningLotto: Lotto, bonus: LottoNumber): List<Prize> {
        return lottoList.map {
            Prize.getPrize(it.matches(winningLotto), it.contains(bonus))
        }
    }

    companion object {
        private fun generateLottoList(amount: Int) = (1..amount).map { Lotto() }
    }
}
