package lotto

class LottoMachine {
    fun generate(lottoCount: Int): Lottos =
        Lottos((1..lottoCount).map { Lotto() })
}
