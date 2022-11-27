package lotto.domain

class Lotto(private val lotto:List<LottoBall>) {

    init {
        require(lotto.size == LOTTO_SIZE) {"비정상적인 로또입니다."}

    }

    companion object {
        private const val LOTTO_SIZE = 6
    }

}
