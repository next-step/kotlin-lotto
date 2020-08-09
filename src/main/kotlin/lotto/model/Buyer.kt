package lotto.model

class Buyer(private val price: Int) {

    private val _autoLotto = mutableListOf<Lotto>()
    val autoLotto: List<Lotto> get() = _autoLotto

    private val _manualLotto = mutableListOf<Lotto>()
    val manualLotto: List<Lotto> get() = _manualLotto

    init {
        require(price >= Lotto.PRICE) {
            "로또 구매 금액이 부족합니다."
        }
    }

    fun buyLotto() {
        repeat((price / Lotto.PRICE) - manualLotto.size) {
            markLotto(Lotto.makeAuto())
        }
    }

    fun markLotto(markedLotto: Lotto) {
        _autoLotto.add(markedLotto)
    }

    fun setupManualLotto(manualLotto: List<Lotto>) {
        _manualLotto.addAll(manualLotto)
    }
}
