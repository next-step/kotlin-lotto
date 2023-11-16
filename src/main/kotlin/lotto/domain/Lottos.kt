package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    fun getResult(winningLotto: Lotto, bonus: LottoNumber): List<Prize> {
        return lottoList.map {
            Prize.getPrize(it.matches(winningLotto), it.contains(bonus))
        }
    }

    companion object {
        fun generateLottoList(amount: Int) = (1..amount).map { Lotto() }
    }
}
