package lotto

class Machine(val price: Int) {
    val lottoCount = price / 1000

    val lottoList = (1..lottoCount).toList().map {
        Lotto()
    }
}
