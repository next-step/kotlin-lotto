package lotto.domain

class Lottos(val lottoList: List<Lotto>) {
    fun getResult(winningLotto: Lotto, bonus: LottoNumber): List<Prize> {
        return lottoList.map {
            Prize.getPrize(it.matches(winningLotto), it.contains(bonus))
        }
    }

    companion object {
        private fun generateLottoList(amount: Int) = (1..amount).map { Lotto() }
        fun createWithMaunals(totalAmount: Int, manualLottoList: List<Lotto> = emptyList()): Lottos {
            val autoLottos = generateLottoList(totalAmount - manualLottoList.size)
            return Lottos(autoLottos + manualLottoList)
        }
    }
}
