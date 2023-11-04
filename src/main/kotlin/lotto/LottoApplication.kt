package lotto

fun main() {
    LottoController(LottoShop(RandomLottoGenerator())).play()
}