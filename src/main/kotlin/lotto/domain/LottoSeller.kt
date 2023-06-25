package lotto.domain

interface LottoSeller {

    /**
     * 전달 받은 수만큼 로또를 판매한다.
     */
    fun sell(amount: Int): List<Lotto>
}
