package simulator.lotto

class LottoMachine {
    fun create(money: Int): List<Lotto> {
        return List(money / LOTTO_PRICE){
            Lotto.generate()
        }
    }

    companion object{
        private const val LOTTO_PRICE = 1000
    }
}