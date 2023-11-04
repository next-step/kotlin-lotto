package lotto_auto.lotto

object LottoAuto {
    fun createLotto(): List<Int> = (1..45).shuffled().subList(0, 6).sorted()
    fun createLottoList(count: Int): List<List<Int>> = (1..count).map {
        createLotto()
    }
}
