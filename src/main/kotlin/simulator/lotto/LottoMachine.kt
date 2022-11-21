package simulator.lotto

class LottoMachine {
    fun create(times: Int): List<Lotto> {
        return List(times){
            Lotto.generate()
        }
    }
}